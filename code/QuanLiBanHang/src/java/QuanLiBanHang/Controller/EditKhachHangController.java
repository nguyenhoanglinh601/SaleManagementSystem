/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import QuanLiBanHang.DAO.KhachHangDAO;
import QuanLiBanHang.model.KhachHang;
import java.io.IOException;
import java.sql.SQLException;
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
 * @author Tran Quoc Huy
 */@WebServlet(name = "EditKhachHangController", urlPatterns = {"/EditKhachHangController"})
public class EditKhachHangController extends HttpServlet {

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
        
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("utf-8");
            HttpSession session=request.getSession();
            String maKh=request.getParameter("update");
            String tenKh=request.getParameter("TenKhachHang");
            String SDT=request.getParameter("SDT");
            String diaChi=request.getParameter("DiaChi");
            String Email=request.getParameter("Email");
            String Diem=request.getParameter("Diem");
            KhachHangDAO dao=new KhachHangDAO();
            KhachHang Kh = new KhachHang();
                Kh.setMaKhachHang(Integer.parseInt(maKh));
                Kh.setTenKhachHang(tenKh);
                Kh.setSDT(SDT);
                Kh.setDiaChi(diaChi);
                Kh.setEmail(Email);
                Kh.setDiem(Integer.parseInt(Diem));
            if(dao.CapNhatThongTinKhachHang(Kh))
            {
                session.setAttribute("update",true);
                RequestDispatcher rd=request.getRequestDispatcher("QuanLiKhachHang.jsp");
                rd.forward(request, response);
                
            }
            else {
                response.sendRedirect("QuanLiKhachHang.jsp");    
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditKhachHangController.class.getName()).log(Level.SEVERE, null, ex);
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
