package com.ratesdemo.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/Login")
	public String login() {
		return "SIGNIN";
	}

}
