package com.alpha.sms.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.sms.entity.Student;
import com.alpha.sms.exception.EmptyInputException;
import com.alpha.sms.exception.ResourceNotFoundException;
import com.alpha.sms.repository.StudentRepository;
import com.alpha.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepo;
	//Constructor Based injection to inject dependency
//	public StudentServiceImpl(StudentRepository studentRepo) {
//		super();
//		this.studentRepo = studentRepo;
//	}



	@Override
	public List<Student> getAllStudents() {
		 
		return studentRepo.findAll();
	}



	@PostConstruct
	public void getProfileInfo() {
		
		System.out.println( "I'm in service");
	}
	

	@PostConstruct
	public static void getProfileInfo2() {
		
		System.out.println( "I'm in service3");
	}
	
	
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		
		 if(student.getFirstName()==null||student.getLastName()==null||student.getEmail()==null)
			 throw new EmptyInputException("Input fields are empty. Please look");
		 studentRepo.save(student);
		return student;
	}



	@Override
	public Student getStudentById(Long id) {
		 
		return studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id : "+id));
	}



	@Override
	public Student updateStudent(Student student) {
		
		 if(student.getFirstName()==null||student.getLastName()==null||student.getEmail()==null)
			 throw new EmptyInputException("Input fields are empty. Please look");
		 
		 studentRepo.save(student);
			return student;
	}



	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		 studentRepo.delete(student);
	}

}
