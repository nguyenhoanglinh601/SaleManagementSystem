package QuanLiBanHang.model;

import java.io.Serializable;

public class NhanVien implements Serializable{
    private int MaNhanVien;
    private String TenNhanVien;
    private int SDT;
    private String DiaChi;
    private String TaiKhoan;
    private String MatKhau;
    private boolean Quyen;

    public NhanVien() {
    }
    
    public NhanVien(int MaNhanVien, String TenNhanVien, int SDT, String DiaChi, String TaiKhoan, String MatKhau, boolean Quyen) {
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.Quyen = Quyen;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public boolean isQuyen() {
        return Quyen;
    }

    public void setQuyen(boolean Quyen) {
        this.Quyen = Quyen;
    }
}
