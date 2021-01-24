package QuanLiBanHang.model;

import java.util.ArrayList;
import java.util.List;

public class StasticKhachHang extends KhachHang {
    List<KhachHang> list=new ArrayList<>();

    public StasticKhachHang() {
    }

    public StasticKhachHang(int MaKhachHang, String TenKhachHang, String SDT, String DiaChi, String Email, int Diem) {
        super(MaKhachHang, TenKhachHang, SDT, DiaChi, Email, Diem);
    }

    public List<KhachHang> getList() {
        return list;
    }

    public void setList(List<KhachHang> list) {
        this.list = list;
    }
    
    public float countTotalKH(){
        float total=0;
        for(KhachHang KHdetail: list){
            total=total+KHdetail.getMaKhachHang()*KHdetail.getDiem();
        }
        return total;
    }
}
