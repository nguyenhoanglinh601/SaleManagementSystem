/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Controller;

import QuanLiBanHang.DAO.ChiTietHoaDonDAO;
import QuanLiBanHang.DAO.HoaDonDAO;
import QuanLiBanHang.model.ChiTietHoaDon;
import QuanLiBanHang.model.HoaDon;
import QuanLiBanHang.model.StasticOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "StasticOrderController", urlPatterns = {"/StasticOrderController"})
public class StasticOrderController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        
        String timeBegin=request.getParameter("txtTimeBegin");
        String timeEnd=request.getParameter("txtTimeEnd");
        
        if(timeBegin!="" && timeEnd!=""){
            try {
                ChiTietHoaDonDAO orderDetailDao=new ChiTietHoaDonDAO();
                HoaDonDAO orderDao=new HoaDonDAO();
                List<ChiTietHoaDon> listOrderDetail=new ArrayList<>();
                List<HoaDon> listOrder=new ArrayList<>();
                
                listOrderDetail=orderDetailDao.findAllOrderDetailByTime(timeBegin, timeEnd);
                listOrder=orderDao.findAllOrderByTime(timeBegin, timeEnd);
                
                List<StasticOrder> listStasticOrder=new ArrayList<>();
                for(HoaDon order : listOrder){
                    StasticOrder stasticorder=new StasticOrder( order.getMaHoaDon(), order.getMaKhachHang(), 
                            order.getMaNhanVien(), order.getThueVAT(), order.getGiamGia(), order.getThoiGianBan());
                    List<ChiTietHoaDon> listOrderDetailTemp=new ArrayList<>();
                    for(ChiTietHoaDon orderDetail : listOrderDetail){
                        if(order.getMaHoaDon()==orderDetail.getMaHoaDon()){
                            listOrderDetailTemp.add(orderDetail);
                        }
                    }
                    stasticorder.setList(listOrderDetailTemp);
                    listStasticOrder.add(stasticorder);
                }
                
                session.setAttribute("listStasticOrder", listStasticOrder);
            } catch (SQLException ex) {
                Logger.getLogger(StasticOrderController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequestDispatcher rd=request.getRequestDispatcher("HoaDon.jsp");
            rd.forward(request, response);
        }
        else{
            RequestDispatcher rd=request.getRequestDispatcher("HoaDon.jsp");
            rd.forward(request, response);
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
