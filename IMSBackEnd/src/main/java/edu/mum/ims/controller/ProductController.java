package edu.mum.ims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.ims.domain.Product;
import edu.mum.ims.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
 
 	@RequestMapping({"","/all"})
	public List<Product> list(Model model) {
		return  productService.getAllProducts();
 
	}
	
 	@RequestMapping("/{id}")
	public Product getProductById( @PathVariable("id") Long productId) {

		return productService.get(productId);
 	}

 	@RequestMapping("/withCategory/{id}")
	public Product getByIdWithCategory( @PathVariable("id") Long productId) {

		return productService.getWithCategory(productId);
 	}

	   
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void processAddNewProductForm(@RequestBody Product productToBeAdded , HttpServletRequest request) {

			productService.addProduct(productToBeAdded);
 
	}
	
   
}
