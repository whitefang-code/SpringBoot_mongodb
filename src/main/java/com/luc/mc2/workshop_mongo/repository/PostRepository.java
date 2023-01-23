package com.luc.mc2.workshop_mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luc.mc2.workshop_mongo.domain.Post;

@Repository
public interface PostRepository  extends MongoRepository<Post, String>{

	

}
