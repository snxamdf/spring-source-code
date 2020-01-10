package com.spring.source.code.dao;

import com.spring.source.code.ioc.ExtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtRepository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(String name, Integer age) {
        System.out.println("add:" + name + age);
    }

}
