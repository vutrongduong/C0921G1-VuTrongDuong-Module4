package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.employee.Division;
import vn.codegym.model.employee.EducationDegree;
import vn.codegym.model.employee.Employee;
import vn.codegym.model.employee.Position;
import vn.codegym.service.employee.IDivisionService;
import vn.codegym.service.employee.IEducationDegreeService;
import vn.codegym.service.employee.IEmployeeService;
import vn.codegym.service.employee.IPositionService;

import java.util.List;

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
    public String list(@PageableDefault(value = 5) Pageable pageable,
                       Model model, @RequestParam(defaultValue = "") String name,
                       @RequestParam(defaultValue = "") String positionId,
                       @RequestParam(defaultValue = "") String divisionId,
                       @RequestParam(defaultValue = "") String educationDegreeId) {
        model.addAttribute("employees", employeeService.search(name, positionId,
                divisionId, educationDegreeId, pageable));
        return "employee/list";
    }

    @GetMapping("/create")
    public String addShow(Model model) {
        model.addAttribute("employee", new Employee());
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
        return "employee/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Employee employee) {
        employeeService.add(employee);
        return "redirect:/employee";
    }

    @ModelAttribute("positions")
    List<Position> position() {
        return positionService.findAll();
    }

    @ModelAttribute("divisions")
    List<Division> division() {
        return divisionService.findAll();
    }

    @ModelAttribute("educations")
    List<EducationDegree> education() {
        return educationDegreeService.findAll();
    }
}
