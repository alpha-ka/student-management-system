package com.alpha.sms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alpha.sms.entity.Student;
import com.alpha.sms.exception.EmptyInputException;
import com.alpha.sms.exception.ResourceNotFoundException;
import com.alpha.sms.repository.StudentRepository;
import com.alpha.sms.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class StudentManagementSystemApplicationTests {

	@Inject
	private StudentRepository studentRepo;
	@Inject
	private StudentService studentService;
	
	
	//private MockMvc mockMvc;
	
//	@Autowired
//	private WebApplicationContext context;
//	
//	ObjectMapper om=new ObjectMapper();
	
//	@Before
//	private void setUP()
//	{
//		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
//		
//	}

	
	
	@Test
	@Order(1)
	public void testCreate() {
		Student student = new Student("Alpha", "K A 007", "KA007@gmail.com");
		studentService.saveStudent(student);

		System.out.println("Studentn ID : " + student.getId());

		assertNotNull(studentService.getStudentById(student.getId()));
	}

	@Test
	@Order(2)
	public void testReadAll() {
		List list = studentService.getAllStudents();
		assertThat(list).size().isGreaterThanOrEqualTo(0);
	}

	@Test
	@Order(4)
	public void testFindByID() {
		long id = 39;
		Student student = studentService.getStudentById(id);

		assertEquals("ka007@gmail.com", student.getEmail());

	}

	@Test
	@Order(3)
	public void testUpdate() {
		Student student = studentService.getStudentById((long) 20);
		student.setEmail("test10@gmail.com");
		student.setFirstName("Test");
		student.setLastName("Hello");
		studentService.saveStudent(student);

		assertEquals("Hello", studentService.getStudentById((long) 20).getLastName());

	}

//	@Test
//	@Order(5)
//	public void testDeleteByID() {
//		Student student = studentService.getStudentById((long) 27);
//		studentService.deleteStudent(student);
//		assertFalse(studentRepo.existsById((long) 27));
//
//	}

	@Test
	@Order(5)
	public void testGetByIDException() {
		long id = 52;

		assertThrows(ResourceNotFoundException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				// TODO Auto-generated method stub
				Student student = studentService.getStudentById(id);
			}

		});

	}

	 
	
	@Test
	@Order(6)
	public void testCreateException()
	{
		assertThrows(EmptyInputException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				Student student = new Student("Alpha", "K A 007", "");
				studentService.saveStudent(student);
				
			}
		}); 
		
	}	
	

}
