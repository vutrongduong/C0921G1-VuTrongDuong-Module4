package vn.codegym.model;

import java.util.Arrays;

public class ToKhaiYTe {
    String ten;
    int namSinh;
    String gioiTinh;
    String quocTich;
    String cmnd;
    ThongTinDiLai thongTinDiLai;
    LienLac lienLac;
    String[] trieuChung;
    String[] phoiNhiem;

    public ToKhaiYTe() {
    }

    public ToKhaiYTe(String ten, int namSinh, String gioiTinh, String quocTich, String cmnd, ThongTinDiLai thongTinDiLai, LienLac lienLac, String[] trieuChung, String[] phoiNhiem) {
        this.ten = ten;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.cmnd = cmnd;
        this.thongTinDiLai = thongTinDiLai;
        this.lienLac = lienLac;
        this.trieuChung = trieuChung;
        this.phoiNhiem = phoiNhiem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public ThongTinDiLai getThongTinDiLai() {
        return thongTinDiLai;
    }

    public void setThongTinDiLai(ThongTinDiLai thongTinDiLai) {
        this.thongTinDiLai = thongTinDiLai;
    }

    public LienLac getLienLac() {
        return lienLac;
    }

    public void setLienLac(LienLac lienLac) {
        this.lienLac = lienLac;
    }

    public String[] getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String[] trieuChung) {
        this.trieuChung = trieuChung;
    }

    public String[] getPhoiNhiem() {
        return phoiNhiem;
    }

    public void setPhoiNhiem(String[] phoiNhiem) {
        this.phoiNhiem = phoiNhiem;
    }

    @Override
    public String toString() {
        return "ToKhaiYTe{" +
                "ten='" + ten + '\'' +
                ", namSinh=" + namSinh +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", quocTich='" + quocTich + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", thongTinDiLai=" + thongTinDiLai +
                ", lienLac=" + lienLac +
                ", trieuChung=" + Arrays.toString(trieuChung) +
                ", phoiNhiem=" + Arrays.toString(phoiNhiem) +
                '}';
    }
}
