package com.alpha.sms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.sms.entity.Dummy;
import com.alpha.sms.entity.Student;
import com.alpha.sms.entity.StudentDTO;
import com.alpha.sms.service.StudentService;

@RestController//REST API receives and send json or xml format
//@Controller//to make this as Spring MVC class
@RequestMapping("/api/v1/")
public class StudentController {
	@Autowired
	private StudentService studentService;
	//@Autowired(required = false)
	
	@Resource(name="dum")
	private Dummy dummy;
	
	@Value("iouo")
	private String hello;
	
	
	//Constructor Based injection to inject dependency
//	public StudentController(StudentService studentService) {
//		super();
//		this.studentService = studentService;
//	}
//	
	
	//handler method to handle list students and return Model and view
//
//	@GetMapping("/students")
//	public String listStudents(Model model)
//	{
//		
//		model.addAttribute("students", studentService.getAllStudents());
//		return "students";//Thymeleaf View so no need for view resolver
//		
//	}
//	
//	@GetMapping("/students/new")
//	public String createStudentForm(Model model) 
//	{ Student  student=new Student();
//		model.addAttribute("student",student);
//		return "create_student";
//	}
//	
//	@PostMapping("/saveStudent")
//	public String saveStudent(@ModelAttribute("student") Student  student) 
//	{
//		if(student.getId()==null)
//		studentService.saveStudent(student);
//		else
//		studentService.updateStudent(student);
//		
//		return "redirect:/students";
//	}
//	@GetMapping("/student/edit/{id}")
//	public String editStudentForm(@PathVariable Long id,Model model)
//	{
//		Student student=studentService.getStudentById(id);
//		System.out.println(student);
//		model.addAttribute("student", student);
//		return "create_student";
//		
//	}
//	
//	@GetMapping("/student/delete/{id}")
//	public String deleteStudent(@PathVariable Long id)
//	{
//		Student student=studentService.getStudentById(id);
//		System.out.println(student);
//		studentService.deleteStudent(student);
//		return "redirect:/students";
//		
//	}
	
	
	//Spring Restful 

	@GetMapping(path="/students",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> listStudents()
	{
		  System.out.println(dummy.toString());
		return studentService.getAllStudents(); 
		
	}
	@GetMapping(path="/student/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Student editStudentForm(@PathVariable Long id)
	{
		Student student=studentService.getStudentById(id);
		
		return student;
		
	}
	
	@PostMapping(path="/student" , consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	//why we using @requestbody bcos we sending JSON data so it converts into object 
	public Student saveStudent(@RequestBody Student  student) 
	{
 
		return studentService.saveStudent(student);
	}

	@PutMapping(path="/student" , consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	//why we using @requestbody bcos we sending JSON data so it converts into object 
	public Student updateStudent(@RequestBody Student student) 
	{
		return studentService.updateStudent(student);
	}
	
	@PatchMapping(path="/student/{id}", consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	//why we using @requestbody bcos we sending JSON data so it converts into object 
	public Student updateReqInfoStudent(@PathVariable Long id,@RequestBody StudentDTO studentDTO) 
	{
		System.out.println(studentDTO);
		Student student=studentService.getStudentById(id);
		
		 if(studentDTO.getFirstName()!=null)
			 student.setFirstName(studentDTO.getFirstName());
		 if(studentDTO.getLastName()!=null)
			 student.setLastName(studentDTO.getLastName());
		 if (studentDTO.getEmail()!=null)
			 student.setEmail(studentDTO.getEmail());
		
		
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		Student student=studentService.getStudentById(id);
		studentService.deleteStudent(student);//Object also vanished so we can't access it
		return "Deleted "+id;
		
	}
	
	@GetMapping("/")
	public String home()
	{
		System.out.println(hello);
	return "<h1>Welcome</h1>";
	}
	@GetMapping("/user")
	public String user()
	{
		
	return "<h1>Hi User</h1>";
	}
	@GetMapping("/admin")
	public String admin()
	{
		
	return "<h1>Hi Admin</h1>";
	}
}
