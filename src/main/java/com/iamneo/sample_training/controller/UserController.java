package com.iamneo.sample_training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.sample_training.entity.User;
import com.iamneo.sample_training.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired 
    UserService userService;

    @GetMapping("/getpath")
    public List<User> getuser() {
        return userService.getdata();
    }
  
    @PostMapping("/path")
    public String postuser(@RequestBody User entity) {
        return userService.postdata(entity);
    }

    @PutMapping("/put/{id}")
    public User putuser(@PathVariable Long id, @RequestBody User entity) {
       return userService.putdata(id,entity);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteuser(@PathVariable Long id){
         userService.deletedata(id);
         return "success";
    }

    //sorting

    @GetMapping("/sorting")
    public List<User> getSorted(@RequestParam String field) {
        return userService.getSorted(field);
    }

    //pagination

    @GetMapping("/paging")
    public Page<User> getEmployee(@RequestParam (defaultValue="1")int page,@RequestParam (defaultValue="3")int size) {
        return userService.getPageEmployee(page,size);
    }

    //JPA Methods
    @GetMapping("/get/by-name/{name}")
    public List<User> findByName(@PathVariable String name)
    {
        return userService.findByName(name);
    }

    //JPQL

    @GetMapping("/get/email/{email}")
     public String findByEmail(@PathVariable String email) {
         return userService.findByEmail(email);
     }

}