  

package edu.mum.ims.domain;


import java.io.Serializable;

@SuppressWarnings("serial")
public class RouteJsonShipment  implements Serializable {
	
	private RouteStandardShipment routeStandardShipment;
    public RouteJsonShipment(RouteStandardShipment routeStandardShipment ) {
    	this.routeStandardShipment  = routeStandardShipment;
    	
    }
	
	public RouteStandardShipment getRouteStandardShipment() {
		return routeStandardShipment;
	}

	public void setRouteStandardShipment(RouteStandardShipment routeStandardShipment) {
		this.routeStandardShipment = routeStandardShipment;
	}

	@Override
	public String toString() {
		return "routeShipment: " + routeStandardShipment.toString();
	}
	

  }
