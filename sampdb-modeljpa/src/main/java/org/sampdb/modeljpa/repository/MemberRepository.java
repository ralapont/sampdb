package org.sampdb.modeljpa.repository;

import org.sampdb.modeljpa.entities.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer> {

}
