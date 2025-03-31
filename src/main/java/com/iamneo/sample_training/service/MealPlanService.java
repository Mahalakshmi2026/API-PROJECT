package com.iamneo.sample_training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.iamneo.sample_training.entity.MealPlan;

import com.iamneo.sample_training.repository.MealPlanRepository;

@Service
public class MealPlanService {
    @Autowired
    MealPlanRepository mealPlanRepository;

    public List<MealPlan> getdata() {
        return mealPlanRepository.findAll();
    }

    
    public MealPlan postdata(@RequestBody MealPlan entity) {
        return mealPlanRepository.save(entity);
    }

   
    public MealPlan putdata(Long id,MealPlan entity) {
       entity.setMealPlanId(id);
       return mealPlanRepository.save(entity);
    }

    
    public String deletedata( Long id){
        mealPlanRepository.deleteById(id);
        return "success";
    }

    public List<MealPlan> getDetailsByStartDate(String startDate){
        return mealPlanRepository.findByStartDate(startDate);
    }

    

 
    //pagination

    public Page<MealPlan> getPageEmployee(@RequestParam int page,@RequestParam int size){
        PageRequest pageable=PageRequest.of(page,size);
        return mealPlanRepository.findAll(pageable);
    }

    //sorting
    public List<MealPlan> getSorted(String field) {
    return mealPlanRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    //JPA Methods
    public List<MealPlan> findByStartDate(String startDate)
    {
    return mealPlanRepository.findByStartDate(startDate);
    }

    
    //JPQL 

    //   public String findBytitle(long id) {
    //   return  mealPlanRepository.findtitleById(id);
    // }

}