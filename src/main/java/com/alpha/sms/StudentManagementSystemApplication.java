package com.alpha.sms;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alpha.sms.entity.Student;
import com.alpha.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Value("${spring.environment}")
	private String env;
	@Value("${spring.message}")
	private String message;
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		
//		Student student1=new Student("Alpha", "K A", "alphaka94@gmail.com");
//		studentRepo.save(student1);
//		Student student2=new Student("Anish", "R", "anishr@gmail.com");
//		studentRepo.save(student2);
//		Student student3=new Student("Sathish", "T S", "sathishts@gmail.com");		
//		studentRepo.save(student3);

	 	//System.out.println(env + " Configured\n" + message);

	}

}
