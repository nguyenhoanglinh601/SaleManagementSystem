/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import QuanLiBanHang.model.Staff;
import QuanLiBanHang.Helper.DatabaseHelper;
import static QuanLiBanHang.Helper.EncodeMd5.encodeMD5Password;
/**
 *
 * @author doanv
 */
public class StaffDao {
    public boolean insertStaff(Staff staff) throws Exception {
        String sql = "insert into nhanvien(tennhanvien,sdt,diachi,taikhoan,matkhau,quyen)" + "value(?,?,?,?,?,?)";
        
        try (
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
                ) {
        pstmt.setString(1, staff.getName());
        pstmt.setString(2, staff.getNumberPhone());
        pstmt.setString(3, staff.getAddress());
        pstmt.setString(4, staff.getUsername());
        pstmt.setString(5, encodeMD5Password(staff.getPassword()));
        pstmt.setBoolean(6, staff.isAccess());
        
        return pstmt.executeUpdate()>0;
    }
        
    }
    
    public boolean updateStaff(Staff staff) throws Exception {
        String sql = " UPDATE `nhanvien` SET `MaNhanVien`=?,`TenNhanVien`=?,`SDT`=?,`DiaChi`=?,`TaiKhoan`=?,`MatKhau`=?,`Quyen`=? WHERE `MaNhanVien`=? ";
        
        try (
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ) {
        pstmt.setInt(1, staff.getIdStaff());
        pstmt.setString(2, staff.getName());
        pstmt.setString(3, staff.getNumberPhone());
        pstmt.setString(4, staff.getAddress());
        pstmt.setString(5, staff.getUsername());
        pstmt.setString(6, staff.getPassword());
        pstmt.setBoolean(7, staff.isAccess());
        pstmt.setInt(8, staff.getIdStaff());
        
        return pstmt.executeUpdate()>0;
    }
    }
    
    public Staff findById(int idStaff) throws Exception {
        
        
        String sql = "select * from nhanvien where manhanvien=? ";
        
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                
            ) {
            pstmt.setInt(1,idStaff );
            
            // gọi phương thức result set
            try (ResultSet rs = pstmt.executeQuery())
             
            {
                // lấy dữ liệu result set gọi vào staff
            if (rs.next()) {
                Staff staff = new Staff();
                staff.setIdStaff(rs.getInt("manhanvien"));
                staff.setName(rs.getString("tennhanvien"));
                staff.setNumberPhone(rs.getString("sdt"));
                staff.setAddress(rs.getString("diachi"));
                staff.setUsername(rs.getString("taikhoan"));
                staff.setPassword(rs.getString("matkhau"));
                staff.setAccess(rs.getBoolean("quyen"));
                
                return  staff;
            }
            
        }
            return null;
        }
        
    }
    
    public Staff findByUsername(String username) throws Exception {
        
        
        String sql = "select * from nhanvien where taikhoan=? ";
        
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                
            ) {
            pstmt.setString(1,username );
            
            // gọi phương thức result set
            try (ResultSet rs = pstmt.executeQuery())
             
            {
                // lấy dữ liệu result set gọi vào staff
            if (rs.next()) {
                Staff staff = new Staff();
                staff.setIdStaff(rs.getInt("manhanvien"));
                staff.setName(rs.getString("tennhanvien"));
                staff.setNumberPhone(rs.getString("sdt"));
                staff.setAddress(rs.getString("diachi"));
                staff.setUsername(rs.getString("taikhoan"));
                staff.setPassword(rs.getString("matkhau"));
                staff.setAccess(rs.getBoolean("quyen"));
                
                return  staff;
            }
            
        }
            return null;
        }
        
    }
    
   public ArrayList<Staff> findByName(String name) throws Exception {
        ArrayList<Staff> list = new ArrayList<>();
        
        String sql = "select * from nhanvien where tennhanvien like ? ";
        
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
   
                
                ) {
            pstmt.setString(1,"%"+ name + "%" );
             ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setIdStaff(rs.getInt("manhanvien"));
                staff.setName(rs.getString("tennhanvien"));
                staff.setNumberPhone(rs.getString("sdt"));
                staff.setAddress(rs.getString("diachi"));
                staff.setUsername(rs.getString("taikhoan"));
                staff.setPassword(rs.getString("matkhau"));
                staff.setAccess(rs.getBoolean("quyen"));
                
                list.add(staff);
            }
            
        }
        catch (Exception ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return list;
    }
    
    public Staff checkLogin(String username , String password) throws Exception {
        Staff staff = findByUsername(username);
        
        if(staff != null && staff.getPassword().equals(password)) {
            return staff; // thành công
        }
        
        return null; // thất bại
    }
    
    
    
    
    public List<Staff> findAll() throws Exception {
        List<Staff> list = new ArrayList<>();
        
        String sql = "select * from nhanvien ";
        
        try (
                Connection con =DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                ) {
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setIdStaff(rs.getInt("MaNhanVien"));
                staff.setName(rs.getString("TenNhanVien"));
                staff.setNumberPhone(rs.getString("SDT"));
                staff.setAddress(rs.getString("DiaChi"));
                staff.setUsername(rs.getString("TaiKhoan"));
                staff.setPassword(rs.getString("MatKhau"));
                staff.setAccess(rs.getBoolean("Quyen"));
                
                list.add(staff);
            }
            return list;
        }
    }
    
    public boolean deleteStaff(int idStaff) throws Exception {
        String sql = "delete from nhanvien " +
                "where MaNhanVien=? ";
        
        try (
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
                ) {
        pstmt.setInt(1, idStaff);
        
        return pstmt.executeUpdate()>0;
    } catch (Exception e) {
          Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, e); 
    }
        return false;
        
    }
    
    
}
 