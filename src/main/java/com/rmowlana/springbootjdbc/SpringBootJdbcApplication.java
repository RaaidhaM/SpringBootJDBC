package com.rmowlana.springbootjdbc;

import com.rmowlana.springbootjdbc.model.Student;
import com.rmowlana.springbootjdbc.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
        Student obj1 = context.getBean(Student.class);
        obj1.setId(100);
        obj1.setName("John Doe");
        obj1.setAge(20);
        obj1.setEmail("joe@gmail.com");
        System.out.println("Student 1: " + obj1);

        StudentRepository repo = context.getBean(StudentRepository.class);
        repo.save(obj1);

        Student obj2 = context.getBean(Student.class);
        obj2.setId(102);
        obj2.setName("Jane Smith");
        obj2.setAge(22);
        obj2.setEmail("jane@gmail.com");

        Student obj3 = context.getBean(Student.class);
        obj3.setId(103);
        obj3.setName("Alice Johnson");
        obj3.setAge(21);
        obj3.setEmail("alice@gmail.com");

        repo.saveAll(List.of(obj2, obj3));

        repo.findById(102).ifPresent(student -> {
            System.out.println("Found student with ID 102: " + student);
        });

        repo.findALl().forEach(System.out::println);
    }

}
