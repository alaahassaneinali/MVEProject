 
package edu.mum.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.mum.ims.domain.Shipment;
import edu.mum.ims.domain.ShipmentComp;
import edu.mum.ims.domain.RouteStandardShipment;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

/**
 * Routes order based on order type.
 * 
 */
@MessageEndpoint
public class ShipmentRouter {

    final Logger logger = LoggerFactory.getLogger(ShipmentRouter.class);
    
    @Router()
	public String routeShipment(RouteStandardShipment routeStandardShipment) {
	    String destination = null;
	    
	    if(routeStandardShipment.getShipment().getShipComp() == ShipmentComp.USPS ) {
	    	destination = "jsonShipmentChannel";
	    	
	    	System.out.println("============================");
			System.out.println(String.format("Route Shipment %s to jsonShipmentChannel", routeStandardShipment.getShipment().getShipmentNumber()));
			System.out.println();
	    	
	    }else {
	    	destination = "deliveryStandardShipmentChannel";
			System.out.println("============================");
			System.out.println(String.format("Route Shipment %s to deliveryStandardShipmentChannel", routeStandardShipment.getShipment().getShipmentNumber()));
			System.out.println();
	    }
   	
		return destination;
	}

}
