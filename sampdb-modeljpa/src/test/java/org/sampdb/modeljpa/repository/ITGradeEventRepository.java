package org.sampdb.modeljpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sampdb.modeljpa.config.JPAConfig;
import org.sampdb.modeljpa.entities.GradeEvent;
import org.sampdb.modeljpa.entities.Score;
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
public class ITGradeEventRepository {

    @Autowired GradeEventRepository repository;	
    
    @Test
    public void obtenerGradeEventTest() {
		List<GradeEvent> gradeEvents = (List<GradeEvent>) repository.findAll();
        assertThat(gradeEvents).hasSize(6);
    }  
    
    @Test
    public void obtenerScoreEventTest() {
    	GradeEvent gradeEvent = repository.findOne(new Integer(3));
        List<Score> scores = gradeEvent.getScores();
        assertThat(scores).hasSize(31);
    }

}
