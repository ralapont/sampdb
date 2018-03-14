package org.sampdb.modeljpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="student")
public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8640213274101657599L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="student_id")
	private Integer studentId;
	
	@Column(name="name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sex", columnDefinition="enum")
	private Sex sex;
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy="student", fetch = FetchType.EAGER)
	private List<Absence> absences = new ArrayList<Absence>();

	@Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Score> scores;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="pict_id")
    private Picture pictId;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public List<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

    public Picture getPictId() {
		return pictId;
	}

	public void setPictId(Picture pictId) {
		this.pictId = pictId;
	}


}
