package com.orders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orders.dto.JobCriteria;


@RestController
@RequestMapping("/data-publisher/v1/jobs")
public class OrderController {

    @PostMapping("/start")
    public String submitJob(@RequestBody JobCriteria criteria) {
        //TODO create method body
        return "";
    }

    @GetMapping("/{id}")
    public String getJobDetails(@RequestParam long id) {
        //TODO create method body
        return "";
    }
    
    @GetMapping("/helloworld")
    public String printHelloWorld() {
        //TODO create method body
        return "Dummy JobDetails";
    }




}
