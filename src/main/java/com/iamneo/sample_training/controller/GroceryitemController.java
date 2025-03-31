package com.iamneo.sample_training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.sample_training.entity.Groceryitem;

import com.iamneo.sample_training.service.GroceryitemService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/groceryitem")
public class GroceryitemController {
    @Autowired 
    GroceryitemService groceryitemService;

    @GetMapping("/getpath")
    public List<Groceryitem> getgroceryitem() {
        return groceryitemService.getdata();
    }
  
    @PostMapping("/path")
    public Groceryitem postgroceryitem(@RequestBody Groceryitem entity) {
        return groceryitemService.postdata(entity);
    }

    @PutMapping("/put/{id}")
    public Groceryitem putgroceryitem(@PathVariable Long id, @RequestBody Groceryitem entity) {
       return groceryitemService.putdata(id,entity);
    }

    @DeleteMapping("/delete/{id}")
    public String deletegroceryitem(@PathVariable Long id){
         groceryitemService.deletedata(id);
         return "success";
    }



    //pagination
    @GetMapping("/paging")
    public Page<Groceryitem> getEmployee(@RequestParam (defaultValue="1")int page,@RequestParam (defaultValue="3")int size) {
        return groceryitemService.getPageEmployee(page,size);
    }



    //sorting
    @GetMapping("/sorting")
    public List<Groceryitem> getSorted(@RequestParam String field) {
        return groceryitemService.getSorted(field);
    }


    //JPA Methods
    @GetMapping("/get/by-name/{name}")
    public List<Groceryitem> findByName(@PathVariable String name)
    {
        return groceryitemService.findByName(name);
    }

    
     
}