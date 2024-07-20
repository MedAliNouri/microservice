package com.example.school.Controller;

import com.example.school.Model.School;
import com.example.school.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @PostMapping("/add")
    public ResponseEntity<School> saveSchool(@RequestBody School school){
        return ResponseEntity.accepted().body(schoolService.save(school));
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> findSchool(@PathVariable("id") String id){
        return ResponseEntity.accepted().body(schoolService.findById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<School>> findAllSchool(){
        return ResponseEntity.accepted().body(schoolService.findAll());
    }
    @DeleteMapping("/delete/{id}")
    public void deleteSchool(@PathVariable("id") String id){
        schoolService.deleteById(id);
    }
}
