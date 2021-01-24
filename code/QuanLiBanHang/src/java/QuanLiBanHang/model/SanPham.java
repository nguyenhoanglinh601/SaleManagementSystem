package QuanLiBanHang.model;

import java.io.Serializable;
import java.sql.Date;

public class SanPham implements Serializable{
    private int MaSanPham;
    private String TenSanPham;
    private String Loai;
    private int LuongTonKho;
    private int GiaBan;
    private int GiaNhap;
    private int MaNhaCungCap;
    private Date ThoiGianNhap;

    public SanPham() {
    }

    public SanPham(int MaSanPham, int LuongTonKho, int GiaBan, int GiaNhap, int MaNhaCungCap, String TenSanPham, String Loai, Date Ngaynhap) {
        this.MaSanPham = MaSanPham;
        this.LuongTonKho = LuongTonKho;
        this.GiaBan = GiaBan;
        this.GiaNhap = GiaNhap;
        this.MaNhaCungCap = MaNhaCungCap;
        this.TenSanPham = TenSanPham;
        this.Loai = Loai;
        this.ThoiGianNhap = Ngaynhap;
    }
    
    public SanPham(int MaSanPham, String TenSanPham, String Loai, int LuongTonKho, int GiaBan, int GiaNhap, int MaNhaCungCap, Date ThoiGianNhap) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.Loai = Loai;
        this.LuongTonKho = LuongTonKho;
        this.GiaBan = GiaBan;
        this.GiaNhap = GiaNhap;
        this.MaNhaCungCap = MaNhaCungCap;
        this.ThoiGianNhap = ThoiGianNhap;
    }

    public SanPham(int parseInt, int parseInt0, int parseInt1, int parseInt2, String tensp, String loai, Date valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public int getLuongTonKho() {
        return LuongTonKho;
    }

    public void setLuongTonKho(int LuongTonKho) {
        this.LuongTonKho = LuongTonKho;
    }

    public int getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(int GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(int GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public int getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(int MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }

    public Date getThoiGianNhap() {
        return ThoiGianNhap;
    }

    public void setThoiGianNhap(Date ThoiGianNhap) {
        this.ThoiGianNhap = ThoiGianNhap;
    }
}

