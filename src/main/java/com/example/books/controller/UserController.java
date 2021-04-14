package com.example.books.controller;

import com.example.books.pojo.TbUser;
import com.example.books.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@CrossOrigin
@ApiModel("用户控制")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/login.")
    @ApiModelProperty("登录验证")
    public String loginCheck(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        TbUser tbUser = userService.selectUser(username, password);
        if (tbUser == null) {
            model.addAttribute("LOGIN_ERROR_MESSAGE", "账号或密码错误，请重新输入。");
            return "/login";
        }
        session.setAttribute("username", tbUser.getUsername());
        return "redirect:/books/toIndex";
    }

    @PostMapping("user/regist.do")
    @ApiModelProperty("注册")
    public String registUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam long userNumber,
            @RequestParam String classname,
            Model model) {
        int regist = userService.registUser(username, password, userNumber, classname);
        if (regist == 1) {
            return "/login";
        } else {
            model.addAttribute("REGIST_ERROR_MESSAGE", "注册失败，请重试。");
            return "redirect:/user/toRegistPage";
        }
    }

    @RequestMapping("user/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus) {
        session.invalidate();
        sessionStatus.setComplete();
        return "/login";
    }

    @RequestMapping("user/toRegistPage")
    public String toRegistPage() {
        return "user/register";
    }

    @RequestMapping("user/loginError")
    public String toErrorPage() {
        return "error/error";
    }

}
