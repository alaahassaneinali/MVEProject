  

package edu.mum.ims.domain;


import java.io.Serializable;

@SuppressWarnings("serial")
public class RouteStandardShipment  implements Serializable {
	
	private Shipment shipment;
	
	public RouteStandardShipment(Shipment shipment)
	{
		this.shipment = shipment;
	}
   
	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	@Override
	public String toString() {
		return "RouteStandardShipment: " + shipment.toString();
	}
	
	

  }
