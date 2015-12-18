package com.acsa.web.model;

public class Payment {

	
	public String getCodigo() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTxt_amount() {
		return txt_amount;
	}
	public void setTxt_amount(String txt_amount) {
		this.txt_amount = txt_amount;
	}
	public String getTxt_tipGratuity() {
		return txt_tipGratuity;
	}
	public void setTxt_tipGratuity(String txt_tipGratuity) {
		this.txt_tipGratuity = txt_tipGratuity;
	}
	public String getTxt_tableNumber() {
		return txt_tableNumber;
	}
	public void setTxt_tableNumber(String txt_tableNumber) {
		this.txt_tableNumber = txt_tableNumber;
	}
	public String getTxt_restaurantLocation() {
		return txt_restaurantLocation;
	}
	public void setTxt_restaurantLocation(String txt_restaurantLocation) {
		this.txt_restaurantLocation = txt_restaurantLocation;
	}
	public String getTxt_paymentReference() {
		return txt_paymentReference;
	}
	public void setTxt_paymentReference(String txt_paymentReference) {
		this.txt_paymentReference = txt_paymentReference;
	}
	public String getTxt_cardType() {
		return txt_cardType;
	}
	public void setTxt_cardType(String txt_cardType) {
		this.txt_cardType = txt_cardType;
	}
	
	String code;
	String txt_amount;
	String txt_tipGratuity;
	String txt_tableNumber;
	String txt_restaurantLocation;
	String txt_paymentReference;
	String txt_cardType;
	
}
