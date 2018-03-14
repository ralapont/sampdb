package org.sampdb.modeljpa.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prueba")
public class Prueba implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 59693609210957724L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="prueba_id")
	private Integer pruebaId;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="date")
	private Date date;

	public Integer getPruebaId() {
		return pruebaId;
	}

	public void setPruebaId(Integer pruebaId) {
		this.pruebaId = pruebaId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((pruebaId == null) ? 0 : pruebaId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prueba other = (Prueba) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (pruebaId == null) {
			if (other.pruebaId != null)
				return false;
		} else if (!pruebaId.equals(other.pruebaId))
			return false;
		return true;
	}	
	
	
}
