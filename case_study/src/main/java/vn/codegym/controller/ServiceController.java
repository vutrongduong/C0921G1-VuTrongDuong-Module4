package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.contract_detail.Contract;
import vn.codegym.model.employee.Employee;
import vn.codegym.model.service.Service;
import vn.codegym.service.contract_detail.IContractService;
import vn.codegym.service.service.IRentTypeService;
import vn.codegym.service.service.IService;
import vn.codegym.service.service.IServiceType;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    IService serviceImpl;
    @Autowired
    IServiceType serviceType;
    @Autowired
    IRentTypeService rentTypeService;
    @Autowired
    IContractService contractService;

    @GetMapping("/create")
    public String addShow(Model model) {
        model.addAttribute("service", new Service());
        model.addAttribute("serviceTypes", serviceType.findAll());
        model.addAttribute("rentTypeServices", rentTypeService.findAll());
        return "service/create";
    }

    @PostMapping("/create")
    public String add(@ModelAttribute Service service) {
        service.setStatus(1);
        serviceImpl.add(service);
        return "service/create";
    }

    @GetMapping("")
    public String list(@PageableDefault(value = 2) Pageable pageable, Model model
            , @RequestParam(defaultValue = "") String customerName,
                       @RequestParam(defaultValue = "") String serviceName) {
        Page<Contract> contract = contractService.findAll(customerName, serviceName, pageable);
        model.addAttribute("contracts", contract);
        return "service/list";
    }

    @GetMapping("/update/{id}")
    public String list(@PathVariable String id, Model model) {
        model.addAttribute("service", serviceImpl.findById(id));
        model.addAttribute("serviceTypes", serviceType.findAll());
        model.addAttribute("rentTypeServices", rentTypeService.findAll());
        return "service/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Service service) {
        serviceImpl.add(service);
        return "redirect:/service/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable String id, Model model) {
        model.addAttribute("service", serviceImpl.findById(id).get());
        return "service/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable String id, Model model) {
        model.addAttribute("service", serviceImpl.findById(id).get());
        return "service/delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        Service service = serviceImpl.findById(id).get();
        service.setStatus(0);
        serviceImpl.add(service);
        return "redirect:/service/";
    }
}
