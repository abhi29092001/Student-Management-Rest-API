package com.springboot.demo.service;

import com.springboot.demo.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student findById(Integer id);

    List<Student> findByCourse(String course);

    Student save(Student student);

    void deleteById(Integer id);

    List<Student> getTopStudents(double gpa);
}
