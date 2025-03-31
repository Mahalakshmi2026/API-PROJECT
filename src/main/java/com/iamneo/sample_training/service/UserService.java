package com.iamneo.sample_training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.iamneo.sample_training.entity.User;
import com.iamneo.sample_training.repository.UserRepository;

@Service
public class UserService 
{
    @Autowired
    UserRepository userRepository;

    public List<User> getdata() {
        return userRepository.findAll();
    }

    // Check if the email already exists
    public String postdata(User entity) {
        List<User> existingUsers = userRepository.findByEmail(entity.getEmail());
        if (!existingUsers.isEmpty()) {
            return "Email already exists";
        }
        userRepository.save(entity);
        return "User added successfully";
    }

    //Check if the username already exists
    public String post(User entity) {
        List<User> existingUsers = userRepository.findByName(entity.getName());
        if (!existingUsers.isEmpty()) {
            return "User already exists";
        }
        userRepository.save(entity);
        return "User added successfully";
    }
   
    public User putdata(Long id,User entity) {
       entity.setUserId(id);
       return userRepository.save(entity);
    }

    
    public String deletedata( Long id){
        userRepository.deleteById(id);
        return "success";
    }

    //sorting
    public List<User> getSorted(String field) {
    return userRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    //pagination
     public Page<User> getPageEmployee(@RequestParam int page,@RequestParam int size){
        PageRequest pageable=PageRequest.of(page,size);
        return userRepository.findAll(pageable);
    }

    //JPA Methods
    public List<User> findByName(String name)
    {
    return userRepository.findByName(name);
    }
 
    //JPQL 
    public String findByEmail(String email)
    {
    return  userRepository.findNameByEmail(email);
    }
    
}