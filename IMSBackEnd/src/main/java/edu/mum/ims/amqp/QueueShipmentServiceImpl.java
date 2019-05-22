package edu.mum.ims.amqp;

import edu.mum.ims.domain.Shipment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class QueueShipmentServiceImpl implements QueueShipmentService {

	@Override
	public void publish(Shipment shipment) {
		try {
			ApplicationContext context = new GenericXmlApplicationContext(
					"classpath:context/producer-app-context.xml");
			RabbitTemplate directTemplate = context.getBean("directTemplate", RabbitTemplate.class);
			directTemplate.convertAndSend("shipment", shipment);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
