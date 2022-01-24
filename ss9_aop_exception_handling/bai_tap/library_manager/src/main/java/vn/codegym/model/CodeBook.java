package vn.codegym.model;

import javax.persistence.*;

@Entity
public class CodeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long code;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public CodeBook() {
    }

    public CodeBook(Long code, Book book) {
        this.code = code;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

//    @Override
//    public String toString() {
//        return "CodeBook{" +
//                "id=" + id +
//                ", code=" + code +
//                ", book=" + book +
//                '}';
//    }
}
