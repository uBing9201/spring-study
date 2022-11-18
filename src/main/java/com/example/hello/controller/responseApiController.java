package com.example.hello.controller;

import com.example.hello.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class responseApiController {

    // TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;
    }

    // JSON
    // reg -> object mapper -> object -> method -> object -? object mapper -> json -> response
    @PostMapping("/json")
    public UserDto json(@RequestBody UserDto user){
        return user; // 200 OK
    }

    @PutMapping("/putUser")
    public ResponseEntity<UserDto> put(@RequestBody UserDto user){
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
