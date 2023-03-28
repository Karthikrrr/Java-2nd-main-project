package com.ratesdemo.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;  

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ratesdemo.demo.services.productCategoryservicesimplementation;


@Controller
public class CategoryController {
	@Autowired
	private productCategoryservicesimplementation productCategoryservices;
	
	
	
	@GetMapping("/category")
	public String Categories(Model model , String keyword) {	
		if(keyword != null)
		{
			model.addAttribute("listcategories", productCategoryservices.findbykeyword(keyword));
		}
		else {
		model.addAttribute("listcategories" , productCategoryservices.findAllCategoryes());
		}
		return "category.html";
	}

}
