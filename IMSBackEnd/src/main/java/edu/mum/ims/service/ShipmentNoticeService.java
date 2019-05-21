package edu.mum.ims.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import edu.mum.ims.domain.Shipment;
public interface ShipmentNoticeService {

	List<Shipment> getAllShipmentNotices();
	Shipment getShipmentByNumber(String shipmentNumber);
 	void addShipment(Shipment shipment); 
	List<Shipment> getShipmentsByDescOrder();
}
