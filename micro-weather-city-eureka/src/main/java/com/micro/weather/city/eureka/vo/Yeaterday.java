package com.micro.weather.city.eureka.vo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Yeaterday implements Serializable{

	private static final long serialVersionUID=1L;
	
	private String fl;
	private String fx;
	
	private String aqi;
	private String sunrise;
	
	private String sunset;
	private String notice;
	
	private String high;
	
	private String type;
	
	private String low;
	
	private String date;
	
	private Date ymd;
	
	private String week;

	public String getAqi() {
		return aqi;
	}
	public void setAqi(String aqi) {
		this.aqi = aqi;
	}
	public String getFl() {
		return fl;
	}
	public void setFl(String fl) {
		this.fl = fl;
	}
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

	/**
	 * @return the ymd
	 */
	public Date getYmd() {
		return ymd;
	}
	/**
	 * @param ymd the ymd to set
	 */
	public void setYmd(Date ymd) {
		this.ymd = ymd;
	}
	/**
	 * @return the week
	 */
	public String getWeek() {
		return week;
	}
	/**
	 * @param week the week to set
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, false);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}
}
