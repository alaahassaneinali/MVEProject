package edu.mum.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.mum.ims.domain.Shipment;


public class WarehouseMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(WarehouseMessageListener.class);

    public void onMessage(Message message) {
    	System.out.println("Listener 1");
    	ObjectMessage objectMessage = (ObjectMessage) message;
        Shipment ship = null;
		try {
			ship = (Shipment) objectMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Shipment Notice Info: " );
        System.out.println("         Shipment Number: "  +    ship.getShipmentNumber());
        System.out.println("          DeliveryDate: "  +    ship.getDeliveryDate());
        System.out.println("          ShipmentDate: "  +    ship.getShipmentDate());
        System.out.println("          Service Company: "  +    ship.getShipComp());
    }
}
