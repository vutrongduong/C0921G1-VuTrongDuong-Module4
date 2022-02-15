package vn.codegym.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerTypeId;
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType")
    private List<Customer> customerList;

    public CustomerType() {
    }

    public CustomerType(String customerTypeName, List<Customer> customers) {
        this.customerTypeName = customerTypeName;
        this.customerList = customers;
    }


    public Long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public List<Customer> getCustomers() {
        return customerList;
    }

    public void setCustomers(List<Customer> customers) {
        this.customerList = customers;
    }
}
