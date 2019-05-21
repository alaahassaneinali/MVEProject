 
package edu.mum.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.mum.ims.domain.Shipment;

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
	    
  	    if(shipment.getShipmentNumber().equals("1")) {
  	    	destination = "shipCompany1";
  	    }else {
  	    	destination = "shipCompany2";
  	    }

		return destination;
		
	}

}
