package edu.mum.ims.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface ShipmentService {
	
	public void publish(RabbitTemplate rabbitTemplate);
 

}
