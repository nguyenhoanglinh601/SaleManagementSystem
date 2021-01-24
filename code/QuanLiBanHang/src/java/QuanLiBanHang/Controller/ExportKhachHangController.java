/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import QuanLiBanHang.DAO.KhachHangDAO;
import QuanLiBanHang.Helper.ReadWriteKhachHangExcel;
import QuanLiBanHang.model.KhachHang;
import QuanLiBanHang.Helper.ThuExcelWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HocIT
 */
@WebServlet(name = "ExportKhachHangController", urlPatterns = {"/ExportKhachHangController"})
public class ExportKhachHangController extends HttpServlet {

    
  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        try {
            ReadWriteKhachHangExcel rwex=new ReadWriteKhachHangExcel();
            String filepath=request.getParameter("filepath");
            String action=request.getParameter("hanhdong");
            KhachHangDAO dao=new KhachHangDAO();
            ArrayList<KhachHang> listall = dao.findAll();
            LocalDate thoigian=java.time.LocalDate.now();
            String thoigianban=thoigian.getYear()+"-"+thoigian.getMonthValue()+"-"+thoigian.getDayOfMonth();
            if(action.equals("Export"))
            {
                rwex.writeFileExcel(filepath+".xls");
            }
       
            RequestDispatcher rd=request.getRequestDispatcher("QuanLiKhachHang.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ExportKhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ExportKhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


  

}
