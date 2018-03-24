package org.sampdb.modeljpa.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sampdb.modeljpa.config.JPAConfig;
import org.sampdb.modeljpa.entities.Absence;
import org.sampdb.modeljpa.entities.Score;
import org.sampdb.modeljpa.entities.Student;
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
public class ITStudentRepository {

    @Autowired StudentRepository repository;	
    
    @Test
    public void obtenerStudentsTest() {
		List<Student> students = (List<Student>) repository.findAll();
        assertThat(students).hasSize(31);
        
        Optional<Student> student = repository.findById(new Integer(1));
        assertEquals(student.get().getSex().getCode(), "Female");
    }
    
    @Test
    public void obtenerSexStudentTest() {
        Optional<Student> student = repository.findById(new Integer(1));
        assertEquals(student.get().getSex().getCode(), "Female");
    }    

    @Test
    public void obtenerAbsenceStudentTest() {
        Optional<Student> student = repository.findById(new Integer(10));
        List<Absence> absences = student.get().getAbsences();
        assertThat(absences).hasSize(2);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	String dateInString[] = {"2012-09-06", "2012-09-09"};
        
    	int i = 0;
        for(Absence item: absences) {
        	String dateStr = null;
			dateStr = df.format(item.getId().getDate());
        	
        	assertEquals(dateStr, dateInString[i++]);
        }

    }    

    @Test
    public void obtenerScoresStudentTest() {
        Optional<Student> student = repository.findById(new Integer(10));
        List<Score> scores = student.get().getScores();
        assertThat(scores).hasSize(6);
        
        System.out.println("==================================================================");
        for (Score item: scores) {
        	System.out.println("Score ==> " + item.getGradeEvent().getEventId() + " , " + 
        									  item.getGradeEvent().getCategory() + " , " + 
        									  item.getGradeEvent().getDate() + " , " + 
                                              item.getScore());
        }
        System.out.println("==================================================================");
    }    
}
