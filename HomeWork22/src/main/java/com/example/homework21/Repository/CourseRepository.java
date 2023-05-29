package com.example.homework21.Repository;

import com.example.homework21.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

   public Course findCourseById(Integer id);
}
