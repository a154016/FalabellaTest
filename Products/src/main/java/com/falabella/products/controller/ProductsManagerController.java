package com.falabella.products.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.falabella.products.model.Product;
import com.falabella.products.service.ProductsManagerService;

@Controller
public class ProductsManagerController {

	@Autowired
	private ProductsManagerService productsManagerService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-products", method = RequestMethod.GET)
	public String getAllProducts(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("portfolioList", productsManagerService.getAllProducts());
		// model.put("todos", service.retrieveTodos(name));
		return "portfolioList";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String showAddProductPage(ModelMap model) {
		model.addAttribute("product", new Product());
		return "productStock";
	}

	@RequestMapping(value = "/deletePosition", method = RequestMethod.GET)
	public String deletePosition(@RequestBody Product product) {
		productsManagerService.deleteProduct(product);
		// service.deleteTodo(id);
		return "redirect:/productList";
	}

	
}
