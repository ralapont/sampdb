package org.sampdb.modeljpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ScorePK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3979083391581982059L;

    @Column(name = "student_id")
    private Integer studentId;
	
    @Column(name = "event_id")
    private Integer eventId;

    public ScorePK() { }

    public ScorePK(Integer studentId, Integer eventId) {
        this.studentId = studentId;
        this.eventId = eventId;
    }
    
    public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentId;
        hash += (int) eventId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScorePK)) {
            return false;
        }
        ScorePK other = (ScorePK) object;
        if (this.studentId != other.studentId) {
            return false;
        }
        if (this.eventId != other.eventId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rafael.entities.ScorePK[ studentId=" + studentId + ", eventId=" + eventId + " ]";
    }
    
}
