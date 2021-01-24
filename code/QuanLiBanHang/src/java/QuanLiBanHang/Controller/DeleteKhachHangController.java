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
@WebServlet(name = "DeleteKhachHangController", urlPatterns = {"/DeleteKhachHangController"})
public class DeleteKhachHangController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session=request.getSession();
        KhachHangDAO dao=new KhachHangDAO();
         String maKh=request.getParameter("delete");
        try {
            if(dao.deleteKH(Integer.parseInt(maKh)))
            {
                session.removeAttribute(maKh);
                response.sendRedirect("QuanLiKhachHang.jsp");
            }
            else {
                response.sendRedirect("index.jsp");     
            }
        } catch (Exception ex) {
            Logger.getLogger(DeleteKhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}  

