package vn.codegym.model.employee;

import vn.codegym.model.employee.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionId;
    private String positionName;

    @OneToMany(mappedBy = "position")
    List<Employee> employeeList;

    public Position() {
    }

    public Position(Long positionId, String positionName, List<Employee> employeeList) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.employeeList = employeeList;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
