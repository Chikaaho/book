package com.example.books.controller;

import com.example.books.pojo.TbUser;
import com.example.books.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@CrossOrigin
@ApiModel("用户控制")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    private final Map<String, Object> userJson = new HashMap<String, Object>();

    @PostMapping("/loginCheck")
    @ApiModelProperty("登录验证")
    public String loginCheck(@RequestParam String username, @RequestParam String password, Model model) {
        TbUser tbUser = userService.selectUser(username, password);
        if (tbUser == null) {
            model.addAttribute("LOGIN_ERROR_MESSAGE", "账号或密码错误，请重新输入。");
            return "login";
        }
        return "index";
    }

    @PostMapping("/regist.do")
    @ApiModelProperty("注册")
    public String registUser(@RequestParam TbUser user) {
        int i = userService.registUser(user);
        if (i == 1) { return "index"; }
        else { return ""; }
    }

}
