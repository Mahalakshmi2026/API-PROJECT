package com.iamneo.sample_training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.sample_training.entity.Recipe;

import com.iamneo.sample_training.service.RecipeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/Recipe")
public class RecipeController {
    @Autowired 
    RecipeService recipeService;

    @GetMapping("/getpath")
    public List<Recipe> getrecipe() {
        return recipeService.getdata();
    }
  
    @PostMapping("/path")
    public Recipe postRecipe(@RequestBody Recipe entity) {
        return recipeService.postdata(entity);
    }

    @PutMapping("/put/{id}")
    public Recipe putRecipe(@PathVariable Long id, @RequestBody Recipe entity) {
       return recipeService.putdata(id,entity);
    }

    @DeleteMapping("/delete/{id}")
    public String deleterecipe(@PathVariable Long id){
         recipeService.deletedata(id);
         return "success";
    }

    //pagination

    @GetMapping("/paging")
    public Page<Recipe> getEmployee(@RequestParam (defaultValue="1")int page,@RequestParam (defaultValue="3")int size) {
        return recipeService.getPageEmployee(page,size);
    }


    //sorting

    @GetMapping("/sorting")
    public List<Recipe> getSorted(@RequestParam String field) {
        return recipeService.getSorted(field);
    }




    //JPA Methods
    @GetMapping("/get/by-name/{name}")
    public List<Recipe> findByName(@PathVariable String name)
    {
        return recipeService.findByName(name);
    }


    //JPQL

      @GetMapping("/get/id/{id}")
      public String findById(@PathVariable Long id) {
          return recipeService.findById(id);
      }
 
   
}