package org.sampdb.service.dtos;

import java.io.Serializable;

public class PresidentDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9130144501493210770L;
	private Integer presidentId;
	private String lastName;
	private String firstName;
	private String suffix;
	private String stateCode;
	private String stateDesc;
	private String city;
	private String birth;
	private String death;
	
	public Integer getPresidentId() {
		return presidentId;
	}
	public void setPresidentId(Integer presidentId) {
		this.presidentId = presidentId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getDeath() {
		return death;
	}
	public void setDeath(String death) {
		this.death = death;
	}
	public String getStateDesc() {
		return stateDesc;
	}
	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}
	
	
}
