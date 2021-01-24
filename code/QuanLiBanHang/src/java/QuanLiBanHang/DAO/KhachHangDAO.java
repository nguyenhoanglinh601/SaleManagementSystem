
package QuanLiBanHang.DAO;

import QuanLiBanHang.Helper.DatabaseHelper;
import QuanLiBanHang.model.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHangDAO {
    public KhachHang TimTheoSDT(String sdt) throws SQLException{
        String sql="select * from khachhang where sdt=?";
    
        try(
            Connection con=DatabaseHelper.openConnection();
            PreparedStatement pstmt=con.prepareStatement(sql);
        ){
            pstmt.setString(1, sdt);
            try(ResultSet rs=pstmt.executeQuery();){
                if(rs.next()){
                    KhachHang khachhang=new KhachHang();
                    khachhang.setMaKhachHang(rs.getInt("MaKhachHang"));
                    khachhang.setTenKhachHang(rs.getString("TenKhachHang"));
                    khachhang.setSDT(rs.getString("SDT"));
                    khachhang.setDiaChi(rs.getString("DiaChi"));
                    khachhang.setEmail(rs.getString("Email"));
                    khachhang.setDiem(rs.getInt("Diem"));
                    return khachhang;
                }
            }
        }
        return null;
    }
    
    public boolean CapNhatThongTinKhachHang(KhachHang KH) throws SQLException{
        String sql="update khachhang set TenKhachHang=?, SDT=?, DiaChi=?, Email=?, Diem=? where MaKhachHang=?";
        try(
                Connection con=DatabaseHelper.openConnection();
                PreparedStatement pstmt=con.prepareStatement(sql);
                ){
            pstmt.setString(1, KH.getTenKhachHang());
            pstmt.setLong(2, Long.parseLong(KH.getSDT()));
            pstmt.setString(3, KH.getDiaChi());
            pstmt.setString(4, KH.getEmail());
            pstmt.setInt(5, KH.getDiem());
            pstmt.setInt(6, KH.getMaKhachHang());
            return pstmt.executeUpdate()>0;
        }
    }
    
    public boolean insertKH(KhachHang KH) throws Exception {
         String sql="INSERT INTO `khachhang`(`MaKhachHang`, `TenKhachHang`, `SDT`, `DiaChi`, `Email`, `Diem`) VALUES (null,?,?,?,?,?)";
         try(
                 Connection con=DatabaseHelper.openConnection();
                 PreparedStatement pstmt=con.prepareStatement(sql);
                 ){
           pstmt.setString(1,KH.getTenKhachHang());
           pstmt.setString(2,KH.getSDT());
           pstmt.setString(3,KH.getDiaChi());
           pstmt.setString(4,KH.getEmail());
           pstmt.setInt(5,KH.getDiem());
           return pstmt.executeUpdate()>0;
         }catch (Exception ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public KhachHang findByMaKH(int maKh) throws Exception {
        
        
        String sql = "select * from khachhang where MaKhachHang=?";
        
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                
            ) {
            pstmt.setInt(1, maKh);
            try (ResultSet rs = pstmt.executeQuery())
             
            {
            if (rs.next()) {
                KhachHang Kh = new KhachHang();
                Kh.setMaKhachHang(rs.getInt("MaKhachHang"));
                Kh.setTenKhachHang(rs.getString("MaKhachHang"));
                Kh.setSDT(rs.getString("SDT"));
                Kh.setEmail(rs.getString("Email"));
                Kh.setDiem(rs.getInt("Diem"));
                
                return  Kh;
            }
            
        }
            return null;
        }
    }
    public ArrayList<KhachHang> findAll() throws Exception {
        ArrayList<KhachHang> list = new ArrayList<>();
        
        String sql = "SELECT * FROM khachhang";
        
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                ) {
            while (rs.next()) {
                KhachHang Kh = new KhachHang();
                Kh.setMaKhachHang(rs.getInt("MaKhachHang"));
                Kh.setTenKhachHang(rs.getString("TenKhachHang"));
                Kh.setSDT(rs.getString("SDT"));
                Kh.setDiaChi(rs.getString("DiaChi"));
                Kh.setEmail(rs.getString("Email"));
                Kh.setDiem(rs.getInt("Diem"));  
                list.add(Kh);
            }
        }
        catch(Exception ex){
            ex.getMessage();
        }
        return list;
    }
    
        public ArrayList<KhachHang> findKhachHang(String maKh) throws SQLException {
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql="SELECT * FROM khachhang WHERE TenKhachHang LIKE ?";
        try(
                 Connection con=DatabaseHelper.openConnection();
                 PreparedStatement pstmt=con.prepareStatement(sql);
                 ) {
             pstmt.setString(1,"%"+maKh+"%");
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                KhachHang Kh = new KhachHang();
                Kh.setMaKhachHang(rs.getInt("MaKhachHang"));
                Kh.setTenKhachHang(rs.getString("TenKhachHang"));
                Kh.setSDT(rs.getString("SDT"));
                Kh.setDiaChi(rs.getString("DiaChi"));
                Kh.setEmail(rs.getString("Email"));
                Kh.setDiem(rs.getInt("Diem"));
                list.add(Kh);
            }
        } catch (Exception ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
    
        return list;
}
    
    public boolean deleteKH(int maKh)  {
        String sql = "DELETE FROM khachhang WHERE MaKhachHang = ? ";
        
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ) {
            pstmt.setInt(1, maKh);
            return pstmt.executeUpdate()>0;
        }catch (Exception ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
