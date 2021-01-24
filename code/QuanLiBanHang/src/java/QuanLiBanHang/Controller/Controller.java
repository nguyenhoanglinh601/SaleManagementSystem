/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import QuanLiBanHang.model.Staff;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

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
        HttpSession session = request.getSession();
        if(session.getAttribute("staff")==null){
            session.setAttribute("message", "Tài khoản không đúng");
            RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        }
        else{
            String action="Sell";
            if(request.getParameter("action")!=null && request.getParameter("action")!=""){
                action=request.getParameter("action");
            }
            Staff staff=new Staff();
            staff=(Staff) session.getAttribute("staff");
            Boolean isAdmin=staff.isAccess();
            switch(action){
                case "Sell":
                    session.setAttribute("message", "");
                    RequestDispatcher rdSell=request.getRequestDispatcher("BanHang.jsp");
                    rdSell.forward(request, response);
                    break;
                case "CustomerManagement":
                    session.setAttribute("message", "");
                    RequestDispatcher rdCustomer=request.getRequestDispatcher("QuanLiKhachHang.jsp");
                    rdCustomer.forward(request, response);
                    break;
                case "ProductManagement":
                    session.setAttribute("message", "");
                    RequestDispatcher rdProduct=request.getRequestDispatcher("SanphamManagement.jsp");
                    rdProduct.forward(request, response);
                    break;
                case "OrderManagement":
                    if(isAdmin==true){
                        session.setAttribute("message", "");
                        RequestDispatcher rdOrder=request.getRequestDispatcher("HoaDon.jsp");
                        rdOrder.forward(request, response);
                    }
                    else{
                        session.setAttribute("message", "Chức năng yêu cầu tài khoản Admin");
                        RequestDispatcher rdOrder=request.getRequestDispatcher("BanHang.jsp");
                        rdOrder.forward(request, response);
                    }
                    break;
                case "UserManagement":
                    if(isAdmin==true){
                        session.setAttribute("message", "");
                        RequestDispatcher rdUser=request.getRequestDispatcher("NguoiDung.jsp");
                        rdUser.forward(request, response);
                    }
                    else{
                        session.setAttribute("message", "Chức năng yêu cầu tài khoản Admin");
                        RequestDispatcher rdUser=request.getRequestDispatcher("BanHang.jsp");
                        rdUser.forward(request, response);
                    }
                    break;
                case "Exit":
                    session.invalidate();
                    RequestDispatcher rdExit=request.getRequestDispatcher("Login.jsp");
                    rdExit.forward(request, response);
                    break;
            }
        }
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
        HttpSession session = request.getSession();
        if(session.getAttribute("staff")==null){
            session.setAttribute("message", "Tài khoản không đúng");
            RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        }
        else{
            String action="Sell";
            if(request.getParameter("action")!=null && request.getParameter("action")!=""){
                action=request.getParameter("action");
            }
            Staff staff=new Staff();
            staff=(Staff) session.getAttribute("staff");
            Boolean isAdmin=staff.isAccess();
            switch(action){
                case "Sell":
                    session.setAttribute("message", "");
                    RequestDispatcher rdSell=request.getRequestDispatcher("BanHang.jsp");
                    rdSell.forward(request, response);
                    break;
                case "CustomerManagement":
                    session.setAttribute("message", "");
                    RequestDispatcher rdCustomer=request.getRequestDispatcher("QuanLiKhachHang.jsp");
                    rdCustomer.forward(request, response);
                    break;
                case "ProductManagement":
                    session.setAttribute("message", "");
                    RequestDispatcher rdProduct=request.getRequestDispatcher("SanPhamManagement.jsp");
                    rdProduct.forward(request, response);
                    break;
                case "OrderManagement":
                    if(isAdmin==true){
                        session.setAttribute("message", "");
                        RequestDispatcher rdOrder=request.getRequestDispatcher("HoaDon.jsp");
                        rdOrder.forward(request, response);
                    }
                    else{
                        session.setAttribute("message", "Chức năng yêu cầu tài khoản Admin");
                        RequestDispatcher rdOrder=request.getRequestDispatcher("BanHang.jsp");
                        rdOrder.forward(request, response);
                    }
                    break;
                case "UserManagement":
                    if(isAdmin==true){
                        session.setAttribute("message", "");
                        RequestDispatcher rdUser=request.getRequestDispatcher("nguoidung.jsp");
                        rdUser.forward(request, response);
                    }
                    else{
                        session.setAttribute("message", "Chức năng yêu cầu tài khoản Admin");
                        RequestDispatcher rdUser=request.getRequestDispatcher("BanHang.jsp");
                        rdUser.forward(request, response);
                    }
                    break;
            }
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
