package org.ecolemathiasgrunewald.absenceApi.controller;

import org.ecolemathiasgrunewald.absenceApi.model.Parent;
import org.ecolemathiasgrunewald.absenceApi.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentController {
	
	@Autowired
	private ParentService parentService;
	
	@GetMapping("/parents")
	public Iterable<Parent> getParents(){
		return parentService.getParents();
	}

}
