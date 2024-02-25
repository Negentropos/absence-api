package org.ecolemathiasgrunewald.absenceApi.repository;

import org.ecolemathiasgrunewald.absenceApi.model.Cycle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CycleRepository extends CrudRepository<Cycle, Integer> {

}
