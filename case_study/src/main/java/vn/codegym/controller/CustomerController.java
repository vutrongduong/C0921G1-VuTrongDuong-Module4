package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Customer;
import vn.codegym.service.ICustomerService;
import vn.codegym.service.ICustomerTypeService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String getList(Model model,
                                 @PageableDefault(value = 2) Pageable pageable,
                                 @RequestParam(defaultValue = "") String customerName,
                                 @RequestParam(defaultValue = "") String customerAddress,
                                 @RequestParam(defaultValue = "") String customerType) {
        model.addAttribute("customers", customerService.find(customerName, customerAddress, customerType, pageable));
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerTypeList", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer) {
        customerService.add(customer);
        return "redirect:/customer";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id, Model model, @PageableDefault(size = 2) Pageable pageable) {
        customerService.delete(id);
        model.addAttribute("customers", customerService.findAll(pageable));
        return "customer/list";
    }

    @GetMapping("/update/{id}")
    public String updateShow(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer, Model model) {
        customerService.add(customer);
        return "redirect:/customer";
    }
}
