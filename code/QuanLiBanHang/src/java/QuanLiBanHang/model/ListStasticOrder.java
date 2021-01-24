package QuanLiBanHang.model;

import QuanLiBanHang.DAO.SanPhamDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListStasticOrder {
    List<StasticOrder> list=new ArrayList<>();

    public ListStasticOrder() {
    }
    
    public ListStasticOrder(List<StasticOrder> list) {
        this.list=list;
    }

    public List<StasticOrder> getList() {
        return list;
    }

    public void setList(List<StasticOrder> list) {
        this.list = list;
    }
    
    public int countProduct(){
        int countProduct=0;
        for(StasticOrder stasticorder: list){
            for(ChiTietHoaDon orderdetail: stasticorder.getList()){
                countProduct=countProduct+orderdetail.getSoLuong();
            }
        }
        return countProduct;
    }
    
    public float countTotalListOrder(){
        float total=0;
        for(StasticOrder stasticorder: list){
            total=total+stasticorder.countTotalOnOrder();
        }
        return total;
    }
    
    public int countCustomerListOrder(){
        List<Integer> listIDCustomer=new ArrayList<>();
        for(StasticOrder stasticorder: list){
            boolean check=false;
            for(int IDCustomerTemp: listIDCustomer){
                if(stasticorder.getMaKhachHang()==IDCustomerTemp){
                    check=true;
                }               
            }
            if(check==false){
                listIDCustomer.add(stasticorder.getMaKhachHang());
            }
        }
        return listIDCustomer.size();
    }
    
    public int countProductListOrder(){
        int countProduct=0;
        for(StasticOrder stasticorder: list){
            countProduct=countProduct+stasticorder.countProductOnOrder();
        }
        return countProduct;
    }
    
    public float countDiscountListOrder(){
        float Discount=0;
        for(StasticOrder stasticorder: list){
            Discount=Discount+stasticorder.getGiamGia();
        }
        return Discount;
    }
    
    public float countEntryPriceListOrder() throws SQLException{
        float totalEntryPrice=0;
        for(StasticOrder stasticorder: list){
            for(ChiTietHoaDon orderdetail: stasticorder.getList()){
                SanPham product=new SanPham();
                SanPhamDAO dao=new SanPhamDAO();
                product=dao.TimTheoMaSanPham(orderdetail.getMaSanPham());
                totalEntryPrice=totalEntryPrice+product.getGiaNhap()*orderdetail.getSoLuong();
            } 
        }
        return totalEntryPrice;
    }
    
    public float countProfitListOrder() throws SQLException{
        return countTotalListOrder()-countDiscountListOrder()-countEntryPriceListOrder();
    }
}
