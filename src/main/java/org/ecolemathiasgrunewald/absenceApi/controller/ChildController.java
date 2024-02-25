package org.ecolemathiasgrunewald.absenceApi.controller;

import org.ecolemathiasgrunewald.absenceApi.model.Child;
import org.ecolemathiasgrunewald.absenceApi.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChildController {
	
	@Autowired
	private ChildService childService;
	
	@GetMapping("/childs")
	public Iterable<Child> getChilds(){
		return childService.getChilds();
	}

}
