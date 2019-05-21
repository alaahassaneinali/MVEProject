 
package edu.mum.integration;

import edu.mum.ims.domain.RouteStandardShipment;
import edu.mum.ims.domain.RouteJsonShipment;

/**
 * Routes order based on order type.
 * 
 */

public interface JsonShipmentTransformer {

	public RouteJsonShipment transformShipment(RouteStandardShipment auctionItem);

}
