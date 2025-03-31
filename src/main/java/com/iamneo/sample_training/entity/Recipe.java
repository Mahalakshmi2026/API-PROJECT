package com.iamneo.sample_training.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recipe {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long RecipeId;
    private String name;
    private String instructions;

    
    public Long getRecipeId() {
        return RecipeId;
    }
    public void setRecipeId(Long recipeId) {
        RecipeId = recipeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public Recipe() {
    }

    public Recipe(Long recipeId, String name, String instructions) {
        RecipeId = recipeId;
        this.name = name;
        this.instructions = instructions;
    }
    
}
   
