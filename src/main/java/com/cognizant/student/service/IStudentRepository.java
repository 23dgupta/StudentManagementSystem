package com.cognizant.student.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.student.entity.StudentEntity;

public interface IStudentRepository extends JpaRepository<StudentEntity, Integer> {

}
