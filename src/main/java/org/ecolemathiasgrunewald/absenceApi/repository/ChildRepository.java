package org.ecolemathiasgrunewald.absenceApi.repository;

import org.ecolemathiasgrunewald.absenceApi.model.Child;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends CrudRepository<Child, Integer> {

}
