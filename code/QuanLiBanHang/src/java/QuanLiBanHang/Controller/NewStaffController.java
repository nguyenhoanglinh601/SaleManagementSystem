/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;


import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import QuanLiBanHang.model.Staff;
import QuanLiBanHang.DAO.StaffDao;

/**
 *
 * @author doanv
 */
@WebServlet(name = "NewStaffController", urlPatterns = {"/NewStaffController"})
public class NewStaffController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        StaffDao dao = new StaffDao();
            String name = request.getParameter("tennhanvien");
            String phoneNumber = request.getParameter("sdt");
            String address = request.getParameter("diachi");
            String username = request.getParameter("taikhoan");
            String password = request.getParameter("matkhau");
            String access = request.getParameter("quyen");
            
            Staff staff = new Staff(0,name,phoneNumber,address,username,password,Boolean.parseBoolean(access));
            try {
                    
                    if(dao.insertStaff(staff)) {
                        response.setContentType("text/html;charset=UTF-8");
                request.setCharacterEncoding("utf-8");
                session.setAttribute("AddNhanVien",true);
                session.setAttribute("outlist", dao.findAll());
                response.sendRedirect("NguoiDung.jsp"); 
                    } else {
                        response.sendRedirect("NguoiDung.jsp");
                    }
            } catch(Exception e) {
               Logger.getLogger(NewStaffController.class.getName()).log(Level.SEVERE, null, e);
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
