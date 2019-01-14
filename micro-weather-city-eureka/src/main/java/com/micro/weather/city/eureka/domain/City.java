package com.micro.weather.city.eureka.domain;

import java.io.Serializable;

/**
 * City.
 * 
 */
public class City extends BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5119570118223943672L;

	
	private int id;
	private int pid;
	private String CityName;
	private String cityCode;
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
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return CityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		CityName = cityName;
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
