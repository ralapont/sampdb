package org.sampdb.service.impl;

import java.util.List;

import org.sampdb.modeljpa.entities.President;
import org.sampdb.modeljpa.repository.PresidentRepository;
import org.sampdb.service.ConsultaPresidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaPresidentServiceImpl implements ConsultaPresidentService {
	
    @Autowired PresidentRepository repository;

	public List<President> obtenerPresidents() {
		List<President> presidents = (List<President>) repository.findAll();
		return presidents;
	}	
    

}
