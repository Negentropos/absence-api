package org.ecolemathiasgrunewald.absenceApi.service;

import org.ecolemathiasgrunewald.absenceApi.model.Child;
import org.ecolemathiasgrunewald.absenceApi.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildService {
	
	@Autowired
	private ChildRepository childRepository;
	

	public Iterable<Child> getChilds() {
		return childRepository.findAll();
	}

}
