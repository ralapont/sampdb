package org.sampdbweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {

	@GetMapping
	public String home(ModelMap model) {
		return "home";
	}
	
}
