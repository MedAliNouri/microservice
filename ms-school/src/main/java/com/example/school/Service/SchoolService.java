package com.example.school.Service;

import com.example.school.Model.School;
import com.example.school.Repository.SchoolRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    public School save(School school){
        return schoolRepository.save(school);
    }
    public School findById(String id){
        return schoolRepository.findById(id).orElseThrow(()->new NotFoundException());
    }
    public List<School> findAll(){
        return schoolRepository.findAll();
    }
    public void deleteById(String id){
         schoolRepository.deleteById(id);
    }

}
