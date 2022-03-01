package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.LoaiDichVu;
import vn.codegym.repository.ILoaiDichVuRepository;

import java.util.List;

@Service
public class LoaiDichVuServiceImpl implements ILoaiDichVuService {
    @Autowired
    private ILoaiDichVuRepository repository;

    @Override
    public List<LoaiDichVu> findAll() {
        return repository.findAll();
    }
}
