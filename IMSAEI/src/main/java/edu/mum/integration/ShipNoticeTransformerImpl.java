 
package edu.mum.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import edu.mum.ims.domain.Shipment;
import edu.mum.rest.RestHttpHeader;
import service.ShipmentNoticeRestService;


/**
 * Routes order based on order type.
 * 
 */
//@Component
public class ShipNoticeTransformerImpl implements ShipNoticeTransformer {

//	@Autowired
//	ShipmentNoticeRestService shipmentNoticeRestService;
     /**
     * Transform Order from AMQP to RouteOrder for JMS
      */
	@Transformer(inputChannel="fromAmqpShipmentNotice", outputChannel="processShipmentNotice")
	public Shipment transformShipNotice(Shipment shipment) {

		
		save(shipment);
	  
		return shipment;
	}
	
	public Shipment save(Shipment shipment) {
		try {
			RestHttpHeader remoteApi= new RestHttpHeader();
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
