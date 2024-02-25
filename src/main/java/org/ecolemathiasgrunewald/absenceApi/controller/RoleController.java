package org.ecolemathiasgrunewald.absenceApi.controller;

import org.ecolemathiasgrunewald.absenceApi.model.Role;
import org.ecolemathiasgrunewald.absenceApi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/roles")
	public Iterable<Role> getRoles(){
		return roleService.getRoles();
	}
	
}
