package QuanLiBanHang.model;

import java.util.ArrayList;
import java.util.List;

public class StasticOrder extends HoaDon {
    List<ChiTietHoaDon> list=new ArrayList<>();

    public StasticOrder(){
        
    }
    
    public StasticOrder(HoaDon hoadon) {
        super(hoadon.getMaHoaDon(), hoadon.getMaKhachHang(), hoadon.getMaNhanVien(), hoadon.getThueVAT(), hoadon.getGiamGia(), hoadon.getThoiGianBan());
    }

    public StasticOrder(int MaHoaDon, int MaKhachHang, int MaNhanVien, float ThueVAT, float GiamGia, String ThoiGianBan) {
        super(MaHoaDon, MaKhachHang, MaNhanVien, ThueVAT, GiamGia, ThoiGianBan);
    }

    public List<ChiTietHoaDon> getList() {
        return list;
    }

    public void setList(List<ChiTietHoaDon> list) {
        this.list = list;
    }
    
    public float countTotalOnOrder(){
        float total=0;
        for(ChiTietHoaDon orderdetail: list){
            total=total+orderdetail.getGiaBan()*orderdetail.getSoLuong();
        }
        return total;
    }
    
    public int countProductOnOrder(){
        int countProduct=0;
        for(ChiTietHoaDon orderdetail: list){
            countProduct=countProduct+orderdetail.getSoLuong();
        }
        return countProduct;
    }
    
}
