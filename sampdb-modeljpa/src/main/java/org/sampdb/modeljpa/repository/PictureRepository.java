package org.sampdb.modeljpa.repository;

import org.sampdb.modeljpa.entities.Picture;
import org.springframework.data.repository.CrudRepository;

public interface PictureRepository extends CrudRepository<Picture, Integer> {

}
