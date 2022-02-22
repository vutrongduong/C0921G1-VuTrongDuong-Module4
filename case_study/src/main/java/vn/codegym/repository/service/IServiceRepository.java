package vn.codegym.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.service.Service;

@Repository
public interface IServiceRepository extends JpaRepository<Service, String> {
//    @Query(value = "select * " +
//            " from contract as ct " +
//            " left join contract_detail ctd on ct.id=ctd.contract_id " +
//            " left join attach_service as ats on ctd.attach_service_id=ats.attach_service_id " +
//            " left join customer as c on c.customer_id=ct.customer_id " +
//            " where c.status=1;", nativeQuery = true)
//    Page<Contract> search(Pageable pagle);
}
