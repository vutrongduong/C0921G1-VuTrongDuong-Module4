package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.ServiceType;
@Repository
public interface IServiceTypeRepository extends JpaRepository<ServiceType,Long> {
}
