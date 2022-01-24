package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.CodeBook;

@Repository
public interface ICodeBookRepository extends JpaRepository<CodeBook, Long> {
    CodeBook findByCode(Long code);
}
