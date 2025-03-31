package com.iamneo.sample_training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.iamneo.sample_training.entity.MealPlan;


public interface MealPlanRepository extends JpaRepository<MealPlan,Long> {

//JPA Methods

    List<MealPlan> findByStartDate(String startDate);




//JPQL 

// @Query("SELECT u.title from mealPlan u where u.mealPlanId=:id")
// public String findtitleById(@Param("id")Long id);

    
    
}
