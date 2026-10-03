package com.springboot.demo.dao;

import com.springboot.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByCourse(String course);

    @Query("Select s from Student s where s.gpa >= :gpa")
    List<Student> findTopStudents(@Param("gpa") double gpa);
}
