package edu.mum.ims.rest.service;

import org.springframework.stereotype.Component;

import edu.mum.ims.domain.Shipment;

@Component
public interface ShipmentRestService {
	
	void createShipment(Shipment shipment);

}
