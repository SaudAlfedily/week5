package com.example.homework21.Service;

import com.example.homework21.ApiException.ApiException;
import com.example.homework21.Model.Course;
import com.example.homework21.Model.Student;
import com.example.homework21.Repository.CourseRepository;
import com.example.homework21.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents() {

        List<Student> students = studentRepository.findAll();
        return students;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }


    public void updateStudent(Student student, Integer id) {
        Student oldStudent = studentRepository.findStudentById(id);

        if (oldStudent == null) {
            throw new ApiException("Student not found");
        }
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());

        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer id) {
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        List<Course> courses = courseRepository.findCourseByStudent(student);
        for (Course course : courses) {
            course.getStudent().remove(student);
            courseRepository.save(course);
        }

        studentRepository.delete(student);
    }

    public List<Student> getAllStudentInClass(Integer course_id) {
        Course course = courseRepository.findCourseById(course_id);
        if (course == null) {

            throw new ApiException("Course not found");


        }
        List<Student> students = course.getStudent();
        return students;

    }

    public void assignStudentToCourse(Integer student_id, Integer course_id) {
        Student student = studentRepository.findStudentById(student_id);
        Course course = courseRepository.findCourseById(course_id);
        if (student == null || course == null) {

            throw new ApiException("one of the id's not found");


        }
        student.getCourses().add(course);
        course.getStudent().add(student);
        studentRepository.save(student);
        courseRepository.save(course);


    }

    public void changeMajor(Integer student_id,String major){
        Student student =studentRepository.findStudentById(student_id);

        if (student==null){

            throw new ApiException("student not found");
        }

        student.setMajor(major);

        List<Course> courses=courseRepository.findCourseByStudent(student);

        for (Course course : courses) {
            course.getStudent().remove(student);
            courseRepository.save(course);
        }

        studentRepository.save(student);


    }

}
