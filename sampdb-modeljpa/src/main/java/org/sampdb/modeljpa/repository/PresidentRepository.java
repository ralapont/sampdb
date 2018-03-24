package org.sampdb.modeljpa.repository;

import org.sampdb.modeljpa.entities.President;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface PresidentRepository extends PagingAndSortingRepository<President, Integer>, QueryByExampleExecutor<President> {
	
}
