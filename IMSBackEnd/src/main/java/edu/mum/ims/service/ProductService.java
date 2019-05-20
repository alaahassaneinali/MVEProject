package edu.mum.ims.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.ims.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(String productID);
	
	List<Product> getProductsByCategory(String category);

 	void addProduct(Product product);

	Product get(long id);
 
	List<Product> getProductsByDescOrder();

	public Product getWithCategory(long productID);
}
