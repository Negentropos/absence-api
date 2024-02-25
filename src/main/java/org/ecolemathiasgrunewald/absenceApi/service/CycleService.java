package org.ecolemathiasgrunewald.absenceApi.service;

import org.ecolemathiasgrunewald.absenceApi.model.Cycle;
import org.ecolemathiasgrunewald.absenceApi.repository.CycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CycleService {
	
	@Autowired
	private CycleRepository cycleRepository;


	public Iterable<Cycle> getCycles() {
		return cycleRepository.findAll();
	}

}
