package edu.mum.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WarehouseMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(WarehouseMessageListener.class);

    public void onMessage(Message message) {
    	System.out.println("Listener 2");
       
    }
}
