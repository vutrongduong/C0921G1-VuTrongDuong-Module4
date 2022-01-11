package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TuDienController {
    @GetMapping({"", "/translate"})
    public String translate() {
        return "index";
    }

    @RequestMapping(value = {"", "/translate"},method = RequestMethod.POST)
    public String translate(@RequestParam  String txtSearch, Model model) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (entry.getKey().equals(txtSearch)) {
                model.addAttribute("result", entry.getValue());
            }
        }
        return "result";
    }
}
