 
package edu.mum.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.mum.ims.domain.Shipment;
import edu.mum.ims.domain.ShipmentComp;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

/**
 * Routes order based on order type.
 * 
 */
@MessageEndpoint
public class ShipNoticeRouter {

    final Logger logger = LoggerFactory.getLogger(ShipNoticeRouter.class);
    
    /**
     * Process order.  Routes based on whether or 
     * not the order is a delivery or pickup.
     */
	@Router(inputChannel="processShipmentNotice")
	public String processItem(Shipment shipment) {
		
	    String destination = null;
	    
  	    if(shipment.getShipComp().equals(ShipmentComp.FEDEX)) {
  	    	destination = "FEDEX";
  	    }else {
  	    	destination = "DHL";
  	    }

		return destination;
		
	}

}
