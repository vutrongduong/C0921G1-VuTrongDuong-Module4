package vn.codegym.repository.contract_detail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.model.contract_detail.Contract;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "SELECT * FROM  Contract  \n" +
            "            left join contract_detail  on contract.id=contract_detail.contract_id " +
            "            left join attach_service as attach_service on contract_detail.attach_service_id=attach_service.attach_service_id " +
            "            left join customer  on customer.customer_id=contract.customer_id " +
            "            left join service  on contract.service_id=service.service_id  where customer.customer_name like concat('%',:customerName,'%') " +
            " and  service.service_name like concat('%',:serviceName,'%')   and customer.status = 1 and service.status = 1 ", nativeQuery = true)
    Page<Contract> search(@Param("customerName") String customerName,
                          @Param("serviceName") String serviceName,
                          Pageable pagle);
}