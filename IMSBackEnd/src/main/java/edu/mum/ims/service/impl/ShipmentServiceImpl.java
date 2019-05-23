package edu.mum.ims.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ims.amqp.QueueShipmentService;
import edu.mum.ims.dao.ShipmentNoticeDao;
import edu.mum.ims.domain.Shipment;
import edu.mum.ims.service.ShipmentService;

@Service
@Transactional 
public class ShipmentServiceImpl implements ShipmentService{

	@Autowired QueueShipmentService queueService;
	@Autowired ShipmentNoticeDao  shipmentNoticeDao;
	
	@Override
	public void sendShipment(Shipment shipment) {
		
		queueService.publish(shipment);
	}

	 	
}
