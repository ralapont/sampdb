package org.sampdb.modeljpa.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sampdb.modeljpa.config.JPAConfig;
import org.sampdb.modeljpa.entities.Prueba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:data/Prueba-db.xml")
public class ITPruebaRepository {

    @Autowired PruebaRepository repository;	
    
    @Test
    public void obtenerPruebaTest() {
		List<Prueba> pruebas = (List<Prueba>) repository.findAll();
        assertThat(pruebas).hasSize(2);
    }    

    @Test
    public void obtenerDescricionTest() {
    	Integer id = new Integer(1);
		String descripcion = repository.findDescripcionById(id);
		assertEquals(descripcion, "createdByUser");
    }
    
	@Test
    public void obtenerPruebaByDescripcionTest() {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	String dateInString = "2014-12-24";
    	Date date = null;
    	try {
    		date = formatter.parse(dateInString);
    	} catch (ParseException ex) {
    		System.out.println("Error ==> " + ex.getMessage());
    	}
    	
    	Prueba esperada = new Prueba();
    	esperada.setPruebaId(new Integer(1));
    	esperada.setDescripcion("createdByUser");
    	esperada.setDate(date);
    	
    	String desc = "createdByUser";
		Prueba prueba = repository.findPruebaByDescripcion(desc);
		assertTrue(esperada.equals(prueba));   
    }    

    @Test
    public void savePruebaTest() {
    	Prueba prueba = new Prueba();
    	prueba.setDescripcion("Prueba de salvar");
    	prueba.setDate(new Date());
    	Prueba newPrueba = repository.save(prueba);
    	
	    assertNotNull(newPrueba.getPruebaId());
    }
    

}
