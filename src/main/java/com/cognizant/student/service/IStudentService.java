package com.cognizant.student.service;

import java.util.List;
import java.util.Optional;

import com.cognizant.student.entity.StudentEntity;

public interface IStudentService {

	Integer saveStudent(StudentEntity entityStudent);

	public List<StudentEntity> getAllStudents();

	Optional<StudentEntity> getStudent(Integer id);

	public void deleteStudent(Integer id);

	Integer updateStudent(StudentEntity entityStudent, Integer id);

}
