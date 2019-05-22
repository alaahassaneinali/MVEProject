package edu.mum.amqp;

import edu.mum.ims.domain.Shipment;
import edu.mum.ims.domain.ShipmentComp;
import edu.mum.ims.domain.ShipmentItem;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class ItemServiceImpl implements ItemService {

    public void publish(RabbitTemplate rabbitTemplate) {
    	
    	Shipment ship1 = new Shipment();
      	ship1.setShipmentNumber("1");
    	ship1.setVersion(1);    
    	ship1.setDeliveryDate("2019-05-20");
    	ship1.setShipmentDate("2019-05-22");
    	ship1.setShipComp(ShipmentComp.FEDEX);      	
    	
        rabbitTemplate.convertAndSend(ship1);
         
    	      
        

 
    }
}
