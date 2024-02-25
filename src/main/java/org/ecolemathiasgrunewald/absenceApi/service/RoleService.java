package org.ecolemathiasgrunewald.absenceApi.service;

import java.util.Optional;

import org.ecolemathiasgrunewald.absenceApi.model.Role;
import org.ecolemathiasgrunewald.absenceApi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Iterable<Role> getRoles(){
		return roleRepository.findAll();
	}
	
	public Optional<Role> getRole(int id){
		return roleRepository.findById(id);
	}

}
