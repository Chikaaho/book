package com.example.books;

import com.example.books.mapper.UserMapper;
import com.example.books.service.UserService;
import com.example.books.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.example.books.mapper")
class BooksApplicationTests {

    @Autowired
    private UserMapper mapper;
    @Autowired
    private UserServiceImpl service;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        System.out.println((1 << 2 & 0b1111));
    }

}
