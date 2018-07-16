package com.mirco.weather.data.eureka.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class WeatherResponse implements Serializable{

	private static final long serialVersionUID=1L;
	
	private String  date;
	
	private Weather data;
	
	private Integer status;
	
	private String intro;
	private String message;
	
	private String city;

	private String more;
	
	
	public String getMore() {
		return more;
	}

	public void setMore(String more) {
		this.more = more;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this);
	}
	
}
