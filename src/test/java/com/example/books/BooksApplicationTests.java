package com.example.books;

import com.example.books.mapper.BookMapper;
import com.example.books.mapper.UserMapper;
import com.example.books.service.BookService;
import com.example.books.service.UserService;
import com.example.books.service.impl.BookServiceImpl;
import com.example.books.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.example.books.mapper")
class BooksApplicationTests {

    @Autowired
    private BookMapper mapper;
    @Autowired
    private BookServiceImpl service;
    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
        int i = service.updateBook(1, "Java核心技术", "从入门到入坟", 500, 1001);
        System.out.println(i);
    }

}
