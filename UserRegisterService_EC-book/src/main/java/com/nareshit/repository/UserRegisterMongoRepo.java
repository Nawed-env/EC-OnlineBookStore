package com.nareshit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nareshit.entity.UserRegisterMongo;

public interface UserRegisterMongoRepo extends MongoRepository<UserRegisterMongo, String> {

}
