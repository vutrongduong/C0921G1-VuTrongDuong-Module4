package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.KhachHang;
import vn.codegym.repository.IKhachHangRepository;

import java.util.List;
@Service
public class KhachHangServiceImpl implements IKhachHangService {

    @Autowired
    private IKhachHangRepository repository;

    @Override
    public List<KhachHang> findAll() {
        return repository.findAll();
    }
}
