package org.sampdb.service.mappers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.sampdb.modeljpa.entities.President;
import org.sampdb.service.dtos.PresidentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

final public class PresidentMapper {
    
    static public List<PresidentDto> mapEntitiesIntoDTOs(Iterable<President> entities) {
        List<PresidentDto> dtos = new ArrayList<>();

        entities.forEach(e -> dtos.add(mapEntityIntoDTO(e)));

        return dtos;
    }
    
    static public PresidentDto mapEntityIntoDTO(President entity) {
    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    	
    	PresidentDto dto = new PresidentDto();
    	dto.setPresidentId(entity.getPresidentId());
    	dto.setLastName(entity.getLastName());
    	dto.setFirstName(entity.getFirstName());
    	dto.setSuffix(entity.getSuffix());
    	dto.setStateCode(entity.getEstado().getStateCode());
    	dto.setStateDesc(entity.getEstado().getStateDesc());
    	dto.setCity(entity.getCity());
    	dto.setBirth(df.format(entity.getBirth()));
    	if (entity.getDeath() != null) {
        	dto.setDeath(df.format(entity.getDeath()));
    	}

        return dto;
    }
    
    static public Page<PresidentDto> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<President> source) {
        List<PresidentDto> dtos = mapEntitiesIntoDTOs(source.getContent());
        
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
}
}
