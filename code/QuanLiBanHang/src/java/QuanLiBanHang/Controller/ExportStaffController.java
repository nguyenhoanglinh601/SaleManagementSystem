package QuanLiBanHang.Controller;


import QuanLiBanHang.Helper.ReadWriteNhanVienExcel;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import QuanLiBanHang.model.Staff;
import QuanLiBanHang.DAO.StaffDao;




@WebServlet(name = "ExportStaffController", urlPatterns = {"/ExportStaffController"})
public class ExportStaffController extends HttpServlet {

    
    
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            ReadWriteNhanVienExcel rwex=new ReadWriteNhanVienExcel();
            String filepath=request.getParameter("filepath");
            String action=request.getParameter("hanhdong");
            StaffDao dao=new StaffDao();
            List<Staff> listall = dao.findAll();
            LocalDate thoigian=java.time.LocalDate.now();
            String thoigianban=thoigian.getYear()+"-"+thoigian.getMonthValue()+"-"+thoigian.getDayOfMonth();
            if(action.equals("Export"))
            {
                rwex.writeFileExcel(filepath+".xls");
            }
       
            RequestDispatcher rd=request.getRequestDispatcher("NguoiDung.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ExportStaffController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ExportStaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
   

}
