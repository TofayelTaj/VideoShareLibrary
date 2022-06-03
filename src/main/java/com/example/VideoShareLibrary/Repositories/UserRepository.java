package com.example.VideoShareLibrary.Repositories;

import com.example.VideoShareLibrary.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long > {


    @Query(value = "select * from user where email = ?1", nativeQuery = true)
    User findByUserEmail(@Param("email")String email);



}
