package edu.mum.ims.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.ims.domain.Shipment;
import edu.mum.ims.domain.Store;
import edu.mum.ims.rest.service.ShipmentRestService;
import edu.mum.ims.rest.service.StoreRestService;
import edu.mum.ims.service.ShipmentService;
import edu.mum.ims.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{
	
 	@Autowired
	private StoreRestService storeRestService;

	@Override
	public Store getStoreById(Long id) {

		return storeRestService.getStoreById(id);
	}
	
}
