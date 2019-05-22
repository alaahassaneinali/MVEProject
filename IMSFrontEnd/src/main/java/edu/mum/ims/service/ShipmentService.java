package edu.mum.ims.service;

import java.util.List;

import edu.mum.ims.domain.Shipment;

public interface ShipmentService {

	List<Shipment> findAll();

 	void addShipment(Shipment shipment);

	Shipment findOne(long id); 

}
