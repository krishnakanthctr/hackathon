package com.orders.controller;

import com.orders.dto.JobCriteria;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/data-publisher/v1/jobs")
public class OrderController {

    @PostMapping("/start")
    public String submitJob(@RequestBody JobCriteria criteria) {
        //TODO create method body
        return "";
    }

    @PostMapping("/{id}")
    public String getJobDetails(@RequestParam long jobId) {
        //TODO create method body
        return "";
    }



}
