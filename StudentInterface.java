package com.example.project2.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project2.entity.Student;

public interface StudentInterface extends JpaRepository<Student,Integer>{

}
