package edu.mum.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.mum.ims.domain.RouteStandardShipment;


public class StandardShipmentMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(StandardShipmentMessageListener.class);

    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        RouteStandardShipment routeStandardShipment = null;
		try {
			routeStandardShipment = (RouteStandardShipment) objectMessage.getObject();
		} catch (JMSException e) {
	
			e.printStackTrace();
		}
        System.out.println("Shipping Center: Standard Shipment - Message received: \n" + 
					"Shipment Number: " + routeStandardShipment.getShipment().getShipmentNumber() +
					" -- Shipping Company: + " + routeStandardShipment.getShipment().getShipComp());

    }
}
