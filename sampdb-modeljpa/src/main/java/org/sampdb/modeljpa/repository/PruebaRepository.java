package org.sampdb.modeljpa.repository;

import org.sampdb.modeljpa.entities.Prueba;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PruebaRepository extends CrudRepository<Prueba, Integer> {
	
    @Query("SELECT t.descripcion FROM Prueba t where t.pruebaId = :id") 
    String findDescripcionById(@Param("id") Integer id);

    @Query("SELECT t FROM Prueba t where t.descripcion = :descripcion") 
    Prueba findPruebaByDescripcion(@Param("descripcion") String descripcion);
}
