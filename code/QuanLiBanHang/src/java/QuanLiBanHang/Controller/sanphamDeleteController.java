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
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HocIT
 */
@WebServlet(name = "sanphamDeleteController", urlPatterns = {"/sanphamDeleteController"})
public class sanphamDeleteController extends HttpServlet {

 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        SanPhamDAO dao=new SanPhamDAO();
         String masp=request.getParameter("ProductId");
               if(dao.deleteSanPham(Integer.parseInt(masp)))
               {
                   response.sendRedirect("SanphamManagement.jsp");             
               }
               else {
                   response.sendRedirect("Loi.jsp");                  
               }         
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
