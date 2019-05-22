package edu.mum.ims.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.ims.domain.Shipment;
import edu.mum.ims.rest.service.ShipmentRestService;
import edu.mum.ims.service.ShipmentService;

@Service
public class ShipmentServiceImpl implements ShipmentService{
	
 	@Autowired

//   @Qualifier("MVC")
	private ShipmentRestService shipmentRestService;

	@Override
	public void createShipment(Shipment shipment) {
		shipmentRestService.createShipment(shipment);
	}
 

}
