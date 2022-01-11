package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TinhToanController {
    @GetMapping({"","/tinh"})
    public String tinh() {
        return "index";
    }
    @PostMapping("/tinh")
    public String tinh(@RequestParam int rate, double usd, Model model) {
        double result = usd * rate;
        model.addAttribute("result", result);
        return "result";
    }
}
