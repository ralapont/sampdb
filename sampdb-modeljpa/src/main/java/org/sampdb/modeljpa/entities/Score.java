package org.sampdb.modeljpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9133321889217976353L;

    @EmbeddedId
	private ScorePK scorePK;
	
	@Column(name="score", columnDefinition="int(11)")
	private Integer score;

    @JoinColumn(name = "event_id", referencedColumnName = "event_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GradeEvent gradeEvent;
    
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public Score() { }

    public Score(ScorePK scorePK) {
        this.scorePK = scorePK;
    }

    public Score(ScorePK scorePK, Integer score) {
        this.scorePK = scorePK;
        this.score = score;
    }

    public Score(Integer studentId, Integer eventId) {
        this.scorePK = new ScorePK(studentId, eventId);
    }

	public ScorePK getScorePK() {
		return scorePK;
	}

	public void setScorePK(ScorePK scorePK) {
		this.scorePK = scorePK;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public GradeEvent getGradeEvent() {
		return gradeEvent;
	}

	public void setGradeEvent(GradeEvent gradeEvent) {
		this.gradeEvent = gradeEvent;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scorePK != null ? scorePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Score)) {
            return false;
        }
        Score other = (Score) object;
        if ((this.scorePK == null && other.scorePK != null) || (this.scorePK != null && !this.scorePK.equals(other.scorePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rafael.entities.Score[ scorePK=" + scorePK + " ]";
    }

}
