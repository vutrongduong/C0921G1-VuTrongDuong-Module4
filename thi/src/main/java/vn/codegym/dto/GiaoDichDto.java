package vn.codegym.dto;

import org.springframework.format.annotation.DateTimeFormat;
import vn.codegym.model.KhachHang;
import vn.codegym.model.LoaiDichVu;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class GiaoDichDto {

    private String giaoDichId;
    @NotNull(message = "Vui lòng chọn khách hàng")
    private KhachHang khachHang;
    @NotNull(message = "Nhập ngày giao dịch")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayGiaoDich;
    @NotNull(message = "Vui lòng chọn loại bất động sản ")
    private LoaiDichVu loaiDichVu;
    @NotEmpty(message = "Nhập đơn giá")
    @Pattern(regexp = "^([1-9])([0-9]*)$", message = "Deposit money must be a positive integer")
    private String donGia;
    @NotEmpty(message = "Nhập diện tích")
    @Pattern(regexp = "^([1-9])([0-9]*)$", message = "Deposit money must be a positive integer")
    private String dienTich;

    public GiaoDichDto() {
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
