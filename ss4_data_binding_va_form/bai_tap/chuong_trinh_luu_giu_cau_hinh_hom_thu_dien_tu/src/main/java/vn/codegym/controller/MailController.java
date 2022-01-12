package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.model.Mail;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailController {
    @ModelAttribute("mail")
    public Mail mail() {
        return new Mail("English", 25, false, "Thor King, Asgard");
    }

    @RequestMapping("/")
    public String update(@ModelAttribute("mail") Mail mail, Model model) {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        model.addAttribute("languageList", languageList);
        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
        model.addAttribute("pageSizeList", pageSize);
        return "index";
    }
}
