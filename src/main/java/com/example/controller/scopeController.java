package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scope")
public class scopeController {

	
	@RequestMapping("/abc")
	public String abc(Model model) {
		model.addAttribute("success", "aaa");

		
		return "abc";
	}
}
