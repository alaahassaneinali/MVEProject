 
package edu.mum.integration;

import org.springframework.integration.annotation.Transformer;

import edu.mum.ims.domain.Shipment;




/**
 * Routes order based on order type.
 * 
 */
public class ShipNoticeTransformerImpl implements ShipNoticeTransformer {

     /**
     * Transform Order from AMQP to RouteOrder for JMS
      */
	@Transformer(inputChannel="fromAmqpShipmentNotice", outputChannel="processShipmentNotice")
	public Shipment transformShipNotice(Shipment shipment) {
       String shipNo=shipment.getShipmentNumber();
	shipment.setShipmentNumber(shipNo);
	  
		return shipment;
	}

}
