package com.example.project2.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.project2.entity.Student;
import com.example.project2.service.Studentservice;

@RestController
@RequestMapping("/student")
public class StudentController {
	private Studentservice studentServ;
	public StudentController (Studentservice studentServ) {// constructor
		this.studentServ=studentServ;
	}
	@PostMapping("/insert")
	public ResponseEntity<Student>saveStudent(@RequestBody Student stdobj){
		return new ResponseEntity<Student>(studentServ.saveStudent(stdobj),HttpStatus.CREATED);

	}
	@GetMapping("/seeallstudents")
	List<Student>getAllStudentsFromDb(){
		return studentServ.readAllStudents();

	}
	@GetMapping("{id}")
	public ResponseEntity<Student>
	fetchOneStudentrecord(@PathVariable("id")  int studentId) throws Exception{
		return new ResponseEntity<Student>(studentServ.fetchById( studentId), HttpStatus.OK);
	}
	@PutMapping("/updatestudent/{id}")
	public ResponseEntity<Student>
	updatestudent(@PathVariable("id") int id, @RequestBody Student fromServer ){
		return new ResponseEntity<Student>(studentServ.updatestudent(id, fromServer),HttpStatus.OK);

	}
	@DeleteMapping("{id}")
	public ResponseEntity<String>
	deleteStudentThroughId(@PathVariable("id") int id){
		studentServ.deleteStudent(id);
		return new ResponseEntity<String>("record deleted", HttpStatus.OK);
	}

}



