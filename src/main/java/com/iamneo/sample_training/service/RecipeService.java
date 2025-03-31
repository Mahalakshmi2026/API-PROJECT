package com.iamneo.sample_training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.iamneo.sample_training.entity.Recipe;

import com.iamneo.sample_training.repository.RecipeRepository;


@Service
public class RecipeService {
    @Autowired

        RecipeRepository recipeRepository;
    
        public List<Recipe> getdata() {
            return recipeRepository.findAll();
        }
    
        
        public Recipe postdata(@RequestBody Recipe entity) {
            return recipeRepository.save(entity);
        }
    
       
        public Recipe putdata(Long id,Recipe entity) {
           entity.setRecipeId(id);
           return recipeRepository.save(entity);
        }
    
        
        public String deletedata( Long id){
            recipeRepository.deleteById(id);
            return "success";
        }
    
    //pagination
    public Page<Recipe> getPageEmployee(int page, int size) 
    {
    PageRequest pageable=PageRequest.of(page,size);
    return recipeRepository.findAll(pageable);
    }


    //sorting
    public List<Recipe> getSorted(String field) {
    return recipeRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }


    //JPA Methods
    public List<Recipe> findByName(String name)
    {
    return recipeRepository.findByName(name);
    }


    //JPQL 

    public String findById(Long id)
    {
    return  recipeRepository.findNameById(id);
    }


}
  