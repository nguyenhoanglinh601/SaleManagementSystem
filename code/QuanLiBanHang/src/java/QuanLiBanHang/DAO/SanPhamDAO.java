package QuanLiBanHang.DAO;

import QuanLiBanHang.Helper.DatabaseHelper;
import QuanLiBanHang.model.SanPham;
import QuanLiBanHang.Helper.DatabaseTool;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SanPhamDAO {
    public SanPham TimTheoMaSanPham(int MaSanPham) throws SQLException{
        String sql="select * from sanpham where MaSanPham=?";
        
        try(
                Connection con=DatabaseHelper.openConnection();
                PreparedStatement pstmt=con.prepareStatement(sql);
                ){
            pstmt.setInt(1, MaSanPham);
            try(ResultSet rs=pstmt.executeQuery();){
                if(rs.next()){
                    SanPham sanpham=new SanPham();
                    sanpham.setMaSanPham(rs.getInt("MaSanPham"));
                    sanpham.setTenSanPham(rs.getString("TenSanPham"));
                    sanpham.setLoai(rs.getString("Loai"));
                    sanpham.setLuongTonKho(rs.getInt("LuongTonKho"));
                    sanpham.setGiaBan(rs.getInt("GiaBan"));
                    sanpham.setGiaNhap(rs.getInt("GiaNhap"));
                    sanpham.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                    sanpham.setThoiGianNhap(rs.getDate("ThoiGianNhap"));
                    
                    return sanpham;
                }
            }
        }
        return null;
    }
    
    public List<SanPham> getAllProduct() throws SQLException{
        List<SanPham> list=new ArrayList<>();
        
        String sql="select * from sanpham";
        
        try(
                Connection con=DatabaseHelper.openConnection();
                PreparedStatement pstmt=con.prepareStatement(sql);
                ){
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                SanPham sanpham=new SanPham();
                sanpham.setMaSanPham(rs.getInt("MaSanPham"));
                sanpham.setTenSanPham(rs.getString("TenSanPham"));
                sanpham.setLoai(rs.getString("Loai"));
                sanpham.setLuongTonKho(rs.getInt("LuongTonKho"));
                sanpham.setGiaBan(rs.getInt("GiaBan"));
                sanpham.setGiaNhap(rs.getInt("GiaNhap"));
                sanpham.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                sanpham.setThoiGianNhap(rs.getDate("ThoiGianNhap"));
                list.add(sanpham);
            }
        }
        return list;
    }
    
    public ArrayList<SanPham> getAllSanPham() throws SQLException{
        ArrayList<SanPham> list = new ArrayList<>();
        String sql="SELECT * FROM sanpham";
        try(
            Connection con=DatabaseTool.connect();
             PreparedStatement pstmt=con.prepareStatement(sql);
             ResultSet rs=pstmt.executeQuery();
            ){
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setGiaBan(rs.getInt("GiaBan"));
                sp.setGiaNhap(rs.getInt("GiaNhap"));
                sp.setLuongTonKho(rs.getInt("LuongTonKho"));
                sp.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                sp.setLoai(rs.getString("Loai"));
                sp.setThoiGianNhap(rs.getDate("ThoiGianNhap"));
                list.add(sp);
            }
        }catch(Exception ex){
            ex.getMessage();
        }
        return list;
        
    }
    
    public ArrayList<SanPham> getSanPham(String tensp) throws SQLException {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql="SELECT * FROM `sanpham` WHERE TenSanPham LIKE ?";
        try(
                 Connection con=DatabaseHelper.openConnection();
                 PreparedStatement pstmt=con.prepareStatement(sql);
                 ) {
             pstmt.setString(1,tensp);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setGiaBan(rs.getInt("GiaBan"));
                sp.setGiaNhap(rs.getInt("GiaNhap"));
                sp.setLuongTonKho(rs.getInt("LuongTonKho"));
                sp.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                sp.setLoai(rs.getString("Loai"));
                sp.setThoiGianNhap(Date.valueOf(String.valueOf(rs.getDate("ThoiGianNhap"))));
                list.add(sp);
            }
        } 
        return list;       
    }

    public boolean updateSanPham(SanPham sanpham) {
         String sql="UPDATE `sanpham` SET `MaSanPham`=?,`TenSanPham`=?,`Loai`=?,`LuongTonKho`=?,`GiaBan`=?,`GiaNhap`=?,`MaNhaCungCap`=?,`ThoiGianNhap`=? WHERE `MaSanPham`=?";
         try(
                 Connection con=DatabaseTool.connect();
                 PreparedStatement pstmt=con.prepareStatement(sql);
                 ){
             pstmt.setInt(1,sanpham.getMaSanPham());
             pstmt.setString(2,sanpham.getTenSanPham());
             pstmt.setString(3,sanpham.getLoai());
             pstmt.setInt(4,sanpham.getLuongTonKho());
             pstmt.setInt(5,sanpham.getGiaBan());
             pstmt.setInt(6,sanpham.getGiaNhap());
             pstmt.setInt(7,sanpham.getMaNhaCungCap());
             pstmt.setDate(8,sanpham.getThoiGianNhap());
             pstmt.setInt(9,sanpham.getMaSanPham());
             pstmt.executeUpdate();
             return true;
         }catch (Exception ex) {
            return false;
        }
        
    }

    public boolean deleteSanPham(int masanpham) {
        String sql="DELETE FROM sanpham WHERE MaSanPham=?";
        try(
                 Connection con=DatabaseTool.connect();
                 PreparedStatement pstmt=con.prepareStatement(sql);
                 ){
            pstmt.setInt(1,masanpham);
           return pstmt.executeUpdate()>0;
         }catch (Exception ex) {
            
        }
        return false;
    }
    

    public boolean insertSanPham(SanPham sanpham) {
        String sql="INSERT INTO `sanpham`(`MaSanPham`, `TenSanPham`, `GiaBan`, `GiaNhap`, `LuongTonKho`, `ThoiGianNhap`, `Loai`, `MaNhaCungCap`) VALUES (null,?,?,?,?,?,?,?)";
         try(
                 Connection con=DatabaseTool.connect();
                 PreparedStatement pstmt=con.prepareStatement(sql);
                 ){
           pstmt.setString(1,sanpham.getTenSanPham());
           pstmt.setInt(2,sanpham.getGiaBan());
           pstmt.setInt(3,sanpham.getGiaNhap());
           pstmt.setInt(4,sanpham.getLuongTonKho());
           pstmt.setDate(5,sanpham.getThoiGianNhap());
           pstmt.setString(6,sanpham.getLoai());
           pstmt.setInt(7,sanpham.getMaNhaCungCap());
           return pstmt.executeUpdate()>0;
         }catch (Exception ex) {
            
        }
        return false;
    }
    public ArrayList<SanPham> getlistSanPham(String tensp) throws SQLException{
        ArrayList<SanPham> list = new ArrayList<>();
        String sql="SELECT * FROM sanpham WHERE TenSanPham LIKE ?";
        try(
                 Connection con=DatabaseTool.connect();
                 PreparedStatement pstmt=con.prepareStatement(sql);
                 ) 
        {
            String name="%"+tensp+"%";
            pstmt.setString(1,name);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setGiaBan(rs.getInt("GiaBan"));
                sp.setGiaNhap(rs.getInt("GiaNhap"));
                sp.setLuongTonKho(rs.getInt("LuongTonKho"));
                sp.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                sp.setLoai(rs.getString("Loai"));
                sp.setThoiGianNhap(rs.getDate("ThoiGianNhap"));
                list.add(sp);
            }
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;       
    }
    
    //Lọc danh sách
    //Theo Tên
    public ArrayList<SanPham> getlistTenSanPham(String tensp) throws SQLException{
        ArrayList<SanPham> list = new ArrayList<>();
        String sql="SELECT * FROM sanpham WHERE TenSanPham LIKE ?";
        try(
                 Connection con=DatabaseTool.connect();
                 PreparedStatement pstmt=con.prepareStatement(sql);
                 ) 
        {
            pstmt.setString(1,"%"+tensp+"%");
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setGiaBan(rs.getInt("GiaBan"));
                sp.setGiaNhap(rs.getInt("GiaNhap"));
                sp.setLuongTonKho(rs.getInt("LuongTonKho"));
                sp.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                sp.setLoai(rs.getString("Loai"));
                sp.setThoiGianNhap(rs.getDate("ThoiGianNhap"));
                list.add(sp);
            }
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;       
    }
    
    
    //Theo Loại
    public ArrayList<SanPham> getlistLoaiSanPham(String loai) throws SQLException{
        ArrayList<SanPham> list = new ArrayList<>();
        String sql="SELECT * FROM sanpham WHERE Loai LIKE ?";
        try(
                 Connection con=DatabaseTool.connect();
                 PreparedStatement pstmt=con.prepareStatement(sql);
                 ) 
        {
            pstmt.setString(1,"%"+loai+"%");
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setGiaBan(rs.getInt("GiaBan"));
                sp.setGiaNhap(rs.getInt("GiaNhap"));
                sp.setLuongTonKho(rs.getInt("LuongTonKho"));
                sp.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                sp.setLoai(rs.getString("Loai"));
                sp.setThoiGianNhap(rs.getDate("ThoiGianNhap"));
                list.add(sp);
            }
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;       
    }
    
    
    //Theo ID
    public ArrayList<SanPham> getlistIDSanPham(int id) throws SQLException{
        ArrayList<SanPham> list = new ArrayList<>();
        String sql="SELECT * FROM sanpham WHERE MaSanPham=?";
        try(
                 Connection con=DatabaseTool.connect();
                 PreparedStatement pstmt=con.prepareStatement(sql);
                 ) 
        {
            pstmt.setInt(1,id);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setGiaBan(rs.getInt("GiaBan"));
                sp.setGiaNhap(rs.getInt("GiaNhap"));
                sp.setLuongTonKho(rs.getInt("LuongTonKho"));
                sp.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                sp.setLoai(rs.getString("Loai"));
                sp.setThoiGianNhap(rs.getDate("ThoiGianNhap"));
                list.add(sp);
            }
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;       
    }
    
    
    //Theo Nhà cung cấp
    public ArrayList<SanPham> getlistNCCSanPham(int mancc) throws SQLException{
        ArrayList<SanPham> list = new ArrayList<>();
        String sql="SELECT * FROM sanpham WHERE MaNhaCungCap=?";
        try(
                 Connection con=DatabaseTool.connect();
                 PreparedStatement pstmt=con.prepareStatement(sql);
                 ) 
        {
            pstmt.setInt(1,mancc);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setGiaBan(rs.getInt("GiaBan"));
                sp.setGiaNhap(rs.getInt("GiaNhap"));
                sp.setLuongTonKho(rs.getInt("LuongTonKho"));
                sp.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                sp.setLoai(rs.getString("Loai"));
                sp.setThoiGianNhap(rs.getDate("ThoiGianNhap"));
                list.add(sp);
            }
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;       
    }
    
    
    //Theo Ngày nhập hàng
    public ArrayList<SanPham> getlistNgayNhapSanPham(Date start,Date End) throws SQLException{
        ArrayList<SanPham> list = new ArrayList<>();
        String sql="SELECT * FROM sanpham WHERE ThoiGianNhap BETWEEN ? AND ?";
        try(
                 Connection con=DatabaseTool.connect();
                 PreparedStatement pstmt=con.prepareStatement(sql);
                 ) 
        {
            pstmt.setDate(1,start);
            pstmt.setDate(2,End);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setGiaBan(rs.getInt("GiaBan"));
                sp.setGiaNhap(rs.getInt("GiaNhap"));
                sp.setLuongTonKho(rs.getInt("LuongTonKho"));
                sp.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                sp.setLoai(rs.getString("Loai"));
                sp.setThoiGianNhap(rs.getDate("ThoiGianNhap"));
                list.add(sp);
            }
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;       
    }
}
