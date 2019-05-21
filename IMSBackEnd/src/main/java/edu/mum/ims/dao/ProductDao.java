package edu.mum.ims.dao;


import java.util.List;

import edu.mum.ims.domain.Product;


	public interface ProductDao extends GenericDao<Product>  
	{
	  Product getProductByProductId(String key);
	
		public List<Product> getAllProducts();
 	
	    Product getProductById(String key);
		
		List<Product> getProductsByCategory(String category);

  
		List<Product> getProductsByDescOrder();

 
	}

