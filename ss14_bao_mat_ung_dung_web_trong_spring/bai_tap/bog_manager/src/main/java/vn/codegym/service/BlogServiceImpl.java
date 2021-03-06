package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Blog;
import vn.codegym.repository.IBlogRepository;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }
}
