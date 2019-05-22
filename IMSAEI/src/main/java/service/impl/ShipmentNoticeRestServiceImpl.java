package service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import edu.mum.ims.domain.Shipment;
import edu.mum.rest.RestHttpHeader;
import service.ShipmentNoticeRestService;


@Service
public class ShipmentNoticeRestServiceImpl implements ShipmentNoticeRestService{

	@Autowired
	RestHttpHeader remoteApi;


	public Shipment save(Shipment shipment) {
		try {

		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<Shipment> httpEntity = new HttpEntity<Shipment>(shipment, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/IMSBackEnd/shipmentnotices/add", httpEntity, Shipment.class);
 		}
		catch (RestClientException exce) {
			System.out.println("ERROR: " + exce.getMessage());
		}
		return shipment;
	}

}
