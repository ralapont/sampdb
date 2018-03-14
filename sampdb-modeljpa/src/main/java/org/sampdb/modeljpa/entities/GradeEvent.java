package org.sampdb.modeljpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="grade_event")
public class GradeEvent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -895875750439012288L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="event_id")
	private Integer eventId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="category", columnDefinition="enum")
	private Category category;
	
	@Column(name="date")
	private Date date;

	@Fetch(FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gradeEvent", fetch=FetchType.EAGER)
    private List<Score> scores;

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
