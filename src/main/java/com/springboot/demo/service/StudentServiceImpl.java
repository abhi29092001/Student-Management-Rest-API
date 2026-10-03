package com.springboot.demo.service;

import com.springboot.demo.dao.StudentRepository;
import com.springboot.demo.entity.Student;
import com.springboot.demo.exceptions.CourseNotFoundException;
import com.springboot.demo.exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        Optional<Student> op = studentRepository.findById(id);

        Student student = null;

        if (op.isPresent()) {
            student = op.get();
        } else {
            throw new StudentNotFoundException("Student id not found - " + id);
        }

        return student;
    }

    @Override
    public List<Student> findByCourse(String course) {
        List<Student> students = studentRepository.findByCourse(course);

        if (students.isEmpty()) {
            throw new CourseNotFoundException(course + " course not found");
        }

        return students;
    }

    @Override
    @Transactional
    public Student save(Student student) {
        Student dbEmployee = studentRepository.save(student);

        return dbEmployee;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Optional<Student> op = studentRepository.findById(id);

        if (op.isEmpty()) {
            throw new StudentNotFoundException("Student id not found - " + id);
        }

        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getTopStudents(double gpa) {
        List<Student> students = studentRepository.findTopStudents(gpa);

        if (students.isEmpty()) {
            throw new StudentNotFoundException("No Student Found");
        }

        return students;
    }
}
