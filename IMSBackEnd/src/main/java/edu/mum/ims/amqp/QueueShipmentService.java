package edu.mum.ims.amqp;

import edu.mum.ims.domain.Shipment;

public interface QueueShipmentService {
	
	public void publish(Shipment shipment);
 
}
