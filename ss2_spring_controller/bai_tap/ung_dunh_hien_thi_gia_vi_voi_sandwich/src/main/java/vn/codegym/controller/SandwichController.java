package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @GetMapping("")
    public String diplay() {
        return "index";
    }

    @PostMapping("/save")
    public ModelAndView save(@RequestParam("condiment") String[] condiment) {
        ModelAndView modelAndView = new ModelAndView("result", "list", condiment);
        return modelAndView;
    }
}
