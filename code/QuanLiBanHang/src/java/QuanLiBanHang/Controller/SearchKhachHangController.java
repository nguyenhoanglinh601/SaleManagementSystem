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
import java.util.ArrayList;
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
@WebServlet(name = "SearchKhachHangController", urlPatterns = {"/searchKhachHangController"})
public class SearchKhachHangController extends HttpServlet {
    public SearchKhachHangController() {
        super();     
    }

        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             HttpSession session = request.getSession();
           try {
                String search = request.getParameter("searchname");
                KhachHangDAO dao=new KhachHangDAO();
                ArrayList<KhachHang> list = dao.findKhachHang(search);
                if(search.equals("") || search==null){
                    session.setAttribute("listloc",null);
                    response.sendRedirect("QuanLiKhachHang.jsp");
                }
                else{
                    session.setAttribute("listloc", list);
                    response.sendRedirect("QuanLiKhachHang.jsp");
                }
            } catch (SQLException ex) {
                
            }
        }
}
