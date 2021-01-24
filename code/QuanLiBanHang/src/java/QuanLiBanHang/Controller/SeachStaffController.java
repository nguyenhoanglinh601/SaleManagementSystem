/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "SeachStaffController", urlPatterns = {"/SeachStaffController"})
public class SeachStaffController extends HttpServlet {

  
   
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        try{
            
            String search = request.getParameter("searchname");
                StaffDao dao=new StaffDao();
                ArrayList<Staff> list =  dao.findByName(search);
                if(search==null){
                    session.setAttribute("outlist",null);
                    response.sendRedirect("NguoiDung.jsp");
                }
                else{
                    session.setAttribute("outlist", list);
                    response.sendRedirect("NguoiDung.jsp");
                }
                    
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }

   

   

}
