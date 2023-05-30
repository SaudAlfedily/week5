package com.example.homework21.Repository;

import com.example.homework21.Model.Course;
import com.example.homework21.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

   public Course findCourseById(Integer id);
   List<Course> findCourseByStudent(Student student);
}
