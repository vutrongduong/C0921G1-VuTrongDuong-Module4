package vn.codegym.model.employee;

import vn.codegym.model.employee.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long divisionId;
    private String divisionName;

    @OneToMany(mappedBy = "division")
    List<Employee> employeeList;

    public Division() {
    }

    public Division(Long divisionId, String divisionName, List<Employee> employeeList) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.employeeList = employeeList;
    }

    public Long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
