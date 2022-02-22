package vn.codegym.repository.contract_detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.contract_detail.AttachService;
@Repository
public interface IAttachServiceRepository extends JpaRepository<AttachService,Long> {
}
