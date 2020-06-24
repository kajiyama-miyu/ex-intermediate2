package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Clothes;

@Repository
public class ClothesRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Clothes> CLOTHES_ROW_MAPPER
	= (rs,i) -> {
		Clothes clothes = new Clothes();
		clothes.setId(rs.getInt("id"));
		clothes.setCategory(rs.getString("category"));
		clothes.setGenre(rs.getString("genre"));
		clothes.setGender(rs.getInt("gender"));
		clothes.setColor(rs.getString("color"));
		clothes.setPrice(rs.getInt("price"));
		clothes.setSize(rs.getString("size"));
		
		return clothes;
	};
	
	
	public Clothes findByClothes(String color, Integer gender) {
		String sql = "SELECT id,category, genre, gender, color, price,size FROM clothes WHERE gender=:gender AND color=:color";
		
		try{
			SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
			
			Clothes clothes = template.queryForObject(sql, param, CLOTHES_ROW_MAPPER);
			
			return clothes;
		}catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			
			return null;
		}
		
		
		
	}
}
