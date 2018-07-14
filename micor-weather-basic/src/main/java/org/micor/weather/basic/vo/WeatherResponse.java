package org.micor.weather.basic.vo;

import java.io.Serializable;

public class WeatherResponse implements Serializable{

	private static final long serialVersionUID=1L;
	
	private String  date;
	
	private Weather data;
	
	private Integer status;
	
	private String message;
	
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	private Integer count;
	public Weather getData() {
		return data;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public void setData(Weather data) {
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
