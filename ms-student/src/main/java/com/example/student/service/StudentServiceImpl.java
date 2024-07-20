package com.example.student.service;

 import com.example.student.dto.SchoolDto;
 import com.example.student.dto.StudentDto;
 import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    private final String schoolServiceUrl = "http://9f1f97ad8190:8084/";




    
    @Override
    public StudentDto studentFindById(int id) {
        Student student =  studentRepository.findById(id).orElseThrow(()->new RuntimeException()) ;

        RestTemplate restTemplate = new RestTemplate();
        SchoolDto schoolDto = restTemplate.getForObject(
                schoolServiceUrl + "/school/" + student.getSchoolId(),
                SchoolDto.class
        );
        return new StudentDto(student.getId(),student.getName(),student.getAge(),student.getGender(),schoolDto);
    }

    @Override
    public List<Student> studentFindAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public void studentSave(Student student) {
        RestTemplate restTemplate = new RestTemplate();
         restTemplate.getForObject(
                schoolServiceUrl + "/school/" + student.getSchoolId(),
                 SchoolDto.class
        );
        studentRepository.save(student);
    }

    @Override
    public void studentDeleteById(int id) {
        studentRepository.deleteById(id);
    }
}
