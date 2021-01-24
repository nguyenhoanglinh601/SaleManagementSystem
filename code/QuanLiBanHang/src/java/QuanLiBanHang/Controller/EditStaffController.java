/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import java.io.IOException;
import java.sql.SQLException;
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
import static QuanLiBanHang.Helper.EncodeMd5.encodeMD5Password;

/**
 *
 * @author doanv
 */
@WebServlet(name = "EditStaffController", urlPatterns = {"/EditStaffController"})
public class EditStaffController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            HttpSession session=request.getSession();
            String manhanvien=request.getParameter("StaffId");
            String tennhanvien=request.getParameter("tennhanvien");
            String SDT=request.getParameter("sdt");
            String diaChi=request.getParameter("diachi");
            String taikhoan=request.getParameter("taikhoan");
            String matkhau=encodeMD5Password(request.getParameter("matkhau"));
            String quyen=request.getParameter("quyen");
            StaffDao dao=new StaffDao();
            Staff staff = new Staff();
                staff.setIdStaff(Integer.parseInt(manhanvien));
                staff.setName(tennhanvien);
                staff.setNumberPhone(SDT);
                staff.setAddress(diaChi);
                staff.setUsername(taikhoan);
                staff.setPassword(matkhau);
                staff.setAccess(Boolean.parseBoolean(quyen));
            if(dao.updateStaff(staff))
            {
                session.setAttribute("update",true);
                session.setAttribute("outlist", dao.findAll());
                RequestDispatcher rd=request.getRequestDispatcher("NguoiDung.jsp");
                rd.forward(request, response);
                
            }
            else {
                response.sendRedirect("Loi.jsp");    
            }
        
        } catch (Exception ex) {
            Logger.getLogger(EditStaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
}
