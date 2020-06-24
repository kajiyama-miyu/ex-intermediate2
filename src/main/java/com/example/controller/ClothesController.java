package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Clothes;
import com.example.form.ClothesForm;
import com.example.service.ClothesService;

@Controller
@RequestMapping("/clothes")
public class ClothesController {

	@Autowired
	private ClothesService service;
	
	@ModelAttribute
	public ClothesForm setUpForm() {
		return new ClothesForm();
	}
	
	@RequestMapping("")
	public String index(Model model) {
		
		Map< String, String> colorMap = new HashMap<String, String>();
		colorMap.put("赤", "赤");
		colorMap.put("青", "青");
		colorMap.put("白", "白");
		colorMap.put("黄", "黄");
		
		model.addAttribute("colorMap", colorMap);
		
		Map<Integer, String> genderMap = new HashMap<Integer, String>();
		genderMap.put(0, "Man");
		genderMap.put(1, "Woman");
		
		model.addAttribute("genderMap", genderMap);
		
		return "show-clothes";
	}
	
	@RequestMapping("/searchClothes")
	public String searchColothes(ClothesForm clothesForm, Model model) {
		Clothes clothes = service.searchClothes(clothesForm.getGender(), clothesForm.getColor());
		
		
			model.addAttribute("clothes", clothes);
			return index(model);
		
	}
	
}
