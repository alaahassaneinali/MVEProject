package edu.mum.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.mum.ims.domain.Shipment;




public class Warehouse2MessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(Warehouse2MessageListener.class);

    public void onMessage(Message message) {
    	System.out.println("Listener 2");
    	
    	ObjectMessage objectMessage = (ObjectMessage) message;
        Shipment ship = null;
		try {
			ship = (Shipment) objectMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Shipment Info: " );
        System.out.println("         Shipment Number: "  +    ship.getShipmentNumber());

    }
}
