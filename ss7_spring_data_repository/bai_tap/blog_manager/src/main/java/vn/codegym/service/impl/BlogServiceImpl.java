package vn.codegym.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Blog;
import vn.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.service.IBlogService;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Blog> findByName(String name, Pageable pageable) {
        return repository.findByNameContaining(name, pageable);
    }

    @Override
    public List<Blog> findByCategory(Long id, Pageable pageable) {
        return repository.findByCategory_Id(id, pageable);
    }

    @Override
    public List<Blog> findByNameAndCategory(String name, Long id, Pageable pageable) {
        return repository.findByNameContainingAndCategory_Id(name,id,pageable);
    }
}
