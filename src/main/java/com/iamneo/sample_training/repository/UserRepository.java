package com.iamneo.sample_training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iamneo.sample_training.entity.User;
import java.util.List;


@Repository

public interface UserRepository extends JpaRepository<User,Long>{
    public List<User> findByEmail(String email);



//JPA Methods

List<User> findByName(String name);



//JPQL 

@Query("SELECT u.name  from User u where u.email=:email")
public String findNameByEmail(@Param("email")String email);


}


