 
package edu.mum.integration;

import edu.mum.ims.domain.Shipment;
import edu.mum.ims.domain.RouteStandardShipment;

/**
 * Routes order based on order type.
 * 
 */

public interface StandardShipmentTransformer {

	public RouteStandardShipment transformOrder(Shipment shipment);

}
