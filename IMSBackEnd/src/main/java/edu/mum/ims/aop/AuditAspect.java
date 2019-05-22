package edu.mum.ims.aop;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mum.ims.domain.Product;
import edu.mum.ims.domain.User;
import edu.mum.ims.service.AuditService;

@Aspect
@Component
public class AuditAspect {

	@Autowired
	AuditService auditService;
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping))")
	public void doAudit() {
		
	}
	
	@Before("doAudit() && args(user, request)")
	public void doUserAudit(User user, HttpServletRequest request) {
				ObjectMapper objectMapper = new ObjectMapper();
		String requestJson = "";
		try {
			requestJson = objectMapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			//log
		}
		auditService.doAudit(request.getRequestURI(), User.class.getName(),requestJson );
	}
	

	@Before("doAudit() && args(product, request)")
	public void doProductAudit(Product product, HttpServletRequest request) {
				ObjectMapper objectMapper = new ObjectMapper();
		String requestJson = "";
		try {
			requestJson = objectMapper.writeValueAsString(product);
		} catch (JsonProcessingException e) {
			//log
		}
		auditService.doAudit(request.getRequestURI(), Product.class.getName(),requestJson );
	}

}
