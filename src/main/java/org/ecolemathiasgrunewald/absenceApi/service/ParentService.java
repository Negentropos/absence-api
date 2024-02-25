package org.ecolemathiasgrunewald.absenceApi.service;

import java.util.Optional;

import org.ecolemathiasgrunewald.absenceApi.model.Parent;
import org.ecolemathiasgrunewald.absenceApi.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService {
	
	@Autowired
	private ParentRepository parentRepository;
	
	public Iterable<Parent> getParents(){
		return parentRepository.findAll();
	}
	
	public Optional<Parent> getParent(int id){
		return parentRepository.findById(id);
	}

}
