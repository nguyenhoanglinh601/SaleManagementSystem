/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import QuanLiBanHang.model.Staff;
import QuanLiBanHang.DAO.StaffDao;
import static QuanLiBanHang.Helper.EncodeMd5.encodeMD5Password;

/**
 *
 * @author doanv
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("NguoiDung.jsp");
        rd.forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = encodeMD5Password(request.getParameter("password"));
        
        if(username != null && password != null && !username.equals("") && !password.equals("")) {
            try {
                StaffDao dao = new StaffDao();
                Staff staff = dao.checkLogin(username, password);
                
                if(staff != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("staff", staff);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("Controller");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("message", "Invalid username or password");
                    RequestDispatcher rd = request.getRequestDispatcher("Controller");
                    rd.forward(request, response);
                  }
          
                } catch (Exception e) {
                e.printStackTrace();
                     }
    }
    }
}

 

