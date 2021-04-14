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

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@CrossOrigin
@ApiModel("用户控制")
public class UserController {

    private UserServiceImpl userService;
    @Autowired
    public void setUserService (UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/loginCheck")
    @ApiModelProperty("登录验证")
    public String loginCheck(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        TbUser tbUser = userService.selectUser(username, password);
        session.setAttribute("username", tbUser.getUsername());
        if (tbUser == null) {
            model.addAttribute("LOGIN_ERROR_MESSAGE", "账号或密码错误，请重新输入。");
            return "/login";
        }
        return "redirect:/books/toIndex";
    }

    @PostMapping("/regist.do")
    @ApiModelProperty("注册")
    public String registUser(
                            @RequestParam String username,
                            @RequestParam String password,
                            @RequestParam long userNumber,
                            @RequestParam String classname,
                            Model model) {
        int regist = userService.registUser(username, password, userNumber, classname);
        if (regist == 1) {
            return "forward:/login";
        } else {
            model.addAttribute("REGIST_ERROR_MESSAGE", "注册失败，请重试。");
            return "redirect:/user/toRegistPage";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus){
        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @RequestMapping("/toRegistPage")
    public String toRegistPage() {
        return "user/register";
    }

    @RequestMapping("/loginError")
    public String toErrorPage() {
        return "error/error";
    }

}
