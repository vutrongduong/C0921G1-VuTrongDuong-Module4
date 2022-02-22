package vn.codegym.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.service.RentType;

public interface IRentTypeRepository extends JpaRepository<RentType,Long> {
}
