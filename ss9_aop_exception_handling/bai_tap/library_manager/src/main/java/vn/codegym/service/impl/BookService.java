package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Book;
import vn.codegym.repository.IBookRepository;
import vn.codegym.service.IBookService;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository repository;

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
