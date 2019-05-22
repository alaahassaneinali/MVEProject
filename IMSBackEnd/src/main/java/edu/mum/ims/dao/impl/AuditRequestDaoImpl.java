package edu.mum.ims.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.ims.dao.AuditRequestDao;
import edu.mum.ims.domain.AuditRequest;
 

@Repository
public class AuditRequestDaoImpl extends GenericDaoImpl<AuditRequest> implements AuditRequestDao {

	public AuditRequestDaoImpl() {
		super.setDaoType(AuditRequest.class);
	}

}