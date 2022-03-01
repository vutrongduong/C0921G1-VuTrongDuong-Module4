package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Category;
import vn.codegym.repository.ICategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository repository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Category> findAllCategory() {
        return repository.findAll();
    }

}
