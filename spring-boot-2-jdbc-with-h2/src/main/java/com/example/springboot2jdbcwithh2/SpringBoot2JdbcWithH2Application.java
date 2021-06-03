package com.example.springboot2jdbcwithh2;

import com.example.springboot2jdbcwithh2.student.Student;
import com.example.springboot2jdbcwithh2.student.StudentJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringBoot2JdbcWithH2Application implements CommandLineRunner {

	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentJdbcRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Student id 10001 -> {}", repository.findById(10001L));
		logger.info("Inserting -> {}", repository.insert(new Student(10010L, "Vasya", "C123455")));
		logger.info("Update 10003 -> {}", repository.update(new Student(10001L, "Name-updated", "New Passport")));
		repository.deleteById(10002L);
		logger.info("All users -> {}", repository.findAll());
	}
}
