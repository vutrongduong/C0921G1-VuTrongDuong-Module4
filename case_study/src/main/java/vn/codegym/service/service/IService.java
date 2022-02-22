package vn.codegym.service.service;


import vn.codegym.model.service.Service;


import java.util.List;
import java.util.Optional;

public interface IService {
    void add(Service service);
    List<Service> findAll();
    Optional<Service> findById(String id);
    void delete(Service service);
}
