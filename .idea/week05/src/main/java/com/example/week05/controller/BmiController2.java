package com.example.week05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiController2 {
    @PostMapping("/bmi-result")
    public String calculateBmi(
            @RequestParam(name="name") String name,
            @RequestParam(name="height") double height,
            @RequestParam(name="weight") double weight,
            Model model
            ){
        if(height <= 0 || weight <= 0) {
            model.addAttribute("errorMessage", "키와 몸무게는 0보다 큰 값");
            return "bmi-result";
        }
        double heightMeter = height/100.0;
        double bmi = weight/(heightMeter*heightMeter);
        String formattedBmi = String.format("%.1f", bmi);
        model.addAttribute("name", name);
        model.addAttribute("bmi", formattedBmi);
        return "bmi-result";
    }
}
