package QuanLiBanHang.model;

import java.io.Serializable;

public class MatHang implements Serializable{
    private int MaMatHang;
    private SanPham SanPham;
    private int SoLuong;
    private float GiaBan;

    public MatHang() {
        super();
    }

    public int getMaMatHang() {
        return MaMatHang;
    }

    public void setMaMatHang(int MaMatHang) {
        this.MaMatHang = MaMatHang;
    }

    public SanPham getSanPham() {
        return SanPham;
    }

    public void setSanPham(SanPham SanPham) {
        this.SanPham = SanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }
    
    public double getTotal(){
        return getGiaBan()*getSoLuong();
    }
    
    public double getTax(){
        return getTotal()*0.02;
    }
}
