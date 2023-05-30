package com.example.homework21.Repository;

import com.example.homework21.Model.Course;
import com.example.homework21.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findStudentById(Integer id);


}
