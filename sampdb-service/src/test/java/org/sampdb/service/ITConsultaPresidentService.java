package org.sampdb.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sampdb.modeljpa.config.JPAConfig;
import org.sampdb.modeljpa.entities.President;
import org.sampdb.service.config.ServicesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServicesConfig.class, JPAConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class})
//@DatabaseSetup("todo-entries.xml")
public class ITConsultaPresidentService {

	@Autowired ConsultaPresidentService service;
	 
    @Test
    public void obtenerPresidentesTest() {
		List<President> presidents = (List<President>) service.obtenerPresidents();
        assertThat(presidents).hasSize(43);
    }    
}
