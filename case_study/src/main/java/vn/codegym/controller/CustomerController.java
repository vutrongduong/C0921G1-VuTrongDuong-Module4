package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.dto.CustomerDto;
import vn.codegym.model.customer.Customer;
import vn.codegym.model.customer.CustomerType;
import vn.codegym.service.customer.ICustomerService;
import vn.codegym.service.customer.ICustomerTypeService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String getList(Model model,
                          @PageableDefault(value = 5) Pageable pageable,
                          @RequestParam(defaultValue = "") String customerName,
                          @RequestParam(defaultValue = "") String customerAddress,
                          @RequestParam(defaultValue = "") String customerType) {
        model.addAttribute("customerName", customerName);
        model.addAttribute("customerAddress", customerAddress);
        model.addAttribute("customerType", customerType);
        model.addAttribute("customers", customerService.find(customerName, customerAddress, customerType, pageable));
        return "customer/list";
    }
//    @GetMapping("")
//    public String getListSearch(Model model,
//                                @PageableDefault(value = 3) Pageable pageable,
//                                @RequestParam(defaultValue = "") String keyword) {
//        model.addAttribute("keyword", keyword);
//        model.addAttribute("customers", customerService.findFull(keyword, pageable));
//        return "customer/list";
//    }


    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Valid CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (customerDto.getCustomerBirthday() != null) {
            new CustomerDto().validate(customerDto, bindingResult);
        }
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerDto", customerDto);
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer.setStatus(1);
        redirectAttributes.addFlashAttribute("mess","Successfully added new customer : " +customer.getCustomerName());
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
    public String delete(@PathVariable String id,RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findById(id);
        customer.setStatus(0);
        customerService.add(customer);
        redirectAttributes.addFlashAttribute("messDelete", "Delete customer : " + customer.getCustomerName() + " successful");
        return "redirect:/customer";
    }

    @GetMapping("/update/{id}")
    public String updateShow(@PathVariable String id, Model model) {
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        return "customer/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Valid CustomerDto customerDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerDto", customerDto);
            return "customer/update";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        model.addAttribute("mess","Update customer : " +customer.getCustomerName()+ " successful");
        customer.setStatus(1);
        customerService.add(customer);
        return "customer/update";
    }

    @ModelAttribute("customerTypeList")
    public List<CustomerType> customerTypeList() {
        return customerTypeService.findAll();
    }
}
