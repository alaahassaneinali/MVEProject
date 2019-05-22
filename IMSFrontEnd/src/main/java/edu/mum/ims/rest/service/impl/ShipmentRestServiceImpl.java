package edu.mum.ims.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.ims.domain.Shipment;
import edu.mum.ims.rest.RestHttpHeader;
import edu.mum.ims.rest.service.ShipmentRestService;

@Component
public class ShipmentRestServiceImpl  implements ShipmentRestService {

	@Autowired
	RestHttpHeader restHelper;
	
	String baseUrl = "http://localhost:8080/IMSBackEnd/shipments";
	String baseUrlExtended = baseUrl + "/";

	public List<Shipment> findAll() {
		
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<Shipment[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Shipment[].class);	
 		List<Shipment> userList = Arrays.asList(responseEntity.getBody());
		return userList;
	}

	public Shipment findOne(Long index) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<Shipment> responseEntity = restTemplate.exchange(baseUrlExtended + index, HttpMethod.GET, httpEntity, Shipment.class);	
		Shipment shipment = responseEntity.getBody();
 		return shipment;
	}

	public Shipment save(Shipment shipment) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity<Shipment> httpEntity = new HttpEntity<Shipment>(shipment, restHelper.getHttpHeaders());
		shipment = restTemplate.postForObject(baseUrl, httpEntity, Shipment.class);
		return null;
	}

}
