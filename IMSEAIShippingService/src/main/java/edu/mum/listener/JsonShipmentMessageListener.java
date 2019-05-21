package edu.mum.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.mum.ims.domain.RouteJsonShipment;


public class JsonShipmentMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(JsonShipmentMessageListener.class);

    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        RouteJsonShipment routeJsonShipment = null;
		try {
			routeJsonShipment = (RouteJsonShipment) objectMessage.getObject();
		} catch (JMSException e) {
	
			e.printStackTrace();
		}
        System.out.println("Shipping Service: Shipment in JSON - Message received: \n" + 
        					"Shipment Number: " + routeJsonShipment.getRouteStandardShipment().getShipment().getShipmentNumber() +
        					" -- Shipping Company: + " + routeJsonShipment.getRouteStandardShipment().getShipment().getShipComp());
		
    }
  
}
