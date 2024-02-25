package org.ecolemathiasgrunewald.absenceApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.ecolemathiasgrunewald.absenceApi.model.ClassSchool;


@Repository
public interface ClassSchoolRepository extends CrudRepository<ClassSchool, Integer> {

}
