package org.ecolemathiasgrunewald.absenceApi.controller;

import org.ecolemathiasgrunewald.absenceApi.model.Cycle;
import org.ecolemathiasgrunewald.absenceApi.service.CycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CycleController {
	
	@Autowired
	private CycleService cycleService;
	
	@GetMapping("/cycles")
	public Iterable<Cycle> getCycles(){
		return cycleService.getCycles();
	}

}
