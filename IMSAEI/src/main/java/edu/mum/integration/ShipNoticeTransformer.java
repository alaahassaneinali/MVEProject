 
package edu.mum.integration;


import edu.mum.ims.domain.Shipment;



/**
 * Routes order based on order type.
 * 
 */

public interface ShipNoticeTransformer {

	public Shipment transformShipNotice(Shipment shipment);

}
