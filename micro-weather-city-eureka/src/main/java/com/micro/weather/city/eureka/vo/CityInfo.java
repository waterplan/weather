/**
 * 
 */
package com.micro.weather.city.eureka.vo;

import java.io.Serializable;

/**
 * @author zeng
 */
public class CityInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3003934126475453442L;
	
	
	private String cityId;
	private String parent;
	private String city;
	private String updateTime;
	/**
	 * @return the cityId
	 */
	public String getCityId() {
		return cityId;
	}
	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	/**
	 * @return the parant
	 */
	public String getParent() {
		return parent;
	}
	/**
	 * @param parant the parant to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	

}
