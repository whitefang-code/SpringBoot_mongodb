package com.luc.mc2.workshop_mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luc.mc2.workshop_mongo.domain.User;
import com.luc.mc2.workshop_mongo.dto.UserDTO;
import com.luc.mc2.workshop_mongo.repository.UserRepository;
import com.luc.mc2.workshop_mongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return  new User(objDto.getId(), objDto.getName(),objDto.getEmail());
	}


}
