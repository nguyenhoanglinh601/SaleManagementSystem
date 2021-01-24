package QuanLiBanHang.DAO;

import QuanLiBanHang.Helper.DatabaseHelper;
import QuanLiBanHang.model.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO {
   public boolean ThemHoaDon(HoaDon hoadon) throws SQLException{
       String sql="INSERT INTO `hoadon`(`MaHoaDon`, `MaKhachHang`, `MaNhanVien`, `ThueVAT`, `GiamGia`, `ThoiGianBan`) VALUES (null,?,?,?,?,?);";
       try(
               Connection con=DatabaseHelper.openConnection();
               PreparedStatement pstmt=con.prepareStatement(sql);
               ){
           pstmt.setInt(1,hoadon.getMaKhachHang());
           pstmt.setInt(2,hoadon.getMaNhanVien());
           pstmt.setFloat(3, hoadon.getThueVAT());
           pstmt.setFloat(4, hoadon.getGiamGia());
           pstmt.setString(5, hoadon.getThoiGianBan());
           return pstmt.executeUpdate()>0;
       }
   }
   
   public HoaDon LayHoaDonMoiNhat() throws SQLException{
       String sql="SELECT * FROM hoadon ORDER BY MaHoaDon DESC LIMIT 1";
       try(
               Connection con=DatabaseHelper.openConnection();
               PreparedStatement pstmt=con.prepareStatement(sql);
               ){
            try(ResultSet rs=pstmt.executeQuery();){
                if(rs.next()){
                    HoaDon hoadon=new HoaDon();
                    hoadon.setMaHoaDon(rs.getInt("MaHoaDon"));
                    hoadon.setMaKhachHang(rs.getInt("MaKhachHang"));
                    hoadon.setMaNhanVien(rs.getInt("MaNhanVien"));
                    hoadon.setThueVAT(rs.getInt("ThueVAT"));
                    hoadon.setGiamGia(rs.getInt("GiamGia"));
                    hoadon.setThoiGianBan(rs.getString("ThoiGianBan"));
                    return hoadon; 
                }
            }
       }
       return null;
   }
   
   public List<HoaDon> findAllOrderByTime(String timeBegin,String timeEnd) throws SQLException{
       List<HoaDon> list=new ArrayList<>();
       
       String sql="SELECT * FROM `hoadon` WHERE ThoiGianBan BETWEEN CAST(? AS DATE) AND CAST(? AS DATE)";
       
       try(
               Connection con=DatabaseHelper.openConnection();
               PreparedStatement pstmt=con.prepareStatement(sql);
               ){
           pstmt.setString(1, timeBegin);
           pstmt.setString(2, timeEnd);
           ResultSet rs=pstmt.executeQuery();
           while(rs.next()){
               HoaDon hoadon=new HoaDon();
               hoadon.setMaHoaDon(rs.getInt("MaHoaDon"));
               hoadon.setMaNhanVien(rs.getInt("MaNhanVien"));
               hoadon.setMaKhachHang(rs.getInt("MaKhachHang"));
               hoadon.setThueVAT(rs.getFloat("ThueVAT"));
               hoadon.setGiamGia(rs.getFloat("GiamGia"));
               hoadon.setThoiGianBan(rs.getString("ThoiGianBan"));
               list.add(hoadon);
           }
       }
       return list;
   }
   
   public List<HoaDon> findOrder(String element,String information) throws SQLException{
       List<HoaDon> list =new ArrayList();
       String sql="";
        if(element.equalsIgnoreCase("MaHoaDon")){
            sql="SELECT * FROM `hoadon` WHERE MaHoaDon=?";
        }
        if(element.equalsIgnoreCase("MaKhachHang")){
            sql="SELECT * FROM `hoadon` WHERE MaKhachHang=?";
        }
        if(element.equalsIgnoreCase("MaNhanVien")){
            sql="SELECT * FROM `hoadon` WHERE MaNhanVien=?";
        }
       
       try(
               Connection con=DatabaseHelper.openConnection();
               PreparedStatement pstmt=con.prepareStatement(sql);
               ){
           pstmt.setString(1, information);
           ResultSet rs=pstmt.executeQuery();
               while(rs.next()){
                    HoaDon hoadon=new HoaDon();
                    hoadon.setMaHoaDon(rs.getInt("MaHoaDon"));
                    hoadon.setMaNhanVien(rs.getInt("MaNhanVien"));
                    hoadon.setMaKhachHang(rs.getInt("MaKhachHang"));
                    hoadon.setThueVAT(rs.getFloat("ThueVAT"));
                    hoadon.setGiamGia(rs.getFloat("GiamGia"));
                    hoadon.setThoiGianBan(rs.getString("ThoiGianBan"));
                    list.add(hoadon);
                }
       }
       return list;
   }
   
   public HoaDon findOrderByOrderId(String MaHoaDon) throws SQLException{
       HoaDon hoadon=new HoaDon();
       
       String sql="SELECT * FROM `hoadon` WHERE MaHoaDon=?";
       
       try(
               Connection con=DatabaseHelper.openConnection();
               PreparedStatement pstmt=con.prepareStatement(sql);
               ){
           pstmt.setString(1,MaHoaDon);
           ResultSet rs=pstmt.executeQuery();
           while(rs.next()){
                hoadon.setMaHoaDon(rs.getInt("MaHoaDon"));
                hoadon.setMaNhanVien(rs.getInt("MaNhanVien"));
                hoadon.setMaKhachHang(rs.getInt("MaKhachHang"));
                hoadon.setThueVAT(rs.getFloat("ThueVAT"));
                hoadon.setGiamGia(rs.getFloat("GiamGia"));
                hoadon.setThoiGianBan(rs.getString("ThoiGianBan"));
           }
       }
       return hoadon;
   }
   
   public List<HoaDon> getAllOrder() throws SQLException{
       List<HoaDon> list=new ArrayList<>();
       
       String sql="SELECT * FROM `hoadon`";
       
       try(
               Connection con=DatabaseHelper.openConnection();
               PreparedStatement pstmt=con.prepareStatement(sql);
               ){
           ResultSet rs=pstmt.executeQuery();
           while(rs.next()){
                HoaDon hoadon=new HoaDon();
                hoadon.setMaHoaDon(rs.getInt("MaHoaDon"));
                hoadon.setMaNhanVien(rs.getInt("MaNhanVien"));
                hoadon.setMaKhachHang(rs.getInt("MaKhachHang"));
                hoadon.setThueVAT(rs.getFloat("ThueVAT"));
                hoadon.setGiamGia(rs.getFloat("GiamGia"));
                hoadon.setThoiGianBan(rs.getString("ThoiGianBan"));
                list.add(hoadon);
           }
       }
       return list;
   }
}
