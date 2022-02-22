package vn.codegym.model.customer;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

import vn.codegym.model.contract_detail.Contract;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(generator = "id_gen_customer")
    @GenericGenerator(name = "id_gen_customer", parameters =
    @Parameter(name = "prefix", value = "KH-"), strategy = "vn.codegym.model.customer.IdGenerator")
    private String customerId;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customerTypeId")
    private CustomerType customerType;
    private String customerName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date customerBirthday;
    private Boolean customerGender;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    private Integer status;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
    private Contract contract;

    public Customer() {
    }

    public Customer(String customerId, CustomerType customerType, String customerName, Date customerBirthday, Boolean customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, Contract contract) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.contract = contract;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Boolean getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Customer(String customerId, CustomerType customerType, String customerName, Date customerBirthday, Boolean customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, Integer status, Contract contract) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.status = status;
        this.contract = contract;
    }
}
