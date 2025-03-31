package com.iamneo.sample_training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iamneo.sample_training.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    


    
//JPA Methods

List<Recipe> findByName(String name);




//JPQL 

@Query("SELECT u.name from Recipe u where u.RecipeId=:id")
public String findNameById(@Param("id")Long id);

}
