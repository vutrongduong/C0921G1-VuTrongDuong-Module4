package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.CustomerType;
@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Long> {
}
