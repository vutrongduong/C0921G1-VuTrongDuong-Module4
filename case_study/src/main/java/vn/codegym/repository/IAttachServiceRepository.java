package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.AttachService;
@Repository
public interface IAttachServiceRepository extends JpaRepository<AttachService,Long> {
}
