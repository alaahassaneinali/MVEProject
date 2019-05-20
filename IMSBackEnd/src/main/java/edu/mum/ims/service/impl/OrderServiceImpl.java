package edu.mum.ims.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.ims.dao.ProductDao;
import edu.mum.ims.domain.Product;
import edu.mum.ims.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private ProductDao productRepository;
	
	public void processOrder(String productId, long quantity) {
		Product productById = productRepository.getProductByProductId(productId);
		
 //		productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
	}
}
