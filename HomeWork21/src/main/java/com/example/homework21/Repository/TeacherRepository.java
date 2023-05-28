package com.example.homework21.Repository;

import com.example.homework21.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
public Teacher findTeacherById(Integer id);
}
