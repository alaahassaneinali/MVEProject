package edu.mum.ims.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.ims.domain.UserCredentials;


public interface UserCredentialsService {

	public void save(UserCredentials userCredentials);
 	public List<UserCredentials> findAll();
	public UserCredentials findOne(String id);
  }
