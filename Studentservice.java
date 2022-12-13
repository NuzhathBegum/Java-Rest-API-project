package com.example.project2.service;

import java.util.List;

import com.example.project2.entity.Student;

public interface Studentservice {
	Student saveStudent(Student stdobj);
	List<Student>readAllStudents();
	Student fetchById(int studentId) throws Exception ;
	Student updatestudent(int id, Student value);
	void deleteStudent(int id);


}
