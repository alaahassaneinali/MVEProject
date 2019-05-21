package edu.mum.ims.amqp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Shipment;

public class ShipmentServiceImpl implements ShipmentService {

	@Override
	public void publish(RabbitTemplate rabbitTemplate) {

		List<Shipment> items = new ArrayList<Shipment>();
		Shipment item = new Shipment("Kazoo", 50, "The kazoo is a musical instrument");
		items.add(item);
		item = new Shipment("Hammer", 10, "hammer is a tool consisting of a weighted \"head\" fixed to a long handle");
		items.add(item);
		System.out.println("************* Shipping sent *********************::");
		for (Shipment publishedItem : items) {
			rabbitTemplate.convertAndSend("shipment", publishedItem);
			System.out.println();
			System.out.println(publishedItem.toString());
		}

	}

}
