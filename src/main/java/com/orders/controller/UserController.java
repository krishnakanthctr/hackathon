package com.orders.controller;


import com.orders.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data-publisher/v1/users")
public class UserController {

    @PostMapping("/login")
    public String login(@RequestBody UserDto user) {
        //TODO return jwt token after authentication
        return "";
    }
}
