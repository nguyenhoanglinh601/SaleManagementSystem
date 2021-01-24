package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import QuanLiBanHang.DAO.SanPhamDAO;
import QuanLiBanHang.model.HoaDon;
import QuanLiBanHang.DAO.HoaDonDAO;
import QuanLiBanHang.model.SanPham;
import java.util.ArrayList;
import QuanLiBanHang.model.MatHang;
import java.util.List;
import java.util.List;
import QuanLiBanHang.model.DonHang;

public final class BanHang_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Bán Hàng</title>\n");
      out.write("        <style>\n");
      out.write("            *{\n");
      out.write("                font-family: Verdana, Geneva, Tahoma, sans-serif;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("            div.left-col{\n");
      out.write("                background-color: #888888;\n");
      out.write("                float: left;\n");
      out.write("                width: 20%;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("            div.right-col{\n");
      out.write("                float: left;\n");
      out.write("                width: 80%;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("            div.object{\n");
      out.write("                background-color: #444;\n");
      out.write("                color: #fff;\n");
      out.write("                width: 80%;\n");
      out.write("                height: 98px;\n");
      out.write("                padding: 7%;\n");
      out.write("                margin: 10%;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                text-align: center;\n");
      out.write("                border-radius: 40px;\n");
      out.write("            }\n");
      out.write("            div.object:hover{\n");
      out.write("                background-color: #000;\n");
      out.write("            }\n");
      out.write("            div.header{\n");
      out.write("                background-color: #444;\n");
      out.write("                color: #fff;\n");
      out.write("                width: 100%;\n");
      out.write("                height: 50px;\n");
      out.write("                line-height: 50px;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 40px;\n");
      out.write("                font-weight: 600;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("            div.footer{\n");
      out.write("                background-color: #444;\n");
      out.write("                color: #fff;\n");
      out.write("                width: 100%;\n");
      out.write("                height: 50px;\n");
      out.write("                line-height: 50px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("            div.left-footer{\n");
      out.write("                width: 50%;\n");
      out.write("                height: 50px;\n");
      out.write("                line-height: 50px;\n");
      out.write("                float: left;\n");
      out.write("                text-align: left;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("            div.right-footer{\n");
      out.write("                width: 50%;\n");
      out.write("                height: 50px;\n");
      out.write("                line-height: 50px;\n");
      out.write("                float: left;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("            div.exit{\n");
      out.write("                background-color: #888888;\n");
      out.write("                color: black;\n");
      out.write("                width: 20%;\n");
      out.write("                height: 40px;\n");
      out.write("                margin: 5px;\n");
      out.write("                padding-top: 1%;\n");
      out.write("                line-height: 10px;\n");
      out.write("                float: right;\n");
      out.write("                text-align: center;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      out.write("            div.exit:hover{\n");
      out.write("                background-color: black;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            div.main-content{\n");
      out.write("                width: 100%;\n");
      out.write("                height: 554px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("            div.list-product{\n");
      out.write("                width: 70%;\n");
      out.write("                height: 554px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                float: left;\n");
      out.write("                border: 3px solid red;\n");
      out.write("                overflow: scroll;\n");
      out.write("            }\n");
      out.write("            div.count{\n");
      out.write("                background-color: #888888;\n");
      out.write("                color: white;\n");
      out.write("                font-weight: 600;\n");
      out.write("                width: 30%;\n");
      out.write("                height: 554px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("            div.count-right{\n");
      out.write("                width: 40%;\n");
      out.write("                padding: 3% 0%;\n");
      out.write("                text-align: right;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("            div.count-left{\n");
      out.write("                width: 60%;\n");
      out.write("                padding: 3% 0%;\n");
      out.write("                text-align: left;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("            div.customer{\n");
      out.write("                text-align: center;\n");
      out.write("                width: 100%;\n");
      out.write("                padding-top: 5%;\n");
      out.write("                height: 100px;\n");
      out.write("                line-height: 30px;\n");
      out.write("            }\n");
      out.write("            div.IDproduct{\n");
      out.write("                text-align: left;\n");
      out.write("                width: 95%;\n");
      out.write("                padding: 5% 0% 0% 5%;\n");
      out.write("                height: 100px;\n");
      out.write("                line-height: 30px;\n");
      out.write("            }\n");
      out.write("            input.addProduct{\n");
      out.write("                background-color:black;\n");
      out.write("                color: white;\n");
      out.write("                width: 25%;\n");
      out.write("                height: 35px;\n");
      out.write("                line-height: 35px;\n");
      out.write("                border: 0px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("            }\n");
      out.write("            input.addProduct:hover{\n");
      out.write("                font-weight: 800;\n");
      out.write("            }\n");
      out.write("            input.information{\n");
      out.write("                width: 70%;\n");
      out.write("                height: 30px;\n");
      out.write("            }\n");
      out.write("            input.informationProduct{\n");
      out.write("                width: 50%;\n");
      out.write("                height: 30px;\n");
      out.write("            }\n");
      out.write("            select.informationProduct{\n");
      out.write("                width: 52%;\n");
      out.write("                height: 34px;\n");
      out.write("            }\n");
      out.write("            input.number{\n");
      out.write("                width: 10%;\n");
      out.write("                height: 30px;\n");
      out.write("            }\n");
      out.write("            div.submit{\n");
      out.write("                width: 50%;\n");
      out.write("                padding: 3% 0%;\n");
      out.write("                text-align: center;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("            input.submit{\n");
      out.write("                background-color:black;\n");
      out.write("                color: white;\n");
      out.write("                width: 80%;\n");
      out.write("                height: 50px;\n");
      out.write("                line-height: 50px;\n");
      out.write("                border: 0px;\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      out.write("            input.submit:hover{\n");
      out.write("                font-weight: 800;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .tab {\n");
      out.write("                overflow: hidden;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                background-color: #f1f1f1;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .tab button {\n");
      out.write("              \twidth:50%;\n");
      out.write("                height:20px;\n");
      out.write("                line-height:0px;\n");
      out.write("                font-size: 15px;\n");
      out.write("                background-color: inherit;\n");
      out.write("                float: left;\n");
      out.write("                border: none;\n");
      out.write("                outline: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("                padding: 14px 16px;\n");
      out.write("                transition: 0.3s;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .tab button:hover {\n");
      out.write("                background-color: #ddd;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .tab button.active {\n");
      out.write("                background-color: #ccc;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .tabcontent {\n");
      out.write("                display: none;\n");
      out.write("                height: 80px;\n");
      out.write("                padding: 2px 0px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-top: none;\n");
      out.write("                background-color: #bbb;\n");
      out.write("            }\n");
      out.write("            .topright {\n");
      out.write("                float: right;\n");
      out.write("                cursor: pointer;\n");
      out.write("                font-size: 28px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .topright:hover {color: red;}\n");
      out.write("            \n");
      out.write("            div.center{\n");
      out.write("                font-size: 20px;\n");
      out.write("                padding-top: 2%;\n");
      out.write("                text-align: center;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"left-col\">\n");
      out.write("            <a href=\"BanHang.jsp\">\n");
      out.write("                <div class=\"object\">\n");
      out.write("                    <img src=\"image/pos-terminal.png\" width=\"40px\" height=\"40px\"><br>\n");
      out.write("                    bán hàng\n");
      out.write("                </div>\n");
      out.write("            </a>\n");
      out.write("            <a href=\"SanphamManagement.jsp\">\n");
      out.write("                <div class=\"object\">\n");
      out.write("                    <img src=\"image/product.png\" width=\"40px\" height=\"40px\"><br>\n");
      out.write("                    sản phẩm\n");
      out.write("                </div>\n");
      out.write("            </a>\n");
      out.write("            <a href=\"HoaDon.jsp\">\n");
      out.write("                <div class=\"object\">\n");
      out.write("                    <img src=\"image/bill.png\" width=\"40px\" height=\"40px\"><br>\n");
      out.write("                    hóa đơn\n");
      out.write("                </div>\n");
      out.write("            </a>\n");
      out.write("            <a href=\"QuanLiKhachHang.jsp\">\n");
      out.write("                <div class=\"object\">\n");
      out.write("                    <img src=\"image/promotion.png\" width=\"40px\" height=\"40px\"><br>\n");
      out.write("                    khách hàng\n");
      out.write("                </div>\n");
      out.write("            </a>\n");
      out.write("            <div class=\"object\">\n");
      out.write("                <img src=\"image/team.png\" width=\"40px\" height=\"40px\"><br>\n");
      out.write("                    người dùng\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"right-col\">\n");
      out.write("            <div class=\"header\">\n");
      out.write("                BÁN HÀNG\n");
      out.write("            </div>\n");
      out.write("            <div class=\"main-content\">\n");
      out.write("                <div class=\"list-product\">\n");
      out.write("                    ");

                        DonHang donhang =(DonHang) session.getAttribute("order");
                        if(donhang==null){
                            out.println("chưa chọn sản phẩm nào");
                        }    
                        else{
                            List<MatHang> DanhSachMatHang=donhang.getDanhSachMatHang();
                    
      out.write("\n");
      out.write("                    <table border=\"1px solid\" colspan=\"1px\" width=\"100%\">\n");
      out.write("                        <tr>\n");
      out.write("                            <th>số thứ tự</th>\n");
      out.write("                            <th>mã sản phẩm</th>\n");
      out.write("                            <th>tên sản phẩm</th>\n");
      out.write("                            <th>số lượng</th>\n");
      out.write("                            <th>giá bán</th>\n");
      out.write("                            <th>thành tiền</th>\n");
      out.write("                            <th></th>\n");
      out.write("                        </tr>\n");
      out.write("                            ");

                                int i=1;
                                for(MatHang mathang: DanhSachMatHang){
                            
      out.write("\n");
      out.write("                            <tr style=\"text-align: center;\">\n");
      out.write("                                <td>");
      out.print( i++);
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( mathang.getMaMatHang() );
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( mathang.getSanPham().getTenSanPham() );
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( mathang.getSoLuong() );
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( mathang.getGiaBan() );
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( mathang.getGiaBan()*mathang.getSoLuong() );
      out.write("</td>\n");
      out.write("                                <td><a href=\"XoaSanPhamTuDonHangController?value=");
      out.print( mathang.getMaMatHang());
      out.write("\"><img src=\"image/rubbish.png\" width=\"20px\" height=\"20px\"></a></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                }
                                session.setAttribute("order", donhang);
                            }
                            
      out.write("\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"count\">\n");
      out.write("                    <div class=\"center\">THÔNG TIN ĐƠN HÀNG</div>\n");
      out.write("                    <div class=\"count-left\">\n");
      out.write("                        Số lượng mặt hàng\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"count-right\">\n");
      out.write("                        ");

                            if(donhang!=null){
                                out.println(donhang.getQuantityProduct());
                            }
                            else{
                                out.println("0");
                            }
                        
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"count-left\">\n");
      out.write("                        Thuế VAT\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"count-right\">\n");
      out.write("                        ");

                            if(donhang!=null){
                                out.println(donhang.getTax());
                            }
                            else{
                                out.println("0");
                            }
                        
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"count-left\">\n");
      out.write("                        Giảm giá\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"count-right\">\n");
      out.write("                        ");

                            if(donhang!=null){
                                out.println(donhang.getDiscount());
                            }
                            else{
                                out.println("0");
                            }
                        
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"count-left\">\n");
      out.write("                        TỔNG CỘNG\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"count-right\">\n");
      out.write("                        ");

                            if(donhang!=null){
                                out.println(donhang.getTotalAfterDiscount());
                            }
                            else{
                                out.println("0");
                            }
                        
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <hr>\n");
      out.write("                    <div class=\"center\">THÔNG TIN SẢN PHẨM</div><br>\n");
      out.write("                    <div class=\"tab\">\n");
      out.write("                        <button class=\"tablinks\" onclick=\"openCity(event, 'London')\" id=\"defaultOpen\"><b>Nhập</b></button>\n");
      out.write("                        <button class=\"tablinks\" onclick=\"openCity(event, 'Paris')\"><b>Chọn</b></button>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div id=\"London\" class=\"tabcontent\">\n");
      out.write("                        <div class=\"IDproduct\">\n");
      out.write("                            <form style=\"padding-top:5%;\" action=\"ThemSanPhamVaoDonHangController\" method=\"post\">\n");
      out.write("                                <input class=\"informationProduct\" type=\"text\" name=\"IDProduct\" value=\"\" placeholder=\"nhập mã sản phẩm\" required>\n");
      out.write("                                <input class=\"number\" type=\"number\" name=\"NumberProduct\" value=\"1\">\n");
      out.write("                                <input class=\"addProduct\" type=\"submit\" name=\"addProduct\" value=\"THÊM\">\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div id=\"Paris\" class=\"tabcontent\">\n");
      out.write("                        <div class=\"IDproduct\">\n");
      out.write("                            <form style=\"padding-top:5%;\" action=\"ThemSanPhamVaoDonHangController\" method=\"post\">\n");
      out.write("                                <select class=\"informationProduct\" name=\"IDProduct\">\n");
      out.write("                                    ");

                                        SanPhamDAO productDao=new SanPhamDAO();
                                        List<SanPham> list=productDao.getAllProduct();
                                        for(SanPham product: list){
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print(product.getMaSanPham());
      out.write('"');
      out.write('>');
      out.print(product.getMaSanPham());
      out.write('-');
      out.print(product.getTenSanPham());
      out.write("</option>\n");
      out.write("                                    ");

                                        }
                                    
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                                <input class=\"number\" type=\"number\" name=\"NumberProduct\" value=\"1\">\n");
      out.write("                                <input class=\"addProduct\" type=\"submit\" name=\"addProduct\" value=\"THÊM\">\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <hr>\n");
      out.write("                    <form action=\"ThemHoaDonController\" method=\"post\">\n");
      out.write("                        <div class=\"customer\">\n");
      out.write("                                THÔNG TIN KHÁCH HÀNG\n");
      out.write("                                <input class=\"information\" type=\"text\" name=\"numberPhoneCustomer\" value=\"\" placeholder=\"nhập số điện thoại khách hàng\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"submit\">\n");
      out.write("                                <input class=\"submit\" type=\"submit\" name=\"pay\" value=\"THANH TOÁN\">\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <div class=\"submit\">\n");
      out.write("                        <form action=\"HuyDonHangController\" method=\"post\">\n");
      out.write("                            <input class=\"submit\" type=\"submit\" name=\"cancel\" value=\"HỦY PHIẾU\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"footer\">\n");
      out.write("                <div class=\"left-footer\">\n");
      out.write("                    <b>Nhân viên: </b>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"right-footer\">\n");
      out.write("                    <div class=\"exit\">\n");
      out.write("                        <img src=\"image/off.png\" width=\"20px\" height=\"20px\"><br>\n");
      out.write("                        <b>thoát</b>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            function openCity(evt, cityName) {\n");
      out.write("                var i, tabcontent, tablinks;\n");
      out.write("                tabcontent = document.getElementsByClassName(\"tabcontent\");\n");
      out.write("                for (i = 0; i < tabcontent.length; i++) {\n");
      out.write("                  tabcontent[i].style.display = \"none\";\n");
      out.write("                }\n");
      out.write("                tablinks = document.getElementsByClassName(\"tablinks\");\n");
      out.write("                for (i = 0; i < tablinks.length; i++) {\n");
      out.write("                  tablinks[i].className = tablinks[i].className.replace(\" active\", \"\");\n");
      out.write("                }\n");
      out.write("                document.getElementById(cityName).style.display = \"block\";\n");
      out.write("                evt.currentTarget.className += \" active\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("              // Get the element with id=\"defaultOpen\" and click on it\n");
      out.write("            document.getElementById(\"defaultOpen\").click();\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
