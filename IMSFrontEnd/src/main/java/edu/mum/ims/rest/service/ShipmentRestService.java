package edu.mum.ims.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.ims.domain.Shipment;

@Component
public interface ShipmentRestService {

 	public List<Shipment> findAll();

	public Shipment findOne(Long index);

	public Shipment save(Shipment shipment);

}
