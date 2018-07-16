package com.mirco.weather.data.eureka.vo;

import java.io.Serializable;
import java.util.List;

public class Weather implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	private double pm25;
	
	private double pm10;
	
	private String quality;
	
	private String shidu;
	
	private String wendu;
	
	private String ganmao;
	
	private String aqi;
	
	private String city;
	
	private List<Forecast> forecast;
	
	private Yeaterday yesterday;

	public double getPm25() {
		return pm25;
	}

	public void setPm25(double pm25) {
		this.pm25 = pm25;
	}

	public double getPm10() {
		return pm10;
	}

	public void setPm10(double pm10) {
		this.pm10 = pm10;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getShidu() {
		return shidu;
	}

	public void setShidu(String shidu) {
		this.shidu = shidu;
	}

	public String getWendu() {
		return wendu;
	}

	public void setWendu(String wendu) {
		this.wendu = wendu;
	}

	public String getGanmao() {
		return ganmao;
	}

	public void setGanmao(String ganmao) {
		this.ganmao = ganmao;
	}

	public String getAqi() {
		return aqi;
	}

	public void setAqi(String aqi) {
		this.aqi = aqi;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Forecast> getForecast() {
		return forecast;
	}

	public void setForecast(List<Forecast> forecast) {
		this.forecast = forecast;
	}

	public Yeaterday getYesterday() {
		return yesterday;
	}

	public void setYesterday(Yeaterday yesterday) {
		this.yesterday = yesterday;
	}



	
	
}
