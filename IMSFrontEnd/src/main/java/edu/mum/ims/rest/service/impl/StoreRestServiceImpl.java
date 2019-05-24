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
import edu.mum.ims.domain.Shipment;
import edu.mum.ims.domain.Store;
import edu.mum.ims.domain.User;
import edu.mum.ims.rest.RestHttpHeader;
import edu.mum.ims.rest.service.ShipmentRestService;
import edu.mum.ims.rest.service.StoreRestService;

@Component
public class StoreRestServiceImpl  implements StoreRestService {

	@Autowired
	RestHttpHeader restHelper;
	
	String baseUrl = "http://localhost:8080/IMSBackEnd/stores";
	String baseUrlExtended = baseUrl + "/";

	

	@Override
	public Store getStoreById(Long id) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<Store> responseEntity = restTemplate.exchange(baseUrlExtended + id, HttpMethod.GET, httpEntity,
				Store.class);
		Store store = responseEntity.getBody();
		return store;
	}



	@Override
	public List<Store> getAll() {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<Store[]> responseEntity = restTemplate.exchange(baseUrlExtended + "all", HttpMethod.GET, httpEntity,
				Store[].class);
		List<Store> stores = Arrays.asList(responseEntity.getBody());
		return stores;
	}

}
