package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.dto.ServiceDto;
import vn.codegym.model.contract_detail.Contract;
import vn.codegym.model.employee.Employee;
import vn.codegym.model.service.Service;
import vn.codegym.service.contract_detail.IContractService;
import vn.codegym.service.service.IRentTypeService;
import vn.codegym.service.service.IService;
import vn.codegym.service.service.IServiceType;

import javax.validation.Valid;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IService serviceImpl;
    @Autowired
    private IServiceType serviceType;
    @Autowired
    private IRentTypeService rentTypeService;
    @Autowired
    private IContractService contractService;

    @GetMapping("/create")
    public String addShow(Model model) {
        model.addAttribute("serviceDto", new ServiceDto());
        model.addAttribute("serviceTypes", serviceType.findAll());
        model.addAttribute("rentTypeServices", rentTypeService.findAll());
        return "service/create";
    }

    @PostMapping("/create")
    public String add(@ModelAttribute @Validated ServiceDto serviceDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("serviceDto", serviceDto);
            model.addAttribute("serviceTypes", serviceType.findAll());
            model.addAttribute("rentTypeServices", rentTypeService.findAll());
            return "service/create";
        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        service.setStatus(1);
        redirectAttributes.addFlashAttribute("mess", "Successfully added new service : " + service.getServiceName());
        serviceImpl.add(service);
        return "redirect:/service";
    }

    @GetMapping("")
    public String list(@PageableDefault(value = 5) Pageable pageable, Model model
            , @RequestParam(defaultValue = "") String customerName,
                       @RequestParam(defaultValue = "") String serviceName) {
        Page<Contract> contract = contractService.findAll(customerName, serviceName, pageable);
        model.addAttribute("contracts", contract);
        return "service/list";
    }

    @GetMapping("/update/{id}")
    public String list(@PathVariable String id, Model model) {
        Service service = serviceImpl.findById(id).get();
        ServiceDto serviceDto = new ServiceDto();
        BeanUtils.copyProperties(service, serviceDto);
        model.addAttribute("serviceDto", serviceDto);
        model.addAttribute("serviceTypes", serviceType.findAll());
        model.addAttribute("rentTypeServices", rentTypeService.findAll());
        return "service/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Valid ServiceDto serviceDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("serviceDto", serviceDto);
            model.addAttribute("serviceTypes", serviceType.findAll());
            model.addAttribute("rentTypeServices", rentTypeService.findAll());
            return "service/edit";
        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        service.setStatus(1);
        model.addAttribute("mess","Update service : " +service.getServiceName()+ " successful");
        serviceImpl.add(service);
        return "service/edit";
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
    public String delete(@PathVariable String id,RedirectAttributes redirectAttributes) {
        Service service = serviceImpl.findById(id).get();
        service.setStatus(0);
        serviceImpl.add(service);
        redirectAttributes.addFlashAttribute("messDelete", "Delete service : " + service.getServiceName() + " successful");
        return "redirect:/service";
    }
}
