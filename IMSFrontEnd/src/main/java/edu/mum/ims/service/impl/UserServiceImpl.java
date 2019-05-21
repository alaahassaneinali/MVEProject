package edu.mum.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.ims.domain.User;
import edu.mum.ims.rest.service.UserRestService;
import edu.mum.ims.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
 	@Autowired
	private UserRestService memberRestService;

     public void save( User user) {  		
    	memberRestService.save(user);
	}
		
    @Override
   	public void saveFull( User user) {  		
//  		credentialsService.save(member.getUserCredentials());
  		memberRestService.save(user);
	}
  	

	public List<User> findAll() {
		return (List<User>)memberRestService.findAll();
	}

 
	public User findOne(Long id) {
		return memberRestService.findOne(id);
	}
	
 
	
 }
