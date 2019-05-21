package edu.mum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.mum.amqp.ItemService;
import edu.mum.amqp.ItemServiceImpl;

public class AmqpProducerMain {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext(
				"classpath:META-INF/spring/producer-app-context.xml");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println();
		System.out.print("*************Hit RETURN To Send Shipments*********************::   ");
		System.out.println();

		try {
			in.readLine();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		RabbitTemplate directTemplate = context.getBean("directTemplate", RabbitTemplate.class);
		ItemService itemService = new ItemServiceImpl();
		itemService.publish(directTemplate);

	}
}
