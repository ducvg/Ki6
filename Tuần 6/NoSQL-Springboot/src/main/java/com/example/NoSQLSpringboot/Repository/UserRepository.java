package com.example.NoSQLSpringboot.Repository;

import com.example.NoSQLSpringboot.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {

}
