package vn.codegym.repository.contract_detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.contract_detail.ContractDetail;
@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail,Long> {
}
