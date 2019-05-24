package edu.mum.ims.service;

import java.util.List;

import edu.mum.ims.domain.Store;

public interface StoreService {


 	Store getStoreById(Long id);
 	List<Store> getAll();

	
}
