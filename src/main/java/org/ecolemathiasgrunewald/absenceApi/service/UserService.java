package org.ecolemathiasgrunewald.absenceApi.service;

import java.util.Optional;

import org.ecolemathiasgrunewald.absenceApi.model.User;
import org.ecolemathiasgrunewald.absenceApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Iterable<User> getUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getUser(int id){
		return userRepository.findById(id);
	}

}
