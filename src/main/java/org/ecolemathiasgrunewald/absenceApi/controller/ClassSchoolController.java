package org.ecolemathiasgrunewald.absenceApi.controller;

import org.ecolemathiasgrunewald.absenceApi.model.ClassSchool;
import org.ecolemathiasgrunewald.absenceApi.service.ClassSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassSchoolController {
	
	@Autowired
	private ClassSchoolService classSchoolService;
	
	@GetMapping("/classesSchool")
	public Iterable<ClassSchool> getClassesSchool(){
		return classSchoolService.getClassesSchool();
	}

}
