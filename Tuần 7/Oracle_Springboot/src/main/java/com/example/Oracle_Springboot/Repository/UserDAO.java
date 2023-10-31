package com.example.Oracle_Springboot.Repository;

import com.example.Oracle_Springboot.Model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {
    private JdbcTemplate jdbcTemplate;

    public UserDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> listAll(){
        String sql = "Select * from users order by id asc";
        List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
        return users;
    }

    public User getUserById(int id) {
        String sql = "Select * from users where ID = ?";
        Object[] args = {id};
        User u = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(User.class));
        return u;
    }

    public void updateUser(User user) {
        String sql = "UPDATE users set " +
                "username=:username, " +
                "password=:password, " +
                "hobby=:hobby " +
                "where id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void removeUserById(int id) {
        String sql = "DELETE FROM users where id = ?";
        jdbcTemplate.update(sql,id);
    }

    public void addUser(User user) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("users").usingColumns("USERNAME","PASSWORD","HOBBY");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
        insert.execute(param);
    }
}
