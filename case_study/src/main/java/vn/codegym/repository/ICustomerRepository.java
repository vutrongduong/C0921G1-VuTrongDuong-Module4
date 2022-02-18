package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
    @Query(value="SELECT * FROM  Customer where customer_name like concat('%',:customerName,'%') " +
            " and  customer_address like concat('%',:customerAdress,'%')  and customer_type_id like concat('%',:customerTypeId,'%')", nativeQuery=true)
    Page<Customer> searchCustomer(@Param("customerName") String customerName,
                                  @Param("customerAdress") String customerAdress,
                                  @Param("customerTypeId") String customerTypeId,
                                  Pageable pagle);
}
