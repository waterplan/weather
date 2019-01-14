/**
 * 
 */
package com.micro.weather.city.eureka.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zeng
 */
public class BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4214967479054241585L;

	private String crUser;
	
	private Date crDate;
	
	private String upUser;
	
	private Date upDate;
	
	private int deleteFlag;

	/**
	 * @return the crUser
	 */
	public String getCrUser() {
		return crUser;
	}

	/**
	 * @param crUser the crUser to set
	 */
	public void setCrUser(String crUser) {
		this.crUser = crUser;
	}

	/**
	 * @return the crDate
	 */
	public Date getCrDate() {
		return crDate;
	}

	/**
	 * @param crDate the crDate to set
	 */
	public void setCrDate(Date crDate) {
		this.crDate = crDate;
	}

	/**
	 * @return the upUser
	 */
	public String getUpUser() {
		return upUser;
	}

	/**
	 * @param upUser the upUser to set
	 */
	public void setUpUser(String upUser) {
		this.upUser = upUser;
	}

	/**
	 * @return the upDate
	 */
	public Date getUpDate() {
		return upDate;
	}

	/**
	 * @param upDate the upDate to set
	 */
	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}

	/**
	 * @return the deleteFlag
	 */
	public int getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
