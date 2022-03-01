package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.dto.CustomerDto;
import vn.codegym.dto.EmployeeDto;
import vn.codegym.model.Role;
import vn.codegym.model.User;
import vn.codegym.model.customer.Customer;
import vn.codegym.model.employee.Division;
import vn.codegym.model.employee.EducationDegree;
import vn.codegym.model.employee.Employee;
import vn.codegym.model.employee.Position;
import vn.codegym.repository.UserRepository;
import vn.codegym.security.MyUserDetailService;
import vn.codegym.service.employee.IDivisionService;
import vn.codegym.service.employee.IEducationDegreeService;
import vn.codegym.service.employee.IEmployeeService;
import vn.codegym.service.employee.IPositionService;

import javax.validation.Valid;
import java.util.ArrayList;
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
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String list(@PageableDefault(value = 5) Pageable pageable,
                       Model model, @RequestParam(defaultValue = "") String name,
                       @RequestParam(defaultValue = "") String positionId,
                       @RequestParam(defaultValue = "") String divisionId,
                       @RequestParam(defaultValue = "") String educationDegreeId) {
        model.addAttribute("name", name);
        model.addAttribute("positionId", positionId);
        model.addAttribute("divisionId", divisionId);
        model.addAttribute("educationDegreeId", educationDegreeId);
        model.addAttribute("employees", employeeService.search(name, positionId,
                divisionId, educationDegreeId, pageable));
        return "employee/list";
    }

    @GetMapping("/create")
    public String addShow(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/create";
    }

    @PostMapping("/create")
    public String add(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            return "employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        User user = employee.getUser();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode("123");
        user.setPassword(pass);
        userRepository.save(user);
        employee.setStatus(1);
        redirectAttributes.addFlashAttribute("mess", "Successfully added new employee : " + employee.getEmployeeName());
        employeeService.add(employee);

        if (employee.getPosition().getPositionId() == 1) {
            userRepository.addRole(user.getUserName(), 1);
//            List<Role> roles = new ArrayList<>();
//            Role role = new Role(1, "ROLE_ADMIN");
//            roles.add(role);
//            user.setRoleList(roles);
        } else {
            userRepository.addRole(user.getUserName(), 2);
//            List<Role> roles = new ArrayList<>();
//            Role role = new Role(2, "ROLE_EMP");
//            roles.add(role);
//            user.setRoleList(roles);
        }
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
    public String delete(@PathVariable Long id, Model model, @PageableDefault(size = 2) Pageable pageable,RedirectAttributes redirectAttributes) {
        Employee employee = employeeService.findById(id).get();
        employee.setStatus(0);
        employeeService.add(employee);
        model.addAttribute("employees", employeeService.findAll(pageable));
        redirectAttributes.addFlashAttribute("messDelete", "Delete employee : " + employee.getEmployeeName() + " successful");
        return "redirect:/employee";
    }

    @GetMapping("/update/{id}")
    public String updateShow(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id).get();
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        return "employee/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("employeeDto") @Validated EmployeeDto employeeDto, BindingResult bindingResult, Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            return "employee/update";
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            model.addAttribute("mess", "Update employee : " + employee.getEmployeeName() + " successful");
            employee.setStatus(1);
            employeeService.add(employee);
            return "redirect:/employee";
        }
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
