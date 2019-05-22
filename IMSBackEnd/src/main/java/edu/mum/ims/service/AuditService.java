package edu.mum.ims.service;

public interface AuditService {
	void doAudit(String uri, String type, String requestJson);
}
