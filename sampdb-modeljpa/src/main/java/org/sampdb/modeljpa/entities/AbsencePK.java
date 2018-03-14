package org.sampdb.modeljpa.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AbsencePK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7164167788612610781L;

	@Column(name="student_id")
	private Integer studentId;
	
	@Column(name="date")
	private Date    date;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
