package edu.mum.ims.dao;


import java.util.List;

import edu.mum.ims.domain.Product;
import edu.mum.ims.domain.Shipment;


	public interface ShipmentNoticeDao extends GenericDao<Shipment>  
	{
		List<Shipment> getAllShipmentNotices();
		Shipment getShipmentByNumber(String shipmentNumber);
	 	void addShipment(Shipment shipment); 
		List<Shipment> getShipmentsByDescOrder();

 
	}

