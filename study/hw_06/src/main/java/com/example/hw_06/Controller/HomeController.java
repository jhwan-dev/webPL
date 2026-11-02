package com.example.hw_06.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
        @GetMapping("/")
        public String study(){
            return "index";
        }
}
