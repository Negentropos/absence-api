package org.ecolemathiasgrunewald.absenceApi.service;

import org.ecolemathiasgrunewald.absenceApi.model.ClassSchool;
import org.ecolemathiasgrunewald.absenceApi.repository.ClassSchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassSchoolService {
	
	@Autowired
	private ClassSchoolRepository classSchoolRepository;
	
	public Iterable<ClassSchool> getClassesSchool() {
		return classSchoolRepository.findAll();
	}

}
