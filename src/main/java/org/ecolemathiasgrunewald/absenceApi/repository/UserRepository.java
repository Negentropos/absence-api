package org.ecolemathiasgrunewald.absenceApi.repository;

import org.ecolemathiasgrunewald.absenceApi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
