package edu.mum.ims.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.ims.domain.Product;
import edu.mum.ims.rest.RestHttpHeader;
import edu.mum.ims.rest.service.ProductRestService;

@Component("Jersey")
public class ProductJerseyRestServiceImpl  implements ProductRestService {

	@Autowired
	RestHttpHeader restHelper;
	
	public List<Product> findAll() {
		
		RestTemplate restTemplate = restHelper.getRestTemplate();
 		return Arrays.asList(restTemplate.exchange("http://localhost:8080/JerseyRestSecurity/products/", 
 				      HttpMethod.GET, restHelper.getHttpEntity(), Product[].class).getBody());
                                      //restHelper.getHttpEntity() - get HTTP headers [Authentication; JSON ACCEPT]
	}

	public Product findOne(Long index) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		return (restTemplate.exchange("http://localhost:8080/JerseyRestSecurity/products/"+ index, 
				        HttpMethod.GET, restHelper.getHttpEntity(), Product.class).getBody());
                                                                  // Returns Product in Body HTTP Message 
 	}

	public Product save(Product product) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity<Product> httpEntity = new HttpEntity<Product>(product, restHelper.getHttpHeaders());
  		restTemplate.postForObject("http://localhost:8080/JerseyRestSecurity/products/",
  				                     httpEntity, Product.class);
                                             // Product.class - Response type
		return null;
	}

 
}
