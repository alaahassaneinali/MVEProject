package edu.mum.amqp;

import edu.mum.ims.domain.Shipment;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class ItemServiceImpl implements ItemService {

    public void publish(RabbitTemplate rabbitTemplate) {
    	
    	Shipment ship1 = new Shipment();
    	ship1.setShipmentNumber("1");
    	ship1.setVersion(1);    
        rabbitTemplate.convertAndSend(ship1);
         
    	Shipment ship2 = new Shipment();
    	ship2.setShipmentNumber("2");
    	ship2.setVersion(2);    
        rabbitTemplate.convertAndSend(ship2);
             
        
        
//    	// Dummy up an order
//    	// First need a Product:
//    	Item item1 = new Item("Kazoo","Description Kazooo");
//    	item1.setPrice(22);
//    
//        rabbitTemplate.convertAndSend(item1);
//         
//        Item item2 = new Item("Hammer","Description Hammer");
//        item2.setPrice(11);
//        
//        rabbitTemplate.convertAndSend(item2);       
       
    	
    	 
//    	// Dummy up an order
//    	// First need a Product:
//    	Product product = new Product("Kazoo", "a Hummer", 2);
//    	// Order 2 of them
//    	OrderItem orderItem = new OrderItem(2, product);
//    	// Make a list of the orderItems [ only 1]
//    	List<OrderItem> orderItems = new ArrayList<OrderItem>();
//        orderItems.add(orderItem);
// 
//        OrderPayment orderPayment = new OrderPayment();
//        // Create order...
//        Order order = new Order("123",orderItems,orderPayment);
//        rabbitTemplate.convertAndSend(order);
//         
//    	// Dummy up a  SECOND order - simply change the product name
//        order.getItems().get(0).getProduct().setName("Water Balloon");
//        rabbitTemplate.convertAndSend(order);
// 
 
    }
}
