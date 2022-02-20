package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Customer;
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

    @GetMapping
    public String list(@PageableDefault(value = 2) Pageable pageable,
                       Model model, @RequestParam(defaultValue = "") String name,
                       @RequestParam(defaultValue = "") String positionId,
                       @RequestParam(defaultValue = "") String divisionId,
                       @RequestParam(defaultValue = "") String educationDegreeId) {
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("educations", educationDegreeService.findAll());
        model.addAttribute("employees", employeeService.search(name, positionId,
                divisionId, educationDegreeId, pageable));
        return "employee/list";
    }

    @GetMapping("/create")
    public String addShow(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        return "employee/create";
    }

    @PostMapping("/create")
    public String addShow(@ModelAttribute Employee employee) {
        employeeService.add(employee);
        return "redirect:/employee";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id).get());
        return "employee/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id).get());
        return "employee/delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model, @PageableDefault(size = 2) Pageable pageable) {
        employeeService.delete(employeeService.findById(id).get());
        model.addAttribute("employees", employeeService.findAll(pageable));
        return "employee/list";
    }

    @GetMapping("/update/{id}")
    public String updateShow(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id).get());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("educations", educationDegreeService.findAll());
        return "employee/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Employee employee) {
        employeeService.add(employee);
        return "redirect:/employee";
    }
}
