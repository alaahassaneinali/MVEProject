package edu.mum.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.ims.domain.Shipment;
import edu.mum.ims.service.ShipmentNoticeService;



@RestController
@RequestMapping("/shipmentnotices")
public class ShipmentNoticeController {
	
	@Autowired
	private ShipmentNoticeService shipmentService;
 
 	@RequestMapping({"","/all"})
	public List<Shipment> list(Model model) {
		return  shipmentService.getAllShipmentNotices();
 
	}
	
// 	@RequestMapping("/{id}")
//	public Shipment getProductById( @PathVariable("id") Long shipmentId) {
//
//		return  null;
// 	}
	   
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void processAddNewProductForm(@RequestBody Shipment shipmentToBeAdded ) {
		System.out.println("in Post processAddNewProductForm");
			shipmentService.addShipment(shipmentToBeAdded); 
	}
}
