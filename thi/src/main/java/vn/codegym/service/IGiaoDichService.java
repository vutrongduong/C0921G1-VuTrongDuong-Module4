package vn.codegym.service;

import vn.codegym.model.GiaoDich;

import java.util.List;
import java.util.Optional;

public interface IGiaoDichService {
    List<GiaoDich> findAll();

    void save(GiaoDich giaoDich);

    Optional<GiaoDich> findById(String id);

    void delete(String id);

    List<GiaoDich> search(String loaiDichVuId,String tenKhachHang);
}
