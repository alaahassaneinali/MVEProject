 
package edu.mum.integration;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import edu.mum.ims.domain.Shipment;
import edu.mum.ims.domain.RouteStandardShipment;

/**
 * Routes order based on order type.
 * 
 */
public class StandardShipmentTransformerImpl implements StandardShipmentTransformer {

     /**
     * Transform Order from AMQP to RouteOrder for JMS
      */
	@Transformer(inputChannel="fromImsShipmentChannel", outputChannel="processedStandardShipmentChannel")
	public RouteStandardShipment transformOrder(Shipment shipment) {
		
		RouteStandardShipment  routeStandardShipment = new RouteStandardShipment(shipment);
		System.out.println("============================");
		System.out.println(String.format("Transformed Shipment to Standard Shipment"));
		
		System.out.println("Shipment Number: " + routeStandardShipment.getShipment().getShipmentNumber() +
				" -- Shipping Company: + " + routeStandardShipment.getShipment().getShipComp());
		
		
		return routeStandardShipment;
	}

}
