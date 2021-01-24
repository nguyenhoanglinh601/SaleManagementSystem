/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import QuanLiBanHang.DAO.ChiTietHoaDonDAO;
import QuanLiBanHang.DAO.HoaDonDAO;
import QuanLiBanHang.DAO.KhachHangDAO;
import QuanLiBanHang.model.ChiTietHoaDon;
import QuanLiBanHang.model.DonHang;
import QuanLiBanHang.model.HoaDon;
import QuanLiBanHang.model.KhachHang;
import QuanLiBanHang.model.MatHang;
import QuanLiBanHang.model.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name = "ThemHoaDonController", urlPatterns = {"/ThemHoaDonController"})
public class ThemHoaDonController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        String sdt=request.getParameter("numberPhoneCustomer");
        try {
            DonHang donhang =(DonHang) session.getAttribute("order");
            List<MatHang> DanhSachMatHang=donhang.getDanhSachMatHang();
            int makhachhang = 0;
            if(donhang!=null){     
                try {
                    if(sdt!=null){
                        try {
                            KhachHangDAO dao=new KhachHangDAO();
                            KhachHang khachhang=dao.TimTheoSDT(sdt);
                            if(khachhang!=null){
                                float TongTien=0;
                                for(MatHang mathang: DanhSachMatHang){
                                    TongTien=TongTien+mathang.getSoLuong()*mathang.getGiaBan();
                                }
                                int diem=(int) (TongTien/100000);
                                khachhang.setDiem(diem);

                                dao.CapNhatThongTinKhachHang(khachhang);

                                makhachhang=khachhang.getMaKhachHang();
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ThemHoaDonController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    int thuevat=0,giamgia=0;
                    Staff staff=(Staff) session.getAttribute("staff");
                    int manhanvien=staff.getIdStaff();
                    float tongcong=0;
                    LocalDate thoigian=java.time.LocalDate.now();
                    String thoigianban= thoigian.getYear()+"-"+thoigian.getMonthValue()+"-"+thoigian.getDayOfMonth();
                    for(MatHang mathang: DanhSachMatHang){
                        thuevat=(int) (mathang.getSoLuong()*mathang.getGiaBan()*0.02+thuevat);
                        tongcong=mathang.getSoLuong()*mathang.getGiaBan()+tongcong;
                    }
                    if(tongcong>100000){
                        giamgia=(int) (tongcong*0.1);
                    }
                    HoaDon hoadon=new HoaDon(0, makhachhang, manhanvien, thuevat, giamgia, thoigianban);
                    HoaDonDAO dao1=new HoaDonDAO();
                    dao1.ThemHoaDon(hoadon);

                    HoaDonDAO dao2=new HoaDonDAO();
                    HoaDon hoadonmoinhat=new HoaDon();
                    hoadonmoinhat=dao2.LayHoaDonMoiNhat();
                    int mahoadonmoinhat=hoadonmoinhat.getMaHoaDon();

                    for(MatHang mathang: DanhSachMatHang){
                        ChiTietHoaDon chitiethoadon=new ChiTietHoaDon(mahoadonmoinhat, mathang.getMaMatHang(), mathang.getGiaBan(), mathang.getSoLuong());
                        ChiTietHoaDonDAO dao3=new ChiTietHoaDonDAO();

                        dao3.ThemChiTietHoaDon(chitiethoadon);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ThemHoaDonController.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
            session.removeAttribute("order");
            RequestDispatcher rd=request.getRequestDispatcher("BanHang.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            session.removeAttribute("order");
            RequestDispatcher rd=request.getRequestDispatcher("BanHang.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
