package com.springboot.demo.rest;

import com.springboot.demo.entity.Student;
import com.springboot.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/top")
    public List<Student> getTopStudents(@RequestParam double gpa) {
        List<Student> students = studentService.getTopStudents(gpa);

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        return studentService.findById(studentId);
    }

    @GetMapping("/students/course/{course}")
    public List<Student> getStudents(@PathVariable String course) {
        return studentService.findByCourse(course);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addEmployee(@RequestBody Student student) {
        // setting id to 0 to override id field if given in request body
        student.setId(0);

        return ResponseEntity.status(201).body(studentService.save(student));
    }

    @PutMapping("/students/{studentId}")
    public ResponseEntity<Student> updateEmployee(@PathVariable Integer studentId, @RequestBody Student student) {
        studentService.findById(studentId);

        student.setId(studentId);
        Student updatedEmployee = studentService.save(student);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer studentId) {
        studentService.deleteById(studentId);
        return ResponseEntity.noContent().build();
    }
}
