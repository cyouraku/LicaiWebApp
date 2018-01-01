package com.costuary.bean;

import java.sql.Timestamp;

public class SeqBean {

	private String name;
	private int current_val;
	private Timestamp timestamp;

	public SeqBean(){}

	public SeqBean(String name,int current_val){
		this.name = name;
		this.current_val = current_val;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrent_val() {
		return current_val;
	}
	public void setCurrent_val(int current_val) {
		this.current_val = current_val;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}


}