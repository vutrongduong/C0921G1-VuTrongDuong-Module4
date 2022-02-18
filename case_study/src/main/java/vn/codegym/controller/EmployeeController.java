package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.model.Employee;
import vn.codegym.service.IDivisionService;
import vn.codegym.service.IEducationDegreeService;
import vn.codegym.service.IEmployeeService;
import vn.codegym.service.IPositionService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IEducationDegreeService educationDegreeService;
    @Autowired
    private IDivisionService divisionService;

    @GetMapping("/create")
    public String addShow(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("positions",positionService.findAll());
        model.addAttribute("educationDegrees",educationDegreeService.findAll());
        model.addAttribute("divisions",divisionService.findAll());
        return "employee/create";
    }

    @PostMapping("/create")
    public String addShow(@ModelAttribute Employee employee) {
        employeeService.add(employee);
        return "employee/create";
    }
}
