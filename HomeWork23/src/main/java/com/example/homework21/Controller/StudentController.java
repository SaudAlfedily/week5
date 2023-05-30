package com.example.homework21.Controller;

import com.example.homework21.ApiResponse.ApiResponse;
import com.example.homework21.Model.Course;
import com.example.homework21.Model.Student;
import com.example.homework21.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudent(){
        List<Student> students=studentService.getAllStudents();
        return ResponseEntity.status(200).body(students);
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student student, @Valid @PathVariable Integer id){
        studentService.updateStudent(student,id);
        return ResponseEntity.status(200).body("Student Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable @Valid Integer id){
        studentService.deleteStudent(id);




        return ResponseEntity.status(200).body("Student deleted");

    }
@GetMapping("/get-in-course/{course_id}")
    public ResponseEntity getAllStudentInClass(@PathVariable @Valid Integer course_id){
        List<Student> students=studentService.getAllStudentInClass(course_id);
        return ResponseEntity.status(200).body(students);

    }
    @GetMapping("/assign/{student_id}/{course_id}")
    public ResponseEntity assignStudentToCourse(@PathVariable@Valid Integer student_id,@Valid@PathVariable Integer course_id){
        studentService.assignStudentToCourse(student_id,course_id);
        return ResponseEntity.status(200).body("student assigned to course");




    }
    @PutMapping("/change-major/{student_id}/{major}")
    public ResponseEntity changeMajor(@Valid @PathVariable Integer student_id,@Valid@PathVariable String major){
        studentService.changeMajor(student_id,major);
        return ResponseEntity.status(200).body("major changed to " + major);
    }
}
