/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import QuanLiBanHang.DAO.KhachHangDAO;
import QuanLiBanHang.model.KhachHang;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tran Quoc Huy
 */
@WebServlet(name = "AddKhachHangController", urlPatterns = {"/AddKhachHangController"})
public class AddKhachHangController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        
            HttpSession session=request.getSession();
            KhachHangDAO dao=new KhachHangDAO();
            String maKh= "0";
            String tenKh=request.getParameter("TenKhachHang");
            String SDT=request.getParameter("SDT");
            String diaChi=request.getParameter("DiaChi");
            String Email=request.getParameter("Email");
            int Diem = 0;
            KhachHang Kh = new KhachHang(
                    Integer.parseInt(maKh),
                    tenKh,
                    SDT,
                    diaChi,
                    Email,
                    Diem);
        try {
            if(dao.insertKH(Kh))
            {
                response.setContentType("text/html;charset=UTF-8");
                request.setCharacterEncoding("utf-8");
                session.setAttribute("AddKhachHang",true);
                response.sendRedirect("QuanLiKhachHang.jsp"); 
            }
            else {
                response.sendRedirect("QuanLiKhachHang.jsp");         
            }
        } catch (Exception ex) {
            Logger.getLogger(AddKhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
