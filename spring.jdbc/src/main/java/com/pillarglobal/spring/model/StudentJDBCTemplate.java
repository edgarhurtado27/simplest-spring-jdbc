package com.pillarglobal.spring.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String name, Integer age) {
		final String SQL = "insert into Student (name, age) values (?, ?)";
		jdbcTemplateObject.update(SQL, name, age);
	}

	@SuppressWarnings("deprecation")
	public Student getStudent(Integer id) {
		final String SQL = "select * from Student where id = ?";
		return jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new StudentMapper());
	}

	public List<Student> listStudents() {
		final String SQL = "select * from Student";
		return jdbcTemplateObject.query(SQL, new StudentMapper());
	}
}
