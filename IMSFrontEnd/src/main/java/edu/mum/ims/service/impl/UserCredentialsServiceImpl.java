package edu.mum.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ims.domain.UserCredentials;
import edu.mum.ims.rest.service.UserCredentialsRestService;

@Service
public class UserCredentialsServiceImpl implements edu.mum.ims.service.UserCredentialsService {
	
 // Kludge for Authenticating on REST  - used in RestHttpHeader & LoginController
	@Autowired
	private UserCredentialsRestService userCredentialsRestService;
	
 	private UserCredentials userCredentials  = new UserCredentials();	
 	
    public UserCredentials getUserCredentials() {
		return userCredentials;
	}
	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}


	public void save( UserCredentials userCredentials) {  		
 		userCredentialsRestService.save(userCredentials);
	}
 	
   	
	public List<UserCredentials> findAll() {
		return (List<UserCredentials>)userCredentialsRestService.findAll();
	}
	
	public UserCredentials findOne(String id){
		this.userCredentials = userCredentialsRestService.findOne(id);
		return this.userCredentials;
	}

 

 
 
}
