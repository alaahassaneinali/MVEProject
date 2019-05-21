package edu.mum.ims.service;

import java.util.List;

import edu.mum.ims.domain.User;
 
public interface UserService {

	public void save(User user);
	public void update(User user);
   	public void saveFull( User user);  		

	public List<User> findAll();
	public User findOne(Long id);
	public User findOneFull(Long id);
	
		
}
