package vn.codegym.service.employee;

import vn.codegym.model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();
}
