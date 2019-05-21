 
package edu.mum.integration;

import org.springframework.integration.annotation.Transformer;
import edu.mum.ims.domain.Shipment;
import edu.mum.ims.domain.RouteStandardShipment;
import edu.mum.ims.domain.RouteJsonShipment;

/**
 * Routes order based on order type.
 * 
 */
public class JsonShipmentTransformerImpl implements JsonShipmentTransformer {

	@Transformer(inputChannel="highPriceAuctionItemChannel", outputChannel="JsonShipmentChanel")
	public RouteJsonShipment transformShipment(RouteStandardShipment routeStandardShipment) {
		
		RouteJsonShipment  routeJsonShipment = new RouteJsonShipment(routeStandardShipment);
		System.out.println("============================");
		System.out.println(String.format("Transformed Shipment to JSON Shipment"));
		
		System.out.println("Shipment Number: " + routeStandardShipment.getShipment().getShipmentNumber() +
				" -- Shipping Company: + " + routeStandardShipment.getShipment().getShipComp());
		
		return routeJsonShipment;
	}

}
