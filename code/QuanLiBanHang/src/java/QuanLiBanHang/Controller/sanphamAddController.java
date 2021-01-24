/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import QuanLiBanHang.model.SanPham;
import QuanLiBanHang.DAO.SanPhamDAO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author HocIT
 */
@WebServlet(name = "sanphamAddController", urlPatterns = {"/sanphamAddController"})
public class sanphamAddController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        SanPhamDAO dao=new SanPhamDAO();
         String tensp=request.getParameter("txtNameProduct");
         String loai=request.getParameter("txtTypeProduct");
         String giaban=request.getParameter("txtPriceProduct");
         String gianhap=request.getParameter("txtIDProduct");
         String macc=request.getParameter("txtIDProducer");
         String luong=request.getParameter("txtAmountProduct");
         LocalDate thoigian=java.time.LocalDate.now();
         String thoigianban=thoigian.getYear()+"-"+thoigian.getMonthValue()+"-"+thoigian.getDayOfMonth();
        // HttpSession session=request.getSession();
        //session.setAttribute("test", Date.valueOf(thoigianban));
        //RequestDispatcher rd=request.getRequestDispatcher("Loi.jsp");
        //rd.forward(request, response);
         SanPham sanpham = new SanPham(
                 0,
                 Integer.parseInt(luong),
                 Integer.parseInt(giaban),
                 Integer.parseInt(gianhap),
                 Integer.parseInt(macc),
                 tensp,
                 loai,
                 Date.valueOf(thoigianban));
               if(dao.insertSanPham(sanpham))
               {
                   response.sendRedirect("SanphamManagement.jsp");             
               }
               else {
                   response.sendRedirect("index.jsp");                  
               }         
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
