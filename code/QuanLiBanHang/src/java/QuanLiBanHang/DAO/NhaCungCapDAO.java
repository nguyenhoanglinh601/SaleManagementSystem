/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.DAO;

import QuanLiBanHang.model.NhaCungCap;
import QuanLiBanHang.Helper.DatabaseTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhaCungCapDAO {

    public List<NhaCungCap> getAllNhaCungCap() throws SQLException{
        List<NhaCungCap> list = new ArrayList<>();
        String sql="SELECT * FROM nhacungcap";
        try(Connection con=DatabaseTool.connect();
             PreparedStatement pstmt=con.prepareStatement(sql);
             ResultSet rs=pstmt.executeQuery();)
        {
            while(rs.next()){
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                ncc.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
                ncc.setSDT(rs.getInt("SDT"));
                ncc.setEmail(rs.getString("Email"));
                ncc.setDiaChi(rs.getString("DiaChi"));
                list.add(ncc);
            }
            return list;
        }catch(Exception ex){
                    ex.getMessage();
        }
        return null;
        
    }
    public boolean insertNhaCungCap(NhaCungCap ncc){
        String sql="INSERT INTO `nhacungcap`(`MaNhaCungCap`, `TenNhaCungCap`, `SDT`, `Email`, `DiaChi`) VALUES (null,?,?,?,?)";
         try(
                 Connection con=DatabaseTool.connect();
                 PreparedStatement pstmt=con.prepareStatement(sql);
                 ){
           pstmt.setString(1,ncc.getTenNhaCungCap());
           pstmt.setInt(2,ncc.getSDT());
           pstmt.setString(4,ncc.getDiaChi());
           pstmt.setString(3,ncc.getEmail());
           return pstmt.executeUpdate()>0;
         }catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
