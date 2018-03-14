package org.sampdb.modeljpa.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3826421936654442080L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="member_id")
	private Integer memberId;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="member_id", unique= true, nullable=true, insertable=true, updatable=true)
	private MemberPass memberPass;
	  
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="suffix")
	private String suffix;
	
	@Column(name="expiration")
	private Date expiration;
		
	@Column(name="email")
	private String email;
		
	@Column(name="street")
	private String street;
		
	@Column(name="city")
	private String city;
		
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="state_code")
	private Estado estado;

	@Column(name="zip")
	private String zip;
		
	@Column(name="phone")
	private String phone;
		
	@Column(name="interests")
	private String interests;
	
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="pict_id")
    private Picture pictId;

	public MemberPass getMemberPass() {
		return memberPass;
	}

	public void setMemberPass(MemberPass memberPass) {
		this.memberPass = memberPass;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public Picture getPictId() {
		return pictId;
	}

	public void setPictId(Picture pictId) {
		this.pictId = pictId;
	}
    
}
