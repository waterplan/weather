package com.micro.weather.city.eureka.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class WeatherResponse implements Serializable{

	private static final long serialVersionUID=1L;
	
	private String time;

	private CityInfo cityInfo;
	
	private String  date;
	
	private Weather data;
	
	private int status;
	
	private String message;
	
	
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}


	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}


	/**
	 * @return the cityInfo
	 */
	public CityInfo getCityInfo() {
		return cityInfo;
	}


	/**
	 * @param cityInfo the cityInfo to set
	 */
	public void setCityInfo(CityInfo cityInfo) {
		this.cityInfo = cityInfo;
	}


	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}


	/**
	 * @return the data
	 */
	public Weather getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(Weather data) {
		this.data = data;
	}


	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
