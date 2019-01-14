package com.micro.weather.city.eureka.domain;

import java.io.Serializable;

public class ResponseVO extends BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9182208992235955504L;
	private int id;
	private String cityCode;
	private String weatherData;
	private String requestUrl;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the weatherData
	 */
	public String getWeatherData() {
		return weatherData;
	}
	/**
	 * @param weatherData the weatherData to set
	 */
	public void setWeatherData(String weatherData) {
		this.weatherData = weatherData;
	}
	
	
	/**
	 * @return the requestUrl
	 */
	public String getRequestUrl() {
		return requestUrl;
	}
	/**
	 * @param requestUrl the requestUrl to set
	 */
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	
	/**
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}
	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}


}
