package org.sampdb.dozer;

import static org.junit.Assert.assertEquals;

import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sampdb.modeljpa.config.JPAConfig;
import org.sampdb.modeljpa.entities.President;
import org.sampdb.service.ConsultaPresidentService;
import org.sampdb.service.config.ServicesConfig;
import org.sampdb.service.dtos.PresidentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(
	    classes = { ServicesConfig.class, JPAConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class ITDozerSpringTest {
	
    @Autowired DozerBeanMapperFactoryBean dozerBean;
    @Autowired ConsultaPresidentService consultaPresidentService;
    
    @Test
    public void tetDozerMapping() throws Exception {

        Mapper mapper = dozerBean.getObject();
        President president = consultaPresidentService.obtenerPresident(new Integer(1));

        PresidentDto ptDto = new PresidentDto();

        //map source: p1Domain to target:p1Dto using "dozer-bean-mappings.xml" map-id: person
        mapper.map(president, ptDto, "president");

        assertEquals(president.getLastName(),  ptDto.getLastName());
        assertEquals(president.getFirstName(), ptDto.getFirstName());
    }    
}
