package edu.mum.ims.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.ims.dao.StoresDao;
import edu.mum.ims.domain.Address;


@SuppressWarnings("unchecked")
@Repository
public class AddressDaoImpl extends GenericDaoImpl<Address> implements StoresDao {

	public AddressDaoImpl() {
		super.setDaoType(Address.class );
		}

 
 }