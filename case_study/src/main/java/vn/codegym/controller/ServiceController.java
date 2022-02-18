package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.model.Service;
import vn.codegym.service.IRentTypeService;
import vn.codegym.service.IService;
import vn.codegym.service.IServiceType;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    IService serviceImpl;
    @Autowired
    IServiceType serviceType;
    @Autowired
    IRentTypeService rentTypeService;

    @GetMapping("/create")
    public String addShow( Model model) {
        model.addAttribute("service",new Service());
        model.addAttribute("serviceTypes",serviceType.findAll());
        model.addAttribute("rentTypeServices",rentTypeService.findAll());
        return "service/create";
    }

    @PostMapping("/create")
    public String add(@ModelAttribute Service service) {
        serviceImpl.add(service);
        return "service/create";
    }
}
