package com.zmo.rest_application.service;

import com.zmo.rest_application.model.Student;
import com.zmo.rest_application.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    public Student addStudent(Student student){
        student.setId(sequenceGeneratorService.getSequenceNumber(Student.SEQUENCE_NAME));
        return studentRepository.save(student);
    }

    public List<Student> findAllStudent(){
        return  studentRepository.findAll();
    }

    public Student findStudentById(Long id){
        return studentRepository.findById(id).get();
    }

    public void updateStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
