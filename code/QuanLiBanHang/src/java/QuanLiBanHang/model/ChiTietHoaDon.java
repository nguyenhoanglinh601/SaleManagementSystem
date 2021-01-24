package QuanLiBanHang.model;

import java.io.Serializable;

public class ChiTietHoaDon implements Serializable{
    private int MaHoaDon;
    private int MaSanPham;
    private float GiaBan;
    private int SoLuong;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int MaHoaDon, int MaSanPham, float GiaBan, int SoLuong) {
        this.MaHoaDon = MaHoaDon;
        this.MaSanPham = MaSanPham;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
    }

    

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    public float countTotalOrderDetail(){
        return getGiaBan()*getSoLuong();
    }
}
