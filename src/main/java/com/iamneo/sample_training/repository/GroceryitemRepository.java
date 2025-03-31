package com.iamneo.sample_training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.iamneo.sample_training.entity.Groceryitem;


public interface GroceryitemRepository extends JpaRepository<Groceryitem,Long>{




    
//JPA Methods

List<Groceryitem> findByName(String name);


// JPQL 

// @Query("SELECT u.name from groceryitem u where u.groceryitemId=:id")
// public String findNameById(@Param("id")Long id);

//     String getNameByQuantity(String quantity);
    
}
