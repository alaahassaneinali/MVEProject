package edu.mum.ims.service;

import java.util.List;

import edu.mum.ims.domain.Store;
 
public interface StoreService {

	public void save(Store Store);
	public void update(Store store);
	public List<Store> findAll();
 
	public Store findOne(Long id);

}
