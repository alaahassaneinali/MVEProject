package edu.mum.ims.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.mum.ims.domain.Product;
import edu.mum.ims.domain.Shipment;
import edu.mum.ims.domain.ShipmentComp;
import edu.mum.ims.domain.ShipmentItem;
import edu.mum.ims.domain.Store;
import edu.mum.ims.service.ProductService;
import edu.mum.ims.service.ShipmentService;
import edu.mum.ims.service.StoreService;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {

	@Autowired
	private ProductService productService;

	@Autowired
	ShipmentService shipmentService;

	@Autowired
	StoreService storeService;

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public String getCreateShipmentForm(Model model, @PathVariable("productId") Long productId,
			@ModelAttribute("newShipment") Shipment newShipment) {

		model.addAttribute("productId", productId);
		
		//Get stores from DB
		List<Store> stores = storeService.getAll();
		model.addAttribute("stores", stores);
		
		//Shipping Services are -pre-defined as enum. 
		List<String> shippingServices =  new ArrayList<String>();
		shippingServices.add(ShipmentComp.DHL.toString());
		shippingServices.add(ShipmentComp.FEDEX.toString());
		shippingServices.add(ShipmentComp.USPS.toString());
		
		model.addAttribute("shippingServices", shippingServices);
		
		
		
		return "createShipment";
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.POST)
	public String createShipment(@ModelAttribute("newShipment") @Valid Shipment newShipment,
			@PathVariable("productId") Long productId, BindingResult result) {

		if (result.hasErrors()) {
			return "createShipment";
		} else {
			try {
				Product product = productService.findOne(productId);
				ShipmentItem shipmentItem = new ShipmentItem();
				shipmentItem.setProduct(product);
				shipmentItem.setQuantity(newShipment.getQuantity());
				newShipment.getItems().add(shipmentItem);

				Store store = storeService.getStoreById(newShipment.getStore().getId());
				
				//Don't need to send user info
				store.getAddress().setUser(null);
				newShipment.setStore(store);
				shipmentService.createShipment(newShipment);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

		return "redirect:/products";
	}

}
