package edu.mum.ims.dao.impl;

 

import org.springframework.stereotype.Repository;

import edu.mum.ims.dao.StoreDao;
import edu.mum.ims.domain.Store;


@Repository
public class StoreDaoImpl extends GenericDaoImpl<Store> implements StoreDao {

	public StoreDaoImpl() {
		super.setDaoType(Store.class );
		}

 
 }