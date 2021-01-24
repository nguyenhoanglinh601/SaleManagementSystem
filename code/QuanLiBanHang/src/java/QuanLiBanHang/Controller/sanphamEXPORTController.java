/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import QuanLiBanHang.DAO.SanPhamDAO;
import QuanLiBanHang.model.SanPham;
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
@WebServlet(name = "sanphamEXPORTController", urlPatterns = {"/sanphamEXPORTController"})
public class sanphamEXPORTController extends HttpServlet {

    
  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        try {
            ThuExcelWriter rwex=new ThuExcelWriter();
            String filepath=request.getParameter("filepath");
            String action=request.getParameter("hanhdong");
            SanPhamDAO dao=new SanPhamDAO();
            ArrayList<SanPham> listall = dao.getAllSanPham();
            LocalDate thoigian=java.time.LocalDate.now();
            String thoigianban=thoigian.getYear()+"-"+thoigian.getMonthValue()+"-"+thoigian.getDayOfMonth();
            if(action.equals("Export"))
            {
                rwex.ghifileexle(filepath+".xls");
            }
       
            else
            {
                ArrayList<SanPham> list=rwex.docfileexle(filepath+".xls");
                for(SanPham sp : list){
                    for(SanPham spall : listall){
                        if(sp.getMaSanPham()==spall.getMaSanPham())
                        {
                            int temp1 = spall.getLuongTonKho();
                            int temp2 = sp.getLuongTonKho();
                            spall.setLuongTonKho(temp1+temp2);
                            spall.setThoiGianNhap(Date.valueOf(thoigianban));
                            dao.updateSanPham(spall);
                        }
                    }
                }
                
            }
            RequestDispatcher rd=request.getRequestDispatcher("SanphamManagement.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(sanphamEXPORTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


  

}
