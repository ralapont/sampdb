package org.sampdb.modeljpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member_pass")
public class MemberPass implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -7638723036950876199L;

    @Id 
    @Column(name="member_id")
	private Integer memberId;
    
	@Column(name="password", columnDefinition="char(8)")
	private String password;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
