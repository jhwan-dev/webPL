package com.example.week_04.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BmiController {
    @GetMapping("/bmi")
    public String calculateBmi(
        @RequestParam(name="name") String name,
        @RequestParam(name="height") double height,
        @RequestParam(name="weight") double weight
    ) {
        if(height <= 0 || weight <= 0) {
            return "키와 몸무게를 0보다 큰 값으로 입력하세요";
        }
        else {
            double bmi = weight/((height/100.0)*(height/100.0));
            return name + "님의 BMI는 " + String.format("%.1f", bmi) + "입니다.";
        }
    }
}
