package com.example.school.Repository;


import com.example.school.Model.School;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SchoolRepository extends MongoRepository<School, String> {

    // You can define additional methods if needed
}