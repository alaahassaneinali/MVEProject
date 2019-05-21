package edu.mum.ims.dao.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.ims.dao.ProductDao;
import edu.mum.ims.dao.ShipmentNoticeDao;
import edu.mum.ims.domain.Product;
import edu.mum.ims.domain.Shipment;

	@Repository
	public class ShipmentNoticeDaoImpl extends GenericDaoImpl<Shipment> implements ShipmentNoticeDao
	{
		public ShipmentNoticeDaoImpl() {
		super.setDaoType(Shipment.class );
		}

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
					
		}

		@Override
		public List<Shipment> getShipmentsByDescOrder() {
			// TODO Auto-generated method stub
			return null;
		}
		

 
	}

