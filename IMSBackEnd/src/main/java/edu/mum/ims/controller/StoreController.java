package edu.mum.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.ims.domain.Store;
import edu.mum.ims.service.StoreService;

@RestController
@RequestMapping({"/stores"})
public class StoreController {
	
	@Autowired
	private StoreService  storeService;


  	@RequestMapping("/{id}")
	public Store getStorerById(@PathVariable("id") Long id) {
  	
  		Store store = storeService.findOne(id);
  		return store;  
 
	}
		
 
}
