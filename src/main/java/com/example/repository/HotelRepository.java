package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.HotelDomain;
import com.example.domain.Teams;

@Repository
public class HotelRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<HotelDomain> HOTEL_ROW_MAPPER 
	= (rs, i) -> {
		HotelDomain hotel = new HotelDomain();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getNString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		
		return hotel;
	};
	
	public List<HotelDomain> findAll(){
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels ORDER BY price DESC";
		
		List<HotelDomain> hotelList =template.query(sql, HOTEL_ROW_MAPPER);
		
		return hotelList;
	}
	
	public List<HotelDomain> findByHotel(Integer price){
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price <= :price";
		
		try {
			SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
			
			List<HotelDomain> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
			
			return  hotelList;
			
		}catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			
			return null;
		}
		
	}
	
	
}
