package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    // 현재에 GET 방식으로 전송할때 사용하는 방식
    @GetMapping(path = "/hello") // http://localhost:9090/api/get/hello
    public String Hello(){
        return "get Hello";
    }
    // 이전에 GET 방식으로 전송할때 사용하던 방식
    @RequestMapping(path = "/hi",method = RequestMethod.GET) // get http://localhost:9090/api/get/hi
    public String Hi() {
        return "get Hi";
    }

    //http://localhost:9090/api/get/path-variable/{name}
    //http://localhost:9090/api/get/path-variable/{spring}
    //http://localhost:9090/api/get/path-variable/{java}
    //http://localhost:9090/api/get/path-variable/{spring-boot}
    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id") String pathName){
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    // search?q = intellij
    // &oq = intellij
    // &aqs = chrome..69i57j0i20i263i512l2j0i512l2j69i61j69i60l2.10240j0j7
    // &sourceid = chrome
    // &ie = UTF-8

    // ?key=value&key2=value2

    // http://localhost:9090/api/get/query-param?user=steve&email=steve@gamil.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }

    // user=steve&email=steve@gamil.com&age=30
    // Dto 로 스프링으로 받아서 자료를 파악할때 사용하는 방식
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
