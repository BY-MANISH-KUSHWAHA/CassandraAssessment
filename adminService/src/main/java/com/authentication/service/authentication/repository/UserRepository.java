package com.authentication.service.authentication.repository;


import com.authentication.service.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Integer> {
    @Modifying
    @Query("SELECT u FROM User u WHERE u.email = :email")
    List<User> loginUser(@Param("email") String email);
}
