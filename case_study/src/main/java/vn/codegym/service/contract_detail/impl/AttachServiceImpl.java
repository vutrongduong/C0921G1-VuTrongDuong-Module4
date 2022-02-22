package vn.codegym.service.contract_detail.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.contract_detail.AttachService;
import vn.codegym.repository.contract_detail.IAttachServiceRepository;
import vn.codegym.service.contract_detail.IAttachService;

import java.util.List;

@Service
public class AttachServiceImpl implements IAttachService {
    @Autowired
    IAttachServiceRepository repository;

    @Override
    public List<AttachService> findAll() {
        return repository.findAll();
    }
}
