package com.ratesdemo.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ratesdemo.demo.services.productservicesimplementation;

@Controller
public class productController {
	
	@Autowired
	productservicesimplementation productimp;
	
	@RequestMapping("/products")
	public String Displaysome(Model model , String keyword) {
		if(keyword != null)
		{
		model.addAttribute("listProducts" , productimp.findbyproductkeyword(keyword));
		}
		else 
		{
		model.addAttribute("listProducts",productimp.getAllproducts());
		}
		return "product.html";
	}

}

