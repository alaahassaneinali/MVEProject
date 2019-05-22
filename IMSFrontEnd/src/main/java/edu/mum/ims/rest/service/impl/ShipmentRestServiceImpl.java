package edu.mum.ims.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.ims.domain.Product;
import edu.mum.ims.domain.Shipment;
import edu.mum.ims.rest.RestHttpHeader;
import edu.mum.ims.rest.service.ShipmentRestService;

@Component
public class ShipmentRestServiceImpl  implements ShipmentRestService {

	@Autowired
	RestHttpHeader restHelper;
	
	String baseUrl = "http://localhost:8080/IMSBackEnd/shipments";
	String baseUrlExtended = baseUrl + "/";

	

	public void createShipment(Shipment shipment) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity<Shipment> httpEntity = new HttpEntity<Shipment>(shipment, restHelper.getHttpHeaders());
		restTemplate.postForObject(baseUrl, httpEntity, Product.class);

	}

}
