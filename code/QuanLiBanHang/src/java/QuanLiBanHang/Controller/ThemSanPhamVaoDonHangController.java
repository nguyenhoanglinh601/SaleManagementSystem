/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import QuanLiBanHang.DAO.SanPhamDAO;
import QuanLiBanHang.model.DonHang;
import QuanLiBanHang.model.MatHang;
import QuanLiBanHang.model.SanPham;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "ThemSanPhamVaoDonHangController", urlPatterns = {"/ThemSanPhamVaoDonHangController"})
public class ThemSanPhamVaoDonHangController extends HttpServlet {
    

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        HttpSession session=request.getSession();
        String MaSanPhamStr=request.getParameter("IDProduct");
        int SoLuong=Integer.parseInt(request.getParameter("NumberProduct"));
        
        if(MaSanPhamStr!="" && SoLuong>0){
            try {
                int MaSanPhamInt=Integer.parseInt(MaSanPhamStr);
                SanPhamDAO dao=new SanPhamDAO();
                SanPham sanpham=dao.TimTheoMaSanPham(MaSanPhamInt);
                if(sanpham!=null && sanpham.getLuongTonKho()>=SoLuong){
                    if(session.getAttribute("order")==null){
                        DonHang donhang=new DonHang();
                        List<MatHang> DanhSachMatHang=new ArrayList<MatHang>();
                        MatHang mathang=new MatHang();
                        mathang.setSoLuong(SoLuong);
                        mathang.setGiaBan(sanpham.getGiaBan());
                        mathang.setMaMatHang(sanpham.getMaSanPham());
                        mathang.setSanPham(sanpham);
                        DanhSachMatHang.add(mathang);
                        donhang.setDanhSachMatHang(DanhSachMatHang);
                        session.setAttribute("order", donhang);
                    }
                    else{
                        DonHang donhang=(DonHang) session.getAttribute("order");
                        List<MatHang> DanhSachMatHang=donhang.getDanhSachMatHang();
                        boolean kiemtra=false;
                        for(MatHang mathang: DanhSachMatHang){
                            if(mathang.getSanPham().getMaSanPham()==MaSanPhamInt){
                                mathang.setSoLuong(mathang.getSoLuong()+SoLuong);
                                kiemtra=true;
                            }
                        }
                        if(kiemtra==false){
                            MatHang mathang=new MatHang();
                            mathang.setSoLuong(SoLuong);
                            mathang.setGiaBan(sanpham.getGiaBan());
                            mathang.setMaMatHang(sanpham.getMaSanPham());
                            mathang.setSanPham(sanpham);
                            DanhSachMatHang.add(mathang);
                        }
                        session.setAttribute("order", donhang);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ThemSanPhamVaoDonHangController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        RequestDispatcher rd=request.getRequestDispatcher("BanHang.jsp");
        rd.forward(request, response);
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
