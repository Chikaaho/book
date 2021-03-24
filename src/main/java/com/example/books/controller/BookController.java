package com.example.books.controller;

import com.example.books.service.impl.BookServiceImpl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/books")
@ApiModel("书架控制器")
@CrossOrigin
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    private final Map<String, Object> booksJson = new HashMap<String, Object>();


}
