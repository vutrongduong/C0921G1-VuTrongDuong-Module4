package vn.codegym.service;

import vn.codegym.model.Service;

import java.util.List;

public interface IService {
    void add(Service service);
    List<Service> findAll();
}
