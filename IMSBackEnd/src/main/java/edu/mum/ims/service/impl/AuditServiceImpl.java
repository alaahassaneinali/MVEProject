package edu.mum.ims.service.impl;

import edu.mum.ims.service.AuditService;

public class AuditServiceImpl implements AuditService {

	@Override
	public void doAudit(String uri, String type, String requestJson) {
		System.out.println(uri + " " + "type :" + type + " request" + requestJson);

	}

}
