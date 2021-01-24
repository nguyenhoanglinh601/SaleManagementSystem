package QuanLiBanHang.model;

import java.io.Serializable;

public class NhaCungCap implements Serializable{
    private int MaNhaCungCap;
    private String TenNhaCungCap;
    private  int SDT;
    private String Email;
    private String DiaChi;

    public NhaCungCap() {
    }

    public NhaCungCap(int MaNhaCungCap, String TenNhaCungCap, int SDT, String Email, String DiaChi) {
        this.MaNhaCungCap = MaNhaCungCap;
        this.TenNhaCungCap = TenNhaCungCap;
        this.SDT = SDT;
        this.Email = Email;
        this.DiaChi = DiaChi;
    }
    
    public int getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(int MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return TenNhaCungCap;
    }

    public void setTenNhaCungCap(String TenNhaCungCap) {
        this.TenNhaCungCap = TenNhaCungCap;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
}
