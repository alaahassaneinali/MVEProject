package edu.mum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.support.GenericXmlApplicationContext;

import edu.mum.amqp.ItemService;
import edu.mum.amqp.ItemServiceImpl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AmqpProducerMain {
	
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/item-app-context.xml");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
       
       System.out.print("*************HIT RETURN To Send Shipment Notice to ShipmentNoticeQueue*********************::   ");
       System.out.println();
       try {
			in.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
   	
       RabbitTemplate itemTemplate =  context.getBean("shipmentNoticeTemplate",RabbitTemplate.class);
       ItemService itemService=new ItemServiceImpl(); 
       itemService.publish(itemTemplate);

   	System.out.print("*************Shipment Notice Number 1 sent to ShipmentNoticeQueue ******************::   ");
       System.out.println();
       System.out.println();
   

 
    }
}
