package edu.mum.ims.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.ims.domain.User;
import edu.mum.ims.rest.RestHttpHeader;
import edu.mum.ims.rest.service.UserRestService;

@Component
public class UserRestServiceImpl implements UserRestService {

	@Autowired
	RestHttpHeader restHelper;

	String baseUrl = "http://localhost:8080/IMSBackEnd/users";
	String baseUrlExtended = baseUrl + "/";

	public List<User> findAll() {

		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<User[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity,
				User[].class);
		List<User> userList = Arrays.asList(responseEntity.getBody());
		return userList;
	}

	public User findOne(Long id) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<User> responseEntity = restTemplate.exchange(baseUrlExtended + id, HttpMethod.GET, httpEntity,
				User.class);
		User user = responseEntity.getBody();
		return user;
	}

	public User save(User user) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity<User> httpEntity = new HttpEntity<User>(user, restHelper.getHttpHeaders());
		user = restTemplate.postForObject(baseUrl, httpEntity, User.class);
		return null;
	}

}
