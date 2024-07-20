package com.example.student.controller;

import com.example.student.dto.StudentDto;
import com.example.student.model.Student;
import com.example.student.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;

    @PostMapping("/save")
    public void saveStudent(@RequestBody Student student) {
        studentService.studentSave(student);
    }
    @GetMapping("/find/{id}")
    public StudentDto findStudentById(@PathVariable int id) {
        return studentService.studentFindById(id);
    }

    @GetMapping("/findall")
    public Iterable<Student> findAllStudent() {
        return studentService.studentFindAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable int id) {
        studentService.studentDeleteById(id);
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        studentService.studentSave(student);
    }

}
