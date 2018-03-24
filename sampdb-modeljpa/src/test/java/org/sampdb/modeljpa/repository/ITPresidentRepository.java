package org.sampdb.modeljpa.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sampdb.modeljpa.config.JPAConfig;
import org.sampdb.modeljpa.entities.Picture;
import org.sampdb.modeljpa.entities.President;
import org.sampdb.modeljpa.util.ObtenerArrayBytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
//@DatabaseSetup("todo-entries.xml")
public class ITPresidentRepository {

    @Autowired PresidentRepository repository;	
    @Autowired PictureRepository   pictureRepository;
    
    @Test
    public void obtenerPresidentesTest() {
		List<President> presidents = (List<President>) repository.findAll();
        assertThat(presidents).hasSize(43);
    }    

    @Test
    public void savePictureForPresidentTest() {
		Optional<President> pesident = repository.findById(new Integer(2));
		assertEquals(pesident.get().getLastName().toLowerCase(), "adams");
		
		ObtenerArrayBytes obtenerArrayBytes = new ObtenerArrayBytes();
		byte[] image = obtenerArrayBytes.obtenerBlob("C:\\Users\\usuario\\Pictures\\presidents\\adams.jpg");
		
	    Picture picture = new Picture(image);
	    
	    Picture newPicture = pictureRepository.save(picture);
	    
	    pesident.get().setPicture(newPicture);
	    repository.save(pesident.get());
	    assertNotNull(newPicture.getPictId());
	    
    }    

}
