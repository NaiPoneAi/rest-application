package com.zmo.rest_application.repository;

import com.zmo.rest_application.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,Long> {
}
