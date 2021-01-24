package QuanLiBanHang.DAO;

import QuanLiBanHang.Helper.DatabaseHelper;
import QuanLiBanHang.model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
    public boolean checkLogin(String id, String pass) throws SQLException{
            NhanVien employee=getEmployeeByID(Integer.parseInt(id));
            if(employee!=null && employee.getMatKhau().equals(pass)){
                return true;
            }
            return false;
    }
    
    public NhanVien getEmployeeByID(int id) throws SQLException{
        String sql="select * from nhanvien where MaNhanVien='?'";
        NhanVien employee=new NhanVien();
        employee=null;
        try(
                Connection con=DatabaseHelper.openConnection();
                PreparedStatement pstmt=con.prepareStatement(sql);
                ){
            pstmt.setInt(1, id);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                employee.setMaNhanVien(rs.getInt("MaNhanVien"));
                employee.setTenNhanVien(rs.getString("TenNhanVien"));
                employee.setSDT(rs.getInt("SDT"));
                employee.setDiaChi(rs.getString("DiaChi"));
                employee.setTaiKhoan(rs.getString("TaiKhoan"));
                employee.setMatKhau(rs.getString("MatKhau"));
                employee.setQuyen(rs.getBoolean("Quyen"));
            }
        }
        return employee;
    }
}
