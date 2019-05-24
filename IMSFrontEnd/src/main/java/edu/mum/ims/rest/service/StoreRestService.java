package edu.mum.ims.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.ims.domain.Store;

@Component
public interface StoreRestService {
	
	Store getStoreById(Long id);
	List<Store> getAll();

}
