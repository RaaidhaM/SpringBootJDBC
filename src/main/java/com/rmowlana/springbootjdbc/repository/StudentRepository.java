package com.rmowlana.springbootjdbc.repository;

import com.rmowlana.springbootjdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper as a reusable component
    private final RowMapper<Student> studentRowMapper = (rs, rowNum) -> {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setAge(rs.getInt("age"));
        student.setEmail(rs.getString("email"));
        return student;
    };

     // ======================== CREATE OPERATIONS ========================

    public void save(Student student) {
        String sql = "insert into student (id, name, age, email) values (?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql,student.getId(), student.getName(), student.getAge(), student.getEmail());
        System.out.println("Number of records inserted: " + rows);
    }

    public void saveAll(List<Student> students) {
        String sql = "insert into student (id, name, age, email) values (?, ?, ?, ?)";
        for (Student student: students){
            jdbcTemplate.update(sql,student.getId(), student.getName(), student.getAge(), student.getEmail());
        }
        System.out.println("Number of records inserted: " + students.size());
    }

    // ======================== READ OPERATIONS ========================

    public List<Student> findALl(){
        String sql = "select * from student";
        return jdbcTemplate.query(sql,studentRowMapper);
    }

    public Optional<Student> findById(int id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        try{
            Student student = jdbcTemplate.queryForObject(sql,studentRowMapper,id);
            return Optional.of(student);
        }catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<Student> findByName(String name) {
        String sql = "SELECT * FROM student WHERE name = ?";
        return jdbcTemplate.query(sql, studentRowMapper, name);
    }

    // ======================== UPDATE OPERATIONS ========================

    public void update(Student student) {
        String sql = "UPDATE student SET name = ?, age = ?, email = ? WHERE id = ?";
        int rows = jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getEmail(), student.getId());
        if (rows == 0) {
            throw new RuntimeException("Student with id " + student.getId() + " not found");
        }
        System.out.println("Number of records updated: " + rows);
    }

    // ======================== DELETE OPERATIONS ========================

    public void deleteById(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        int rows = jdbcTemplate.update(sql, id);
        if (rows == 0) {
            throw new RuntimeException("Student with id " + id + " not found");
        }
        System.out.println("Number of records deleted: " + rows);
    }

    public void delete(Student student) {
        deleteById(student.getId());
    }

    public void deleteAll() {
        String sql = "DELETE FROM student";
        int rows = jdbcTemplate.update(sql);
        System.out.println("All records deleted. Total: " + rows);
    }

}
