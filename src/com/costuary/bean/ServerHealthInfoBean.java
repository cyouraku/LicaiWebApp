package com.costuary.bean;

public class ServerHealthInfoBean {

	private String cpu_teperature;
	private String gpu_temperature;
	private String fan_speed;
	private String record_id;
	private String record_timeStamp;

	public ServerHealthInfoBean(){}

	public String getCpu_teperature() {
		return cpu_teperature;
	}

	public void setCpu_teperature(String cpu_teperature) {
		this.cpu_teperature = cpu_teperature;
	}

	public String getGpu_temperature() {
		return gpu_temperature;
	}

	public void setGpu_temperature(String gpu_temperature) {
		this.gpu_temperature = gpu_temperature;
	}

	public String getFan_speed() {
		return fan_speed;
	}

	public void setFan_speed(String fan_speed) {
		this.fan_speed = fan_speed;
	}

	public String getRecord_id() {
		return record_id;
	}

	public void setRecord_id(String record_id) {
		this.record_id = record_id;
	}

	public String getRecord_timeStamp() {
		return record_timeStamp;
	}

	public void setRecord_timeStamp(String record_timeStamp) {
		this.record_timeStamp = record_timeStamp;
	}



}
