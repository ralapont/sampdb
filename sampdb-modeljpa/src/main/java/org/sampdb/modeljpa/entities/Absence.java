package org.sampdb.modeljpa.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="absence")
public class Absence implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2205484769513707549L;
	
	@EmbeddedId
	private AbsencePK id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="student_id", insertable = false, updatable = false)
	private Student student;
	
	public AbsencePK getId() {
		return id;
	}

	public void setId(AbsencePK id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
