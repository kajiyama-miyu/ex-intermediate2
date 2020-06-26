package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.HotelDomain;
import com.example.form.HotelForm;
import com.example.service.HotelService;

@Controller
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService service;
	
	@ModelAttribute
	private HotelForm setUpForm() {
		return new HotelForm();
	}
	
	@RequestMapping("")
	public String index() {
		return "search-hotels";
	}
	
	@RequestMapping("/search")
	public String searchHotels(@Validated HotelForm hotelForm, BindingResult result, Model model){
	
		if(result.hasErrors()) {
			return index();
		}
		
		
		
			if(hotelForm.getPrice().equals("")) {
				List<HotelDomain> hotel= service.showAllHotels();
				model.addAttribute("hotelList",hotel);
				return "search-hotels";
			}
		
			List<HotelDomain> hotelList = service.showHotels(Integer.parseInt(hotelForm.getPrice()));
		 if(hotelList.size()==0) {
				model.addAttribute("failure", "検索結果が存在しませんでした。");
				return "search-hotels";
			} else {	
				model.addAttribute("hotelList", hotelList);
				return "search-hotels";
			}
		

		
	}
}
