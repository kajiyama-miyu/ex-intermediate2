package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.HotelDomain;
import com.example.repository.HotelRepository;

@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository repository;
	
	public List<HotelDomain> showAllHotels(){
		return repository.findAll();
	}
	
	public List<HotelDomain> showHotels(Integer price){
		return repository.findByHotel(price);
	}
}
