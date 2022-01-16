package vn.codegym.model;

public class LienLac {
    private String thanhPho;
    private String huyen;
    private String xa;
    private String diaChi;
    private String dienThoai;
    private String email;

    public LienLac() {
    }

    public LienLac(String thanhPho, String huyen, String xa, String diaChi, String dienThoai, String email) {
        this.thanhPho = thanhPho;
        this.huyen = huyen;
        this.xa = xa;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.email = email;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getHuyen() {
        return huyen;
    }

    public void setHuyen(String huyen) {
        this.huyen = huyen;
    }

    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
