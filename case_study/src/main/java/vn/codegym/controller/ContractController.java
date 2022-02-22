package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.model.contract_detail.Contract;
import vn.codegym.service.contract_detail.IContractService;
import vn.codegym.service.customer.ICustomerService;
import vn.codegym.service.employee.IEmployeeService;
import vn.codegym.service.service.IService;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService contractService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IService service;

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("employee", employeeService.findAll());
        model.addAttribute("customer", customerService.findAll());
        model.addAttribute("service", service.findAll());
        model.addAttribute("contract", new Contract());
        return "contract/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Contract contract) {
        contractService.save(contract);
        return "redirect:/";
    }
}
