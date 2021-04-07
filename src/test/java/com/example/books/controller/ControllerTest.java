package com.example.books.controller;

import com.example.books.mapper.UserMapper;
import com.example.books.pojo.TbUser;
import com.example.books.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Chika
 * @program books
 * @create 2021/4/5 - 22:45
 **/

@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerTest {

    @Autowired
    private UserServiceImpl service;

    @Autowired
    private UserMapper mapper;

    @Test
    public void testSelect() {
        String username, password;
        username = "zs";
        password = "zs123";
        System.out.println("1");
        try {
            System.out.println(mapper.selectUser(username, password));
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }

    }

}
