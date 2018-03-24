package org.sampdb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.sampdb.modeljpa.entities.President;
import org.sampdb.modeljpa.repository.PresidentRepository;
import org.sampdb.service.ConsultaPresidentService;
import org.sampdb.service.dtos.PresidentDto;
import org.sampdb.service.mappers.PresidentMapper;
import org.sampdb.service.utilities.JqgridFilter;
import org.sampdb.service.utilities.JqgridObjectMapper;
import org.sampdb.service.utilities.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ConsultaPresidentServiceImpl implements ConsultaPresidentService {
	
	@Autowired DozerBeanMapperFactoryBean dozerBean;
    @Autowired PresidentRepository        repository;

	public List<President> obtenerPresidents() {
		List<President> presidents = (List<President>) repository.findAll();
		return presidents;
	}

	public President obtenerPresident(Integer presidentId) {
		Optional<President> president = repository.findById(presidentId);
		return president.get();
	}

	public List<PresidentDto> obtenerPresidentsDto() {
		List<PresidentDto> presidentsDto = new ArrayList<PresidentDto>();
		
		List<President> presidents = (List<President>) repository.findAll();
        try {
			Mapper mapper = dozerBean.getObject();
			
			for(President item: presidents) {
				PresidentDto presidentDto = new PresidentDto();
				mapper.map(item, presidentDto, "president");
				presidentsDto.add(presidentDto);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return presidentsDto;
	}

	@Transactional(readOnly=true)
	public Page<PresidentDto> findBySearchTerm(Integer page, Integer rows, String  sidx, String  sord) {
		
        Pageable pageRequest = createPageRequest(page - 1, rows, sidx, sord);
        Page<President> searchResultPage = repository.findAll(pageRequest);
        pageRequest = createPageRequest(page, rows, sidx, sord);
        
        return PresidentMapper.mapEntityPageIntoDTOPage(pageRequest, searchResultPage);
	}	
    
	@Transactional(readOnly=true)
	public Page<PresidentDto> findBySearchTerm(Integer page, Integer rows, String sidx, String sord, String filters) {
    	if ("stateDesc".equals(sidx)) {
    		sidx = "estado.stateDesc";
    	}
    	
        Pageable pageRequest = createPageRequest(page - 1, rows, sidx, sord);
    	Page<President> searchResultPage = getFilteredRecords(filters, pageRequest);
        pageRequest = createPageRequest(page, rows, sidx, sord);
    	
        return PresidentMapper.mapEntityPageIntoDTOPage(pageRequest, searchResultPage);
	}
	
	private Pageable createPageRequest(Integer page, Integer rows, String  sidx, String  sord) {
        //Create a new Pageable object here.
    	Direction direccion = ("desc".equals(sord))? Sort.Direction.DESC: Sort.Direction.ASC;
    	if ("stateDesc".equals(sidx)) {
    		sidx = "estado.stateDesc";
    	}
    	
    	return PageRequest.of(page, rows, direccion, sidx);
    	
    }

	private Page<President> getFilteredRecords(String filters, Pageable pageRequest) {
		Integer qPresidentId = null;
		String qFirstName    = null;
		String qLastName     = null;
		String qState        = null;
		
		JqgridFilter jqgridFilter = JqgridObjectMapper.map(filters);
		
		President examplePresident = new President();
		
		for (Rule rule: jqgridFilter.getRules()) {
			if ("presidentId".equals(rule.getField())) {
				qPresidentId = new Integer(rule.getData());
				examplePresident.setPresidentId(qPresidentId);
			} else if (rule.getField().equals("firstName")) {
				qFirstName = rule.getData();
				examplePresident.setFirstName(qFirstName);
			} else if (rule.getField().equals("lastName")) {
				qLastName = rule.getData();
				examplePresident.setLastName(qLastName);
			} else if (rule.getField().equals("stateDesc")) {
				qState = rule.getData();
				examplePresident.getEstado().setStateDesc(qState);
			}
		}
		
		ExampleMatcher matcher = ExampleMatcher.matching();
		Example<President> example = Example.of(examplePresident, matcher); 
		
		Page<President> presidents = repository.findAll(example, pageRequest);
		
//		if (qPresidentId != null) 
//			presidents = repository.findAll(pageRequest);
//		if (qFirstName != null && qLastName != null) 
//			users = repository.findByFirstNameLikeAndLastNameLike("%"+qFirstName+"%", "%"+qLastName+"%", pageRequest);
//		if (qFirstName != null) 
//			users = repository.findByFirstNameLike("%"+qFirstName+"%", pageRequest);
//		if (qLastName != null) 
//			users = repository.findByLastNameLike("%"+qLastName+"%", pageRequest);
//		if (qRole != null) 
//			users = repository.findByRole(qRole, pageRequest);
//		
//		List<UserDto> userDtos = UserMapper.map(users);
//		JqgridResponse<UserDto> response = new JqgridResponse<UserDto>();
//		response.setRows(userDtos);
//		response.setRecords(Long.valueOf(users.getTotalElements()).toString());
//		response.setTotal(Integer.valueOf(users.getTotalPages()).toString());
//		response.setPage(Integer.valueOf(users.getNumber()+1).toString());
		return presidents;
	}
	
    
}
