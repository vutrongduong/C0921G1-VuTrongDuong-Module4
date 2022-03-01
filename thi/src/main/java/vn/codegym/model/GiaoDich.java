package vn.codegym.model;

import javax.persistence.*;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class GiaoDich {
    @Id
    @GeneratedValue(generator = "id_gen_customer")
    @GenericGenerator(name = "id_gen_customer", parameters =
    @Parameter(name = "prefix", value = "MGD-"), strategy = "vn.codegym.model.IdGenerator")
    private String giaoDichId;

    @ManyToOne(targetEntity = KhachHang.class)
    private KhachHang khachHang;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayGiaoDich;
    @ManyToOne(targetEntity = LoaiDichVu.class)
    private LoaiDichVu loaiDichVu;
    private String donGia;
    private String dienTich;

    public GiaoDich() {
    }

    public String getGiaoDichId() {
        return giaoDichId;
    }

    public void setGiaoDichId(String giaoDichId) {
        this.giaoDichId = giaoDichId;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public LoaiDichVu getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getDienTich() {
        return dienTich;
    }

    public void setDienTich(String dienTich) {
        this.dienTich = dienTich;
    }
}
