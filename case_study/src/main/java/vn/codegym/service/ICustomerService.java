package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void add(Customer customer);
    Customer findById(String id);
    void delete(String id);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> find(String name,String address,String typeId,Pageable pageable);
}
