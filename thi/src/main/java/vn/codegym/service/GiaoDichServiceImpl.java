package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.GiaoDich;
import vn.codegym.repository.IGiaoDichRepositoty;

import java.util.List;
import java.util.Optional;

@Service
public class GiaoDichServiceImpl implements IGiaoDichService {
    @Autowired
    IGiaoDichRepositoty repositoty;


    @Override
    public List<GiaoDich> findAll() {
        return repositoty.findAll();
    }

    @Override
    public void save(GiaoDich giaoDich) {
        repositoty.save(giaoDich);
    }

    @Override
    public Optional<GiaoDich> findById(String id) {
        return repositoty.findById(id);
    }

    @Override
    public void delete(String id) {
        repositoty.deleteById(id);
    }

    @Override
    public List<GiaoDich> search(String loaiDichVuId, String tenKhachHang) {
        return repositoty.search(loaiDichVuId,tenKhachHang);
    }
}
