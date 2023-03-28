 package com.ratesdemo.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ratesdemo.demo.Entity.user;
import com.ratesdemo.demo.services.UserNotFoundException;
import com.ratesdemo.demo.services.productCategoryservicesimplementation;
import com.ratesdemo.demo.services.userServices;

@Controller
public class adminController {
	
	@Autowired private userServices sreve;
	@Autowired private productCategoryservicesimplementation productCategoryservices;
	@Autowired private com.ratesdemo.demo.services.productservicesimplementation productservicesimplementation;
	
	@RequestMapping(value = "/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping(value="/admin/View")
	public String categoryproductsview(Model model) {
		model.addAttribute("listofexistcategory" , productCategoryservices.findAllCategoryes());
		model.addAttribute("listofexistproducts", productservicesimplementation.getAllproducts());
		return "category-product-exists";
	}
	
	@RequestMapping(value="/admin/View/add-category")
	public String AddCategoryes() {
		return "Addcategory";
	}
	
	@GetMapping("/admin/Alladmins")
	public String showuserlist(Model model) {
		List<user> users = sreve.listAll();
		model.addAttribute("listofadmins", users);
		return "alladmins.html";
	}
	
	@GetMapping("/admin/Alladmins/new-admin")
	public String shownewformforadmin(Model model) {
		model.addAttribute("addadmin", new user());
		return "add-new-admin.html";
	}
	
	@PostMapping("/admin/Alladmins/new-admin/save-new-user")
	public String saveUser(user user , RedirectAttributes ra) {
		sreve.save(user);
		ra.addFlashAttribute("message" , "The user has been saved succeaafully");
		return "redirect:/admin/Alladmins";
	}
	
	@GetMapping("/admin/Alladmins/edit/{id}")
	public String editusers(@PathVariable("id") Integer id , Model model , RedirectAttributes ra){
		try {
			user user = sreve.get(id);
			model.addAttribute("edituser", user);
			return "add-new-admin.html";
		} catch (UserNotFoundException e) {
			ra.addFlashAttribute("message" , "The user has been saved succeaafully");
			return "redirect:/admin/Alladmins";
		}
	}
}
