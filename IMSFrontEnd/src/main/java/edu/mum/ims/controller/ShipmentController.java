package edu.mum.ims.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.ims.domain.Address;
import edu.mum.ims.domain.Product;
import edu.mum.ims.domain.Shipment;
import edu.mum.ims.domain.ShipmentItem;
import edu.mum.ims.domain.Store;
import edu.mum.ims.service.ProductService;
import edu.mum.ims.service.ShipmentService;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	ShipmentService shipmentService;
	
	
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public String getCreateShipmentForm(Model model, @PathVariable("productId") Long productId,
			@ModelAttribute("newShipment") Shipment newShipment) {

		model.addAttribute("productId", productId);
		return "createShipment";
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.POST)
	public String processCreateShipment(@ModelAttribute("newProduct") @Valid Shipment newShipment,
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
				
				/*
				 * For integration. should get from db
				 */
				Address address = new Address();
				address.setId(1);
				address.setCity("Fairfield");
				address.setState("IA");
				address.setStreet("1000 N 4th Street");
				address.setZipCode("52556");
				
				Store store = new Store();
				store.setId(1);
				store.setName("Fairfield Walmart");
				store.setAddress(address);
				
				newShipment.setStore(store);
			
				
				shipmentService.createShipment(newShipment);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

		return "redirect:/products";
	}

}
