package edu.mum.amqp;

import edu.mum.ims.domain.Shipment;
import edu.mum.ims.domain.ShipmentComp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class ItemServiceImpl implements ItemService {

    public void publish(RabbitTemplate rabbitTemplate) {
    	
    	System.out.println("************* Shipping sent *********************::");
	
		
    	Shipment ship1 = new Shipment();
    	ship1.setShipmentNumber("1");
    	ship1.setVersion(1); 
    	ship1.setShipComp(ShipmentComp.USPS);
        rabbitTemplate.convertAndSend(ship1);
    
		System.out.println();
		System.out.println("Shipment Number: " + ship1.getShipmentNumber() +
							" -- Shipping Company: + " + ship1.getShipComp());
		
    	Shipment ship2 = new Shipment();
    	ship2.setShipmentNumber("2");
    	ship2.setVersion(2);
    	ship2.setShipComp(ShipmentComp.DHL);
        rabbitTemplate.convertAndSend(ship2);
        
    	System.out.println();
		System.out.println("Shipment Number: " + ship2.getShipmentNumber() +
							" -- Shipping Company: + " + ship2.getShipComp());
 
    }
}
