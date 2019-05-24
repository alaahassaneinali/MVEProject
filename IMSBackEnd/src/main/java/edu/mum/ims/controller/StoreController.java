package edu.mum.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.ims.domain.Store;
import edu.mum.ims.domain.User;
import edu.mum.ims.service.StoreService;

@RestController
@RequestMapping({"/stores"})
public class StoreController {
	
	@Autowired
	private StoreService  storeService;



	@RequestMapping("/all")
	public List<Store>  findAll( ) {

		List<Store> stores = storeService.findAll();
		return  stores;
 
	}
	
  	@RequestMapping("/{id}")
	public Store getStorerById(@PathVariable("id") Long id) {
  	
  		Store store = storeService.findOne(id);
  		return store;  
 
	}
		
 
}
