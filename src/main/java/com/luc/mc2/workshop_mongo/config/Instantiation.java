package com.luc.mc2.workshop_mongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luc.mc2.workshop_mongo.domain.User;
import com.luc.mc2.workshop_mongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User uginho = new User(null, "Uginho Brown", "uginho@gmail.com");
		User zezinho = new User(null, "zezinho Green", "zezinho@gmail.com");
		User Luizinho = new User(null, "Luizinho Grey", "luizinho@gmail.com");

		userRepository.saveAll(Arrays.asList(uginho,zezinho,Luizinho));
	}

}
