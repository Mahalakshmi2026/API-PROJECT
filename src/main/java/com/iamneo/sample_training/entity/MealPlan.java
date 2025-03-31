package com.iamneo.sample_training.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MealPlan {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long MealPlanId;
    private String title;
    private String startDate;
    private String endDate;

    
    public Long getMealPlanId() {
        return MealPlanId;
    }
    public void setMealPlanId(Long mealPlanId) {
        MealPlanId = mealPlanId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
   
    public MealPlan(Long mealPlanId, String title, String startDate, String endDate) {
        MealPlanId = mealPlanId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public MealPlan() {
    }
}
