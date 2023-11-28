package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value ="select * from users where username = :username",nativeQuery = true )
    User getUserbyUsername(@Param("username") String username);

}
