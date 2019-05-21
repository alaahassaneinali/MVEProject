package edu.mum.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ims.dao.ProductDao;
import edu.mum.ims.dao.ShipmentNoticeDao;
import edu.mum.ims.domain.Shipment;
import edu.mum.ims.service.ShipmentNoticeService;

@Service
@Transactional 
public class ShipmentNoticeServiceImpl implements ShipmentNoticeService{

 	@Autowired
	private ShipmentNoticeDao shipmentNoticDao;
	@Override
	public List<Shipment> getAllShipmentNotices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shipment getShipmentByNumber(String shipmentNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addShipment(Shipment shipment) {
		// TODO Auto-generated method stub
		shipmentNoticDao.save(shipment);
		
	}

	@Override
	public List<Shipment> getShipmentsByDescOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
