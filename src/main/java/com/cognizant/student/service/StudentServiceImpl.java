package com.cognizant.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.student.entity.StudentEntity;
import com.cognizant.student.exception.ResourceNotFoundException;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	IStudentRepository istudentRepo;

	@Override
	public Integer saveStudent(StudentEntity entityStudent) {
		StudentEntity saveStudent = istudentRepo.save(entityStudent);
		return saveStudent.getId();
	}

	@Override
	public List<StudentEntity> getAllStudents() {
		// TODO Auto-generated method stub
		return istudentRepo.findAll();
	}

	@Override
	public Optional<StudentEntity> getStudent(Integer id) {
		// TODO Auto-generated method stub
		// Optional<StudentEntity> student = istudentRepo.findById(id);
		return istudentRepo.findById(id);
	}

	@Override
	public void deleteStudent(Integer id) {
		istudentRepo.deleteById(id);

	}

	@Override
	public Integer updateStudent(StudentEntity entityStudent, Integer id) {
		// TODO Auto-generated method stub
	 StudentEntity existingStudent = istudentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("student","name","with id"+id+" not found"));
	 
	 existingStudent.setFirstName(entityStudent.getFirstName());
	 existingStudent.setLastName(entityStudent.getLastName());
	 istudentRepo.save(existingStudent);
		return existingStudent.getId();
	}

}
