package edu.mum.ims.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.ims.dao.UserDao;
import edu.mum.ims.domain.User;

@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super.setDaoType(User.class);
	}

}