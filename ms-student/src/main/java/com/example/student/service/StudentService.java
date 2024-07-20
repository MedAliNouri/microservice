package com.example.student.service;

import com.example.student.dto.StudentDto;
import com.example.student.model.Student;

import java.util.List;

public interface StudentService {
    StudentDto studentFindById(int id);
    List<Student> studentFindAll();
    void studentSave(Student student);

    void studentDeleteById(int id);
}
