package vn.codegym.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.service.ServiceType;
@Repository
public interface IServiceTypeRepository extends JpaRepository<ServiceType,Long> {
}
