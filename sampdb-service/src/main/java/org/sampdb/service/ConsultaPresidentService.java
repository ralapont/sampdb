package org.sampdb.service;

import java.util.List;

import org.sampdb.modeljpa.entities.President;

public interface ConsultaPresidentService {
	List<President> obtenerPresidents();
}
