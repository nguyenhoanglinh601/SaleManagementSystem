package QuanLiBanHang.model;

import java.io.Serializable;
import java.util.List;

public class DonHang implements Serializable{
    private int MaHoaDon;
    private int MaKhachHang;
    private List<MatHang> DanhSachMatHang;
    private int TrangThai;

    public DonHang() {
        this.TrangThai=0;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public List<MatHang> getDanhSachMatHang() {
        return DanhSachMatHang;
    }

    public void setDanhSachMatHang(List<MatHang> DanhSachMatHang) {
        this.DanhSachMatHang = DanhSachMatHang;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    public int getQuantityProduct(){
        int Quantity=0;
        for(MatHang mathang: DanhSachMatHang){
            Quantity=Quantity+mathang.getSoLuong();
        }
        return Quantity;
    }
    
    public double getTax(){
        double tax=0;
        for(MatHang mathang: DanhSachMatHang){
            tax=tax+mathang.getTax();
        }
        return tax;
    }
    
    public double getTotal(){
        double total=0;
        for(MatHang mathang: DanhSachMatHang){
            total=total+mathang.getTotal();
        }
        return total;
    }
    
    public double getDiscount(){
        if(getTotal()>100000)   
            return getTotal()*0.1;
        return 0;
    }
    
    public double getTotalAfterDiscount(){
        return getTotal()-getDiscount();
    }
}
