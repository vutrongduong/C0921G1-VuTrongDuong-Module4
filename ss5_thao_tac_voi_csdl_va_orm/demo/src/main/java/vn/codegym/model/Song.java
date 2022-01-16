package vn.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Song implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String singer;

    public Song() {
    }

    public Song(Long id) {
        this.id = id;
    }

    public Song(String name, String singer) {
        this.name = name;
        this.singer = singer;
    }

    public Song(Long id, String name, String singer) {
        this.id = id;
        this.name = name;
        this.singer = singer;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public Song clone() {
        Song customer = new Song();
        customer.setId(id);
        customer.setName(name);
        customer.setSinger(singer);
        return customer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + singer + '\'' +
                '}';
    }
}