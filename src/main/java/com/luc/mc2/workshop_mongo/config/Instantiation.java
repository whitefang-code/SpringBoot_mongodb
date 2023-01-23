package com.luc.mc2.workshop_mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luc.mc2.workshop_mongo.domain.Post;
import com.luc.mc2.workshop_mongo.domain.User;
import com.luc.mc2.workshop_mongo.dto.AuthorDTO;
import com.luc.mc2.workshop_mongo.dto.CommentDTO;
import com.luc.mc2.workshop_mongo.repository.PostRepository;
import com.luc.mc2.workshop_mongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	
	private UserRepository userRepository;
	
	@Autowired
	
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User uginho = new User(null, "Uginho Brown", "uginho@gmail.com");
		User zezinho = new User(null, "zezinho Green", "zezinho@gmail.com");
		User Luizinho = new User(null, "Luizinho Grey", "luizinho@gmail.com");
		
		userRepository.saveAll(Arrays.asList(uginho,zezinho,Luizinho));
		
		
		Post post1 = new Post(null,sdf.parse("21/03/2018"),
				"Partiu viagem","vou viajar para Sp . Abraços!",new AuthorDTO(uginho));
		Post post2 = new Post(null,sdf.parse("21/03/2018"),"Bom dia","Acordei feliz hoje!",new AuthorDTO(uginho));		
		
		CommentDTO c1 = new CommentDTO("Boa viahem mano",sdf.parse("21/03/2018"),new AuthorDTO(zezinho));
		CommentDTO c2 = new CommentDTO("Aproveite",sdf.parse("22/03/2018"),new AuthorDTO(Luizinho));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!",sdf.parse("23/03/2018"),new AuthorDTO(Luizinho));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		uginho.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(uginho);
		
	}

}
