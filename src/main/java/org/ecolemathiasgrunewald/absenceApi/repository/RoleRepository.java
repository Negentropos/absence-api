package org.ecolemathiasgrunewald.absenceApi.repository;

import org.ecolemathiasgrunewald.absenceApi.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{ 

}
