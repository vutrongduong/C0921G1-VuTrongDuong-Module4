package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.LoaiDichVu;

public interface ILoaiDichVuRepository extends JpaRepository<LoaiDichVu, Long> {
}
