package QuanLiBanHang.Controller;

import QuanLiBanHang.DAO.SanPhamDAO;
import QuanLiBanHang.model.SanPham;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;


@WebServlet(name = "sanphamSearchController", urlPatterns = {"/sanphamSearchController"})
public class sanphamSearchController extends HttpServlet {
       

        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            response.setContentType("text/html;charset=UTF-8");
             request.setCharacterEncoding("utf-8");
            String action=request.getParameter("searchoption");
            SanPhamDAO dao=new SanPhamDAO();
            switch(action){
                
                
                //TRƯỜNG HỢP TÊN
                case "ten":
            try {
                String search = request.getParameter("searchname");
                List<SanPham> list = dao.getlistTenSanPham(search);
                if(search.equals("") || search==null){
                    session.setAttribute("listloc",null);
                    response.sendRedirect("SanphamManagement.jsp");
                }
                else{
                    session.setAttribute("listloc", list);
                    response.sendRedirect("SanphamManagement.jsp");
                }
            } catch (SQLException ex) {}
            break;
            
            
                //TRƯỜNG HỢP LOẠI
                case "loai":
                try {
                String search = request.getParameter("searchloai");
                List<SanPham> list = dao.getlistLoaiSanPham(search);
                if(search.equals("") || search==null){
                    session.setAttribute("listloc",null);
                    response.sendRedirect("SanphamManagement.jsp");
                }
                else{
                    session.setAttribute("listloc", list);
                    response.sendRedirect("SanphamManagement.jsp");
                }
            } catch (SQLException ex) {}
            break;
            
            
                //TRƯỜNG HỢP ID
                case "id":
                    try {
                String search = request.getParameter("searchID");
                List<SanPham> list = dao.getlistIDSanPham(Integer.parseInt(search));
                if(search.equals("") || search==null){
                    session.setAttribute("listloc",null);
                    response.sendRedirect("SanphamManagement.jsp");
                }
                else{
                    session.setAttribute("listloc", list);
                    response.sendRedirect("SanphamManagement.jsp");
                }
            } catch (SQLException ex) {}
            break;
            
            
                //TRƯỜNG HỢP NHÀ CUNG CẤP
                case "ncc":
                      try {
                String search = request.getParameter("searchncc");
                List<SanPham> list = dao.getlistIDSanPham(Integer.parseInt(search));
                if(search.equals("") || search==null){
                    session.setAttribute("listloc",null);
                    response.sendRedirect("SanphamManagement.jsp");
                }
                else{
                    session.setAttribute("listloc", list);
                    response.sendRedirect("SanphamManagement.jsp");
                }
            } catch (SQLException ex) {}
            break;
            
            
            //TRƯỜNG HỢP NGÀY NHẬP
                case "ngaynhap":
                      try {
                String start = request.getParameter("searchstart");
                String end = request.getParameter("searchend");
                List<SanPham> list = dao.getlistNgayNhapSanPham(Date.valueOf(start),Date.valueOf(end));
                if(start!=null&&end!=null|| !"".equals(start)&&!"".equals(end)){
                    session.setAttribute("listloc", list);
                    response.sendRedirect("SanphamManagement.jsp");
                }
                else{
                    session.setAttribute("listloc",null);
                    response.sendRedirect("SanphamManagement.jsp");
                }
            } catch (SQLException ex) {}
            break;
                default:
                    session.setAttribute("listloc",null);
                    response.sendRedirect("SanphamManagement.jsp");
            }

		
        }
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         HttpSession session = request.getSession();
        session.removeAttribute("listloc");
        response.sendRedirect("SanphamManagement.jsp");
        
        
        
        
        }







}

