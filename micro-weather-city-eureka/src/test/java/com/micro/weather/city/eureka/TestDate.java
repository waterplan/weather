/**
 * 
 */
package com.micro.weather.city.eureka;

import java.util.Date;

import org.junit.Test;

/**
 * @author zeng
 */
public class TestDate {

	
	@Test
	public void applicationTest() {
		Date date = new Date();
	    long time = date.getTime() - (1000 * 60 * 15);
	    Date dis = new Date(time);
	    System.out.println(dis.toLocaleString());
		System.out.println(date.toLocaleString());
	}
}
