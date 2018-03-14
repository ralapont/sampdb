package org.sampdb.modeljpa.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sampdb.modeljpa.config.JPAConfig;
import org.sampdb.modeljpa.entities.Member;
import org.sampdb.modeljpa.entities.MemberPass;
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
public class ITMemberRepository {

    @Autowired MemberRepository repository;	
    
    @Test
    public void obtenerMembersTest() {
		List<Member> members = (List<Member>) repository.findAll();
        assertThat(members).hasSize(102);
    }    

    @Test
    public void obtenerPassMemberTest() {
    	Member member = repository.findOne(new Integer(1));
		MemberPass pass = member.getMemberPass();
		assertNull(pass);
    }    
}
