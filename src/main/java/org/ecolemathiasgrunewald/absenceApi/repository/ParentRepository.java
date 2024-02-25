package org.ecolemathiasgrunewald.absenceApi.repository;

import org.ecolemathiasgrunewald.absenceApi.model.Parent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends CrudRepository<Parent, Integer> {

}
