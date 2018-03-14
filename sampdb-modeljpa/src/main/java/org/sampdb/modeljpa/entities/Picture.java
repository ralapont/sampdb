package org.sampdb.modeljpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="picture")
public class Picture implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1710074212083162337L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pict_id")
	private Integer pictId;
	
	@Lob
	@Column(name="pict_data", columnDefinition="blob")
	private byte[] pictData;

	
	public Picture() { }

	public Picture(byte[] pictData) {
		this.pictData = pictData;
	}

	public Integer getPictId() {
		return pictId;
	}

	public void setPictId(Integer pictId) {
		this.pictId = pictId;
	}

	public byte[] getPictData() {
		return pictData;
	}

	public void setPictData(byte[] pictData) {
		this.pictData = pictData;
	}
	
}
