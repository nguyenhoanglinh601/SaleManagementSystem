package QuanLiBanHang.DAO;

import QuanLiBanHang.Helper.DatabaseHelper;
import QuanLiBanHang.model.ChiTietHoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonDAO {
    public boolean ThemChiTietHoaDon(ChiTietHoaDon chitiethoadon) throws SQLException{
        String sql="INSERT INTO `chitiethoadon`(`MaHoaDon`, `MaSanPham`, `GiaBan`, `SoLuong`) VALUES (?,?,?,?);";
        try(
               Connection con=DatabaseHelper.openConnection();
               PreparedStatement pstmt=con.prepareStatement(sql);
               ){
           pstmt.setInt(1,chitiethoadon.getMaHoaDon());
           pstmt.setInt(2,chitiethoadon.getMaSanPham());
           pstmt.setFloat(3, chitiethoadon.getGiaBan());
           pstmt.setInt(4, chitiethoadon.getSoLuong());
           return pstmt.executeUpdate()>0;
       }
    }
    
    public List<ChiTietHoaDon> findAllOrderDetailByTime(String timeBegin, String timeEnd) throws SQLException{
        List<ChiTietHoaDon> list=new ArrayList<>();
        
        String sql="SELECT chitiethoadon.MaHoaDon, chitiethoadon.MaSanPham, chitiethoadon.GiaBan, chitiethoadon.SoLuong FROM `hoadon`,`chitiethoadon` WHERE ThoiGianBan BETWEEN CAST(? AS DATE) AND CAST(? AS DATE) AND hoadon.MaHoaDon=chitiethoadon.MaHoaDon";
        
        try(
                Connection con=DatabaseHelper.openConnection();
                PreparedStatement pstmt=con.prepareStatement(sql);
                
                ){
            pstmt.setString(1, timeBegin);
            pstmt.setString(2, timeEnd);
            try(ResultSet rs=pstmt.executeQuery();){
                while(rs.next()){
                    ChiTietHoaDon OrderDetail = new ChiTietHoaDon();
                    OrderDetail.setMaHoaDon(rs.getInt("MaHoaDon"));
                    OrderDetail.setMaSanPham(rs.getInt("MaSanPham"));
                    OrderDetail.setGiaBan(rs.getFloat("GiaBan"));
                    OrderDetail.setSoLuong(rs.getInt("SoLuong"));
                    list.add(OrderDetail);
                }
            }
        }
        return list;
    }
    
    public List<ChiTietHoaDon> findOrderDetailByOrderId(String MaHoaDon) throws SQLException{
        List<ChiTietHoaDon> list = new ArrayList<>();
        
        String sql="SELECT * FROM `chitiethoadon` WHERE MaHoaDon=?";
        
        try(
                Connection con=DatabaseHelper.openConnection();
                PreparedStatement pstmt=con.prepareStatement(sql);
                ){
            pstmt.setString(1,MaHoaDon);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ChiTietHoaDon OrderDetail = new ChiTietHoaDon();
                OrderDetail.setMaHoaDon(rs.getInt("MaHoaDon"));
                OrderDetail.setMaSanPham(rs.getInt("MaSanPham"));
                OrderDetail.setGiaBan(rs.getFloat("GiaBan"));
                OrderDetail.setSoLuong(rs.getInt("SoLuong"));
                list.add(OrderDetail);
            }
        }
        return list;
    }
    
    public List<Integer> findOrderIdByProductId(String MaSanPham) throws SQLException{
        List<Integer> listOrderId=new ArrayList<>();
        
        String sql="SELECT MaHoaDon FROM `chitiethoadon` WHERE MaSanPham=?";
        
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt=con.prepareStatement(sql);
                ){
            pstmt.setString(1, MaSanPham);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                listOrderId.add(rs.getInt("MaHoaDon"));
            }
        }
        return listOrderId;
    }
}
