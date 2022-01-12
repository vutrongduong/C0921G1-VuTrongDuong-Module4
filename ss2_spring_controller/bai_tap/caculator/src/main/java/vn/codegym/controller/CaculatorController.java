package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaculatorController {

    @GetMapping(value = {"/", "/caculator"})
    public String caculator() {
        return "index";
    }

    @PostMapping(value = {"/", "/caculator"})
    public ModelAndView result(@RequestParam int firstOperand, @RequestParam int secondOperand, @RequestParam String calculation) {
        String result;
        try {
            switch (calculation) {
                case "+":
                    result = Integer.toString(firstOperand + secondOperand);
                    break;
                case "-":
                    result = Integer.toString(firstOperand - secondOperand);
                    break;
                case "*":
                    result = Integer.toString(firstOperand * secondOperand);
                    break;
                case "/":
                    result = Integer.toString(firstOperand / secondOperand);
                    break;
                default:
                    result = "error"; }
        }catch (Exception e){
            result = "error";
        }
        return new ModelAndView("index", "result", result);
    }
}
