package org.sampdb.modeljpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="state")
public class Estado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8464784776194040602L;

	@Id
	@Column(name="state_code", columnDefinition="CHAR(2)")
	private String stateCode;

	@Column(name="state_desc")
	private String stateDesc;

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}


	public String getStateDesc() {
		return stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}
	
	
}
