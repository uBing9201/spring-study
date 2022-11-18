package com.example.hello.controller;

import com.example.hello.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    // ResponseEntity
    @ResponseBody
    @GetMapping("/user")
    public UserDto user(){
        var user = new UserDto();
        user.setName("steve");
        user.setAddress("패스트 캠퍼스");
        return user;
    }

}
