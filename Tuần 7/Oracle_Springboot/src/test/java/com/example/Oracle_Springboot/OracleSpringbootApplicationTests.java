package com.example.Oracle_Springboot;

import com.example.Oracle_Springboot.Repository.UserDAO;
import com.example.Oracle_Springboot.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OracleSpringbootApplicationTests {

	private UserDAO dao;

	@BeforeEach
	void setup() throws Exception{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("sa");
		dataSource.setPassword("123");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dao = new UserDAO(new JdbcTemplate(dataSource));
	}

	@Test
	void testList(){
		List<User> users = dao.users();

		assertFalse(users.isEmpty());
	}
}
