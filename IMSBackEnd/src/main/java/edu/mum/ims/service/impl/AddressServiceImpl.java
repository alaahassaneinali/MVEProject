package edu.mum.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ims.dao.StoresDao;
import edu.mum.ims.dao.GenericDao;
import edu.mum.ims.domain.Address;

@Service
@Transactional 
public class AddressServiceImpl implements edu.mum.ims.service.AddressService {
	
	
 	@Autowired
	private StoresDao memberDao;

    public void save( Address address) {  		
		memberDao.save(address);
	}
	
	
    public void update( Address address) {  		
		memberDao.update(address);
	}
	
	
	public List<Address> findAll() {
		return (List<Address>)memberDao.findAll();
	}

 	public Address findOne(Long id) {
		return memberDao.findOne(id);
	}


	
 
}
