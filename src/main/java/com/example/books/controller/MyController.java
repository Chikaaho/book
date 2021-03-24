package com.example.books.controller;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/MyAllDemoAPI")
public class MyController {

    private final Map<String, Object> jsonMap = new HashMap<>();

    @PostMapping("/test01/{id}/{name}")
    @ResponseBody
    public Map<String, String> test(@PathVariable("id") String id, @PathVariable("name") String name) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        return map;
    }

    @PostMapping("/che")
    @CrossOrigin
    @ApiModelProperty("检查前端能否正常将数据传递到后端处理成json并跳转页面")
    public String test02(@RequestParam Map<String, Object> mapJson) {
        jsonMap.clear();
        jsonMap.put("stu_name", mapJson.get("stu_name"));
        jsonMap.put("stu_id", mapJson.get("stu_id"));
        return "login";
    }

    @GetMapping("/check")
    @ResponseBody
    @CrossOrigin
    @ApiModelProperty("返回一个json(键值对对象)")
    public Map<String, Object> check() {
        return jsonMap;
    }

    @RequestMapping("/testModel")
    @CrossOrigin
    public String testModel(Model model) {
        model.addAttribute("msg", "测试传值");
        return "login";
    }

}
