package vn.codegym.model.contract_detail;

import org.springframework.format.annotation.DateTimeFormat;
import vn.codegym.model.customer.Customer;
import vn.codegym.model.employee.Employee;
import vn.codegym.model.service.Service;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String deposit;
    private String totalMoney;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "serviceId")
    private Service service;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "contract")
    private ContractDetail contractDetail;

    public Contract() {
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

    public ContractDetail getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(ContractDetail contractDetail) {
        this.contractDetail = contractDetail;
    }
}
