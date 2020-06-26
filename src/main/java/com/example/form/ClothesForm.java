package com.example.form;


import javax.validation.constraints.NotNull;

public class ClothesForm {

	@NotNull(message = "性別を選択してください。")
	private Integer gender;
	private String color;
	
	
	@Override
	public String toString() {
		return "ClothesForm [gender=" + gender + ", color=" + color + "]";
	}


	public Integer getGender() {
		return gender;
	}


	public void setGender(Integer gender) {
		this.gender = gender;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
