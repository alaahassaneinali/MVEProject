package edu.mum.ims.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.ims.domain.Product;

@Component
public interface ProductRestService {

 	public List<Product> findAll();

	public Product findOne(Long index);

	public Product save(Product product);

}
