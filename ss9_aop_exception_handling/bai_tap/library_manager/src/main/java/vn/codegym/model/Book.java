package vn.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer amount;
    private String category;

    @OneToMany(mappedBy = "book")
    private Set<CodeBook> codeBook;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<CodeBook> getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(Set<CodeBook> codeBook) {
        this.codeBook = codeBook;
    }
}
