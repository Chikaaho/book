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
        String username, password;
        username = "zs";
        password = "zs123";
        System.out.println("1");
        try {
            System.out.println(userService.selectUser(username, password));
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
    }

}
