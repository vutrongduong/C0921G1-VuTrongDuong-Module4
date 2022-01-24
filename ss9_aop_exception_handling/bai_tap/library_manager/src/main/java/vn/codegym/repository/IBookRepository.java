package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Book;
@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
}
