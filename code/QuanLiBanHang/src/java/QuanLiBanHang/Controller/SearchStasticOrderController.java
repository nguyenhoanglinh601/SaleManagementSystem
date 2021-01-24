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
import QuanLiBanHang.model.ListStasticOrder;
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
@WebServlet(name = "SearchStasticOrderController", urlPatterns = {"/SearchStasticOrderController"})
public class SearchStasticOrderController extends HttpServlet {

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
        String informationSearch=request.getParameter("InformationSearch");
        String element=request.getParameter("Element");
        
        List<HoaDon> listOrder=new ArrayList<>();
        
        if(element.equalsIgnoreCase("MaSanPham")){
            try {
                ChiTietHoaDonDAO orderDetailDao=new ChiTietHoaDonDAO();
                List<Integer> listOrderId=orderDetailDao.findOrderIdByProductId(informationSearch);
                HoaDonDAO orderDao=new HoaDonDAO();
                for(Integer i: listOrderId){
                    listOrder.add(orderDao.findOrderByOrderId(String.valueOf(i)));                  
                }
            } catch (SQLException ex) {
                Logger.getLogger(SearchStasticOrderController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else{  
            try {
                HoaDonDAO orderDao=new HoaDonDAO();
                listOrder=orderDao.findOrder(element, informationSearch);
            } catch (SQLException ex) {
                Logger.getLogger(SearchStasticOrderController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        List<StasticOrder> listStasticOrder=new ArrayList<>();
        for(HoaDon order: listOrder){
            StasticOrder stasticOrder=new StasticOrder(order);
            ChiTietHoaDonDAO orderDetailDao=new ChiTietHoaDonDAO();
            List<ChiTietHoaDon> listOrderDetail = null;
            try {
                listOrderDetail = orderDetailDao.findOrderDetailByOrderId(String.valueOf(order.getMaHoaDon()));
            } catch (SQLException ex) {
                Logger.getLogger(SearchStasticOrderController.class.getName()).log(Level.SEVERE, null, ex);
            }
            stasticOrder.setList(listOrderDetail);
            listStasticOrder.add(stasticOrder);
        }
        session.setAttribute("listStasticOrder", listStasticOrder);
            
        RequestDispatcher rd=request.getRequestDispatcher("HoaDon.jsp");
        rd.forward(request, response);
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
