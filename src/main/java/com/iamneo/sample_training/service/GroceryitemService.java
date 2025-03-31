package com.iamneo.sample_training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.iamneo.sample_training.entity.Groceryitem;

import com.iamneo.sample_training.repository.GroceryitemRepository;

@Service
public class GroceryitemService {
    @Autowired
    GroceryitemRepository groceryitemRepository;

    public List<Groceryitem> getdata() {
        return groceryitemRepository.findAll();
    }

    
    public Groceryitem postdata(@RequestBody Groceryitem entity) {
        return groceryitemRepository.save(entity);
    }

   
    public Groceryitem putdata(Long id,Groceryitem entity) {
       entity.setGroceryitemId(id);
       return groceryitemRepository.save(entity);
    }

    
    public String deletedata( Long id){
        groceryitemRepository.deleteById(id);
        return "success";
    }


    //pagination
     public Page<Groceryitem> getPageEmployee(@RequestParam int page,@RequestParam int size){
        PageRequest pageable=PageRequest.of(page,size);
        return groceryitemRepository.findAll(pageable);
    }


    //sorting
    public List<Groceryitem> getSorted(String field) {
    return groceryitemRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }


    //JPA Methods
    public List<Groceryitem> findByName(String name)
    {
    return groceryitemRepository.findByName(name);
    }

    //JPQL 

    //  public String findByname(Long id) {
    // return  groceryitemRepository.findNameById(id);
    //  }


}