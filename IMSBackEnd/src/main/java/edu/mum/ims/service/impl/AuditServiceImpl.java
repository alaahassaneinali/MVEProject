package edu.mum.ims.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.ims.dao.AuditRequestDao;
import edu.mum.ims.domain.AuditRequest;
import edu.mum.ims.service.AuditService;


@Service
public class AuditServiceImpl implements AuditService {
	@Autowired
	AuditRequestDao auditRequestDao;

	@Override
	public void doAudit(String uri, String type, String requestJson) {
		System.out.println(uri + " " + "type :" + type + " request" + requestJson);
		AuditRequest request = new AuditRequest();
		request.setUri(uri);
		request.setPayloadType(type);
		request.setPayload(requestJson);
		auditRequestDao.save(request);

	}

}
