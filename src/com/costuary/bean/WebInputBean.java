package com.costuary.bean;

public class WebInputBean {

	private String date;
	private String typeId;
	private String subcatId;
	private String comment;
	private String amt;
	private String currencyId;

	public WebInputBean(){}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getSubcatId() {
		return subcatId;
	}

	public void setSubcatId(String subcatId) {
		this.subcatId = subcatId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}




}
