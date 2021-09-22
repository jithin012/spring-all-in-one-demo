package com.demo.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.model.GithubUser;

@Repository
public interface UserRepository extends MongoRepository<GithubUser, Long> {

}
