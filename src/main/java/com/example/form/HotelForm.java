package com.example.form;

import javax.validation.constraints.Pattern;

public class HotelForm {

	@Pattern(regexp = "[0-9]*", message = "数値を入力してください。" )
	private String price;


	public String toString() {
		return "HotelForm [price=" + price + "]";
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
