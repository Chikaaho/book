package com.example.books.service.impl;

import com.example.books.mapper.UserMapper;
import com.example.books.pojo.TbUser;
import com.example.books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper mapper;
    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public TbUser selectUser(String username, String password) {
        return mapper.selectUser(username, password);
    }

    @Override
    public int registUser(String username, String password, long userNumber, String classname) {
        return mapper.registUser(username, password, userNumber, classname);
    }


    @Override
    @Transactional
    public int updateUser(long user_id, TbUser user) {
        return mapper.updateUser(user_id, user);
    }

    @Override
    @Transactional
    public int removeUser(long user_id) {
        return mapper.removeUser(user_id);
    }

    @Override
    public TbUser selectUserByName(String username) {
        return mapper.selectUserByName(username);
    }

    @Override
    public TbUser selectUserByNumber(long user_number) {
        return mapper.selectUserByNumber(user_number);
    }

    @Override
    public TbUser selectUserByClassName(String classname) {
        return mapper.selectUserByClassName(classname);
    }
}
