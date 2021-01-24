/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import QuanLiBanHang.DAO.SanPhamDAO;
import QuanLiBanHang.model.SanPham;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HocIT
 */
@WebServlet(name = "sanphamEditController", urlPatterns = {"/sanphamEditController"})
public class sanphamEditController extends HttpServlet {


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

        
        String masp=request.getParameter("ProductId");
        String tensp=request.getParameter("tensp");
        String gianhapsp=request.getParameter("gianhapsp");
        String giabansp=request.getParameter("giabansp");
        String luongsp=request.getParameter("luongsp");
        String ngaynhapsp=request.getParameter("ngaynhapsp");
        String loaisp=request.getParameter("loaisp");
        String maccsp=request.getParameter("maccsp");
        
        SanPhamDAO dao=new SanPhamDAO();
        
         SanPham sanpham = new SanPham(Integer.parseInt(masp),
                 Integer.parseInt(luongsp),
                 Integer.parseInt(giabansp),
                 Integer.parseInt(gianhapsp),
                 Integer.parseInt(maccsp),
                 tensp,
                 loaisp,
                 Date.valueOf(ngaynhapsp));
        if(dao.updateSanPham(sanpham))
               {
                   
                   response.sendRedirect("SanphamManagement.jsp");             
               }
               else {
                   response.sendRedirect("SanphamManagement.jsp");                  
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
