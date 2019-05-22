package edu.mum.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ims.domain.Product;
import edu.mum.ims.rest.service.ProductRestService;
import edu.mum.ims.rest.service.impl.ProductRestServiceImpl;
import edu.mum.ims.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
 	@Autowired
// 	@Qualifier("Jersey")
   @Qualifier("MVC")
	private ProductRestService productRestService;

	public List<Product> findAll() {
		return productRestService.findAll();
	}

 
 	public void addProduct(Product product) {
 		productRestService.save(product);
	}
	
	public Product findOne(long productID) {
		return productRestService.findOne(productID);
	}

 

}
