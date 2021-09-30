package com.alpha.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.sms.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
