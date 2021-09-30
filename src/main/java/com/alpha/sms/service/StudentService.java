package com.alpha.sms.service;

import java.util.List;

import com.alpha.sms.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudent(Student student);
	
}
