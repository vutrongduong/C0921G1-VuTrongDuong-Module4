package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.GiaoDich;

import java.util.List;

public interface IGiaoDichRepositoty extends JpaRepository<GiaoDich, String> {
    @Query(value = "SELECT * FROM  thi_module_4.giao_dich " +
            " join thi_module_4.khach_hang on khach_hang.id=giao_dich.khach_hang_id " +
            " where loai_dich_vu_id like concat('%',:loaiDichVuId,'%') " +
            "            and `name` like concat('%',:tenKhachHang,'%') ", nativeQuery = true)
    List<GiaoDich>
    search(@Param("loaiDichVuId") String loaiDichVuId,
                         @Param("tenKhachHang") String tenKhachHang);
}
