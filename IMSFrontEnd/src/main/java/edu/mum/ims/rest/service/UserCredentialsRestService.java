package edu.mum.ims.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.ims.domain.UserCredentials;

@Component
public interface UserCredentialsRestService {

 	public List<UserCredentials> findAll();

	public UserCredentials findOne(String index);

	public UserCredentials save(UserCredentials member);

}
