package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.AttachService;
import vn.codegym.repository.IAttachServiceRepository;
import vn.codegym.service.IAttachService;

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
