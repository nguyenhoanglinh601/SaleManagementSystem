/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import QuanLiBanHang.DAO.NhaCungCapDAO;
import QuanLiBanHang.model.NhaCungCap;
import QuanLiBanHang.model.SanPham;
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
 * @author HocIT
 */
@WebServlet(name = "nhacungcapAddController", urlPatterns = {"/nhacungcapAddController"})
public class nhacungcapAddController extends HttpServlet {

  
  
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("utf-8");
            HttpSession session=request.getSession();
            NhaCungCapDAO dao=new NhaCungCapDAO();
            String tenncc=request.getParameter("NameProducer");
            String sdt=request.getParameter("SDTProducer");
            String diachi=request.getParameter("DiaChiProducer");
            String email=request.getParameter("EmailProducer");
            
            List<NhaCungCap> list;
        try {
            list = dao.getAllNhaCungCap();
            for(NhaCungCap test : list){
                if(test.getTenNhaCungCap().equals(tenncc)){
                    session.setAttribute("ncc", false);
                    RequestDispatcher rd=request.getRequestDispatcher("SanphamManagement.jsp");
                   rd.forward(request, response);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(nhacungcapAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            NhaCungCap ncc=new NhaCungCap();
            ncc.setTenNhaCungCap(tenncc);
            ncc.setSDT(Integer.parseInt(sdt));
            ncc.setEmail(email);
            ncc.setDiaChi(diachi);
            if(dao.insertNhaCungCap(ncc))
            {
                session.setAttribute("ncc",true);
                RequestDispatcher rd=request.getRequestDispatcher("SanphamManagement.jsp");
                   rd.forward(request, response);
            }
            else {
                session.setAttribute("ncc",false);
                RequestDispatcher rd=request.getRequestDispatcher("Loi.jsp");
                   rd.forward(request, response);
            }
        }
}
    
