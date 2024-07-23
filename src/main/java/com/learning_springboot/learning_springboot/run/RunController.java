package com.learning_springboot.learning_springboot.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunController {
    // A GET request specifying the endpoint for this home() method
    @GetMapping("/hello")
    public String home() {
        return "Hello runners";
    }
}
