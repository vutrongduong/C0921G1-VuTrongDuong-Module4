package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.CodeBook;
import vn.codegym.repository.ICodeBookRepository;
import vn.codegym.service.ICodeBookService;
@Service
public class CodeBookService implements ICodeBookService {
    @Autowired
    ICodeBookRepository repository;

    @Override
    public void add(CodeBook codeBook) {
        repository.save(codeBook);
    }

    @Override
    public void delete(CodeBook codeBook) {
        repository.delete(codeBook);
    }

    @Override
    public CodeBook findByCode(Long code) {
        return repository.findByCode(code);
    }
}
