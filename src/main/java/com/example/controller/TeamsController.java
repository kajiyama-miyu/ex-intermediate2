package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Teams;
import com.example.service.TeamsService;


@Controller
@RequestMapping("/teams")
public class TeamsController {

	@Autowired
	private TeamsService service;
	
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Teams> teamList = service.showTeamList();
		model.addAttribute("teamList", teamList);
		
		return "sample";
	}
	
	
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Teams teams = service.showDetail(Integer.parseInt(id));
		model.addAttribute("teams", teams);
		return "showDetail";
	}
}
