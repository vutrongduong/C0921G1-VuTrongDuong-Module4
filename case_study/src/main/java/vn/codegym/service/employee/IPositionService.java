package vn.codegym.service.employee;

import vn.codegym.model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
}
