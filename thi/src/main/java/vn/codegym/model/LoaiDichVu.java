package vn.codegym.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class LoaiDichVu {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "loaiDichVu")
    private List<GiaoDich> giaoDiches;

    public LoaiDichVu() {
    }

    public LoaiDichVu(Long id, String name, List<GiaoDich> giaoDiches) {
        this.id = id;
        this.name = name;
        this.giaoDiches = giaoDiches;
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

    public List<GiaoDich> getGiaoDiches() {
        return giaoDiches;
    }

    public void setGiaoDiches(List<GiaoDich> giaoDiches) {
        this.giaoDiches = giaoDiches;
    }
}
