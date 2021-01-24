package QuanLiBanHang.model;

import java.io.Serializable;

public class KhachHang implements Serializable{
    private int MaKhachHang;
    private String TenKhachHang;
    private String SDT;
    private String DiaChi;
    private String Email;
    private int Diem;

    public KhachHang() {
    }

    public KhachHang(int MaKhachHang, String TenKhachHang, String SDT, String DiaChi, String Email, int Diem) {
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.Diem = Diem;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getDiem() {
        return Diem;
    }

    public void setDiem(int Diem) {
        this.Diem = Diem;
    }
}
