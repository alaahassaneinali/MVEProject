package edu.mum.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.ims.domain.Shipment;
import edu.mum.ims.rest.service.ShipmentRestService;
import edu.mum.ims.service.ShipmentService;

@Service
public class ShipmentServiceImpl implements ShipmentService{
	@Autowired
	private ShipmentRestService shipmentRestService;

	public List<Shipment> findAll() {
		return shipmentRestService.findAll();
	}

 
 	public void addShipment(Shipment shipment) {
 		shipmentRestService.save(shipment);
	}
	
	public Shipment findOne(long shipmentID) {
		return shipmentRestService.findOne(shipmentID);
	}

 

}
