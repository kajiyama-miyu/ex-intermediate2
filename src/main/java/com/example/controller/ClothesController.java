package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clothes")
public class ClothesController {

	@RequestMapping("")
	public String index(Model model) {
		
		Map< Integer, String> clotheMap = new HashMap<Integer, String>();
		clotheMap.put(1, "赤");
		clotheMap.put(2, "青");
		clotheMap.put(3, "白");
		clotheMap.put(4, "黄");
		
		model.addAttribute("clotheMap", clotheMap);
		
		Map<Integer, String> genderMap = new HashMap<Integer, String>();
		genderMap.put(1, "Man");
		genderMap.put(2, "Woman");
		
		model.addAttribute("genderMap", genderMap);
		
		return "show-clothes";
	}
}
