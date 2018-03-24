package org.sampdb.service;

import java.util.List;

import org.sampdb.modeljpa.entities.President;
import org.sampdb.service.dtos.PresidentDto;
import org.springframework.data.domain.Page;

public interface ConsultaPresidentService {
	List<President> obtenerPresidents();
	President obtenerPresident(Integer presidentId);
	List<PresidentDto> obtenerPresidentsDto();
	Page<PresidentDto> findBySearchTerm(Integer page, Integer rows, String  sidx, String  sord);
	Page<PresidentDto> findBySearchTerm(Integer page, Integer rows, String  sidx, String  sord, String filters);
}
