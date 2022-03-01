package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneral<T> {
    Page<T> findAll(Pageable pageable);
    void save(T t);
    Optional<T> findById(Long id);
    void delete(Long id);
}
