package com.mirco.weather.report.eureka.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mirco.weather.report.eureka.service.CityClient;
import com.mirco.weather.report.eureka.service.WeatherReportService;
import com.mirco.weather.report.eureka.vo.City;

@Controller
@RequestMapping("/report")
public class WeatherReportController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WeatherReportService weatherReportService;
	
	@Autowired
	private CityClient cityCient;
	
	@GetMapping("/cityName/{cityName}")
	public ModelAndView getReportByCityName(@PathVariable("cityName") String cityName, Model model) throws Exception{
	List<City> cityList = null;
		try {
			// TODO 改为由城市数据API微服务提供数据
			cityList = cityCient.listCity();
		} catch (Exception e) {
			LOG.error("Exception!", e);
		}
		model.addAttribute("title", "老卫的天气预报");
		model.addAttribute("cityName", cityName);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getDataByCityName(cityName));
		return new ModelAndView("weather/report", "reportModel", model);
	}
}
