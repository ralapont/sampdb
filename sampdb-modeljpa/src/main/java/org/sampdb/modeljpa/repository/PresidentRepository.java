package org.sampdb.modeljpa.repository;

import org.sampdb.modeljpa.entities.President;
import org.springframework.data.repository.CrudRepository;

public interface PresidentRepository extends CrudRepository<President, Integer> {

}
