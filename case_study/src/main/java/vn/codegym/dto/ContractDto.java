package vn.codegym.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.contract_detail.ContractDetail;
import vn.codegym.model.customer.Customer;
import vn.codegym.model.employee.Employee;
import vn.codegym.model.service.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContractDto implements Validator {
    private Long id;
    @NotNull(message = "PLease input start date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @NotNull(message = "PLease input end date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @NotEmpty(message = "PLease input deposit")
    @Pattern(regexp = "^([1-9])([0-9]*)$", message = "Deposit money must be a positive integer")
    private String deposit;
    @NotEmpty(message = "PLease input total money")
    @Pattern(regexp = "^([1-9])([0-9]*)$", message = "Total money must be a positive integer")
    private String totalMoney;
    @NotNull(message = "PLease select employee")
    private Employee employee;
    @NotNull(message = "PLease select customer")
    private Customer customer;
    @NotNull(message = "PLease select service")
    private Service service;

    public ContractDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public static Boolean checkDateContract(Date startDate, Date endDate) {
        boolean flag;
        if (startDate.compareTo(endDate) > 0) {
            flag = false;
        } else if (startDate.compareTo(endDate) < 0) {
            flag = true;
        } else {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if (contractDto.startDate != null && contractDto.endDate != null) {
            if (!checkDateContract(contractDto.startDate, contractDto.endDate)) {
                errors.rejectValue("endDate", "endDate", "The end date must not be less than the start date");
            }
        }
    }
}
