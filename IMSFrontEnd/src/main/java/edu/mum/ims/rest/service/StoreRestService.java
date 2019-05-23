package edu.mum.ims.rest.service;

import org.springframework.stereotype.Component;

import edu.mum.ims.domain.Shipment;
import edu.mum.ims.domain.Store;

@Component
public interface StoreRestService {
	
	Store getStoreById(Long id);

}
