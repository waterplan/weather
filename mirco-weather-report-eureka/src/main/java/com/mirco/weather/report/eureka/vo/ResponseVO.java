package com.mirco.weather.report.eureka.vo;

public class ResponseVO <T>{
	
	private T data;
	
	private String success;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}
	

	

}
