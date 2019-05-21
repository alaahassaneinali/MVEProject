package edu.mum.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ims.dao.UserDao;
import edu.mum.ims.domain.User;
import edu.mum.ims.service.UserCredentialsService;

@Service
@Transactional
public class UserServiceImpl implements edu.mum.ims.service.UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	UserCredentialsService credentialsService;

	public void save(User member) {
		userDao.save(member);
	}

	public void update(User member) {
		userDao.update(member);
	}

	@Override
	public void saveFull(User member) {
		credentialsService.save(member.getUserCredentials());
		userDao.save(member);
	}

	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	
	public User findOne(Long id) {
		return userDao.findOne(id);
	}

	public User findOneFull(Long id) {
		User member = this.findOne(id);

// OR 		"SELECT p FROM Member m JOIN FETCH m.userCredentials WHERE m.id = (:id)"
		member.getUserCredentials();

		return member;
	}

}
