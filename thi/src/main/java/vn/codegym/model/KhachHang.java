package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    @OneToMany(mappedBy = "khachHang")
    private List<GiaoDich> giaoDiches;

    public KhachHang() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<GiaoDich> getGiaoDiches() {
        return giaoDiches;
    }

    public void setGiaoDiches(List<GiaoDich> giaoDiches) {
        this.giaoDiches = giaoDiches;
    }
}
