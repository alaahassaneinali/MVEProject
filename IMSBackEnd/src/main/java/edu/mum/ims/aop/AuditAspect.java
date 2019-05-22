package edu.mum.ims.aop;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mum.ims.domain.User;
import edu.mum.ims.service.AuditService;

@Aspect
public class AuditAspect {

	@Autowired
	AuditService auditService;
	
	@Pointcut("execution(* edu.mum.ims.controller..*(..))")
	public void doAudit() {
		
	}
	
	
	@Before("doAudit() && args(user, request)")
	public void doUserAudit(User user, HttpServletRequest request, Joinpoint joinPoint) {
		
		System.out.println("test inside");
		ObjectMapper objectMapper = new ObjectMapper();
		String requestJson = "";
		try {
			requestJson = objectMapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			//log
		}
		auditService.doAudit(request.getRequestURI(), User.class.getName(),requestJson );
	}

}
