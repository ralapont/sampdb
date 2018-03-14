package org.sampdb.modeljpa.repository;

import org.sampdb.modeljpa.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
}
