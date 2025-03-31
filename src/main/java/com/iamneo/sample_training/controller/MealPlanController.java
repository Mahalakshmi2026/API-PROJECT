package com.iamneo.sample_training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.sample_training.entity.MealPlan;

import com.iamneo.sample_training.service.MealPlanService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/mealPlan")
public class MealPlanController {
    @Autowired 
    MealPlanService mealPlanService;

    @GetMapping("/getpath")
    public List<MealPlan> getmealPlan() {
        return mealPlanService.getdata();
    }
  
    @PostMapping("/path")
    public MealPlan postmealPlan(@RequestBody MealPlan entity) {
        return mealPlanService.postdata(entity);
    }

    @PutMapping("/put/{id}")
    public MealPlan putmealPlan(@PathVariable Long id, @RequestBody MealPlan entity) {
       return mealPlanService.putdata(id,entity);
    }

    @DeleteMapping("/delete/{id}")
    public String deletemealPlan(@PathVariable Long id){
         mealPlanService.deletedata(id);
         return "success";
    }

    @GetMapping ("/getByStart/{startDate}")
    public List<MealPlan> getDetailsByStartDate(@PathVariable String startDate){
        return mealPlanService.getDetailsByStartDate(startDate);
    }

    


    //pagination
    @GetMapping("/paging")
    public Page<MealPlan> getEmployee(@RequestParam (defaultValue="1")int page,@RequestParam (defaultValue="3")int size) {
        return mealPlanService.getPageEmployee(page,size);
    }



    
    //sorting

    @GetMapping("/sorting")
    public List<MealPlan> getSorted(@RequestParam String field) {
        return mealPlanService.getSorted(field);
    }




}