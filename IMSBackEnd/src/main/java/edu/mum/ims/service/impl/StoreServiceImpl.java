package edu.mum.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ims.dao.StoresDao;
import edu.mum.ims.dao.GenericDao;
import edu.mum.ims.dao.StoreDao;
import edu.mum.ims.domain.Address;
import edu.mum.ims.domain.Store;

@Service
@Transactional 
public class StoreServiceImpl implements edu.mum.ims.service.StoreService {
	
	
 	@Autowired
	private StoreDao storeDao;

    public void save( Store store) {  		
		storeDao.save(store);
	}
	
	
    public void update( Store store) {  		
		storeDao.update(store);
	}
	
	
	public List<Store> findAll() {
		return (List<Store>)storeDao.findAll();
	}

 	public Store findOne(Long id) {
		return storeDao.findOne(id);
	}


	
 
}
