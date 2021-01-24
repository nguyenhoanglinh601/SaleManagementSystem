/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import QuanLiBanHang.DAO.StaffDao;

/**
 *
 * @author doanv
 */
@WebServlet(name = "DeleteStaffController", urlPatterns = {"/DeleteStaffController"})
public class DeleteStaffController extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        
            HttpSession session=request.getSession();
            StaffDao dao = new StaffDao();
         String idstaff = request.getParameter("delete");
        
       if(dao.deleteStaff(Integer.parseInt(idstaff))) {
             
               session.removeAttribute(idstaff);
               response.sendRedirect("NguoiDung.jsp");
               session.setAttribute("outlist", dao.findAll());
          
       }
       else {
           response.sendRedirect("NguoiDung.jsp");
           
       }
       
        } catch(Exception e) {
             Logger.getLogger(DeleteStaffController.class.getName()).log(Level.SEVERE, null, e);
        } 
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
