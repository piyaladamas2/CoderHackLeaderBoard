package com.adamas2.piyal.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.adamas2.piyal.demo.entity.User;

public interface UserRepository extends MongoRepository<User,String>{

}
