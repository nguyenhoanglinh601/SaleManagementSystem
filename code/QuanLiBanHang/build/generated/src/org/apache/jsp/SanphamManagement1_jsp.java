package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import QuanLiBanHang.DAO.NhaCungCapDAO;
import QuanLiBanHang.model.NhaCungCap;
import java.util.List;
import java.util.ArrayList;
import QuanLiBanHang.model.SanPham;
import QuanLiBanHang.DAO.SanPhamDAO;

public final class SanphamManagement1_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        *{\r\n");
      out.write("            font-family: Verdana, Geneva, Tahoma, sans-serif;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("        }\r\n");
      out.write("        div.left-col{\r\n");
      out.write("            background-color: #888888;\r\n");
      out.write("            float: left;\r\n");
      out.write("            width: 20%;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("        div.right-col{\r\n");
      out.write("            float: left;\r\n");
      out.write("            width: 80%;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("        div.object{\r\n");
      out.write("            background-color: #444;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            width: 80%;\r\n");
      out.write("            height: 98px;\r\n");
      out.write("            padding: 7%;\r\n");
      out.write("            margin: 10%;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            border-radius: 40px;\r\n");
      out.write("        }\r\n");
      out.write("        div.object:hover{\r\n");
      out.write("            background-color: #000;\r\n");
      out.write("        }\r\n");
      out.write("        div.header{\r\n");
      out.write("            background-color: #444;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 50px;\r\n");
      out.write("            line-height: 50px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            font-size: 40px;\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("        div.footer{\r\n");
      out.write("            background-color: #444;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 50px;\r\n");
      out.write("            line-height: 50px;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("        div.left-footer{\r\n");
      out.write("            width: 50%;\r\n");
      out.write("            height: 50px;\r\n");
      out.write("            line-height: 50px;\r\n");
      out.write("            float: left;\r\n");
      out.write("            text-align: left;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("        div.right-footer{\r\n");
      out.write("            width: 50%;\r\n");
      out.write("            height: 50px;\r\n");
      out.write("            line-height: 50px;\r\n");
      out.write("            float: left;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("        div.exit{\r\n");
      out.write("            background-color: #888888;\r\n");
      out.write("            color: black;\r\n");
      out.write("            width: 20%;\r\n");
      out.write("            height: 40px;\r\n");
      out.write("            margin: 5px;\r\n");
      out.write("            padding-top: 1%;\r\n");
      out.write("            line-height: 10px;\r\n");
      out.write("            float: right;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("        }\r\n");
      out.write("        div.exit:hover{\r\n");
      out.write("            background-color: black;\r\n");
      out.write("            color: white;\r\n");
      out.write("        }\r\n");
      out.write("        div.main-content{\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 554px;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("        div.list-product{\r\n");
      out.write("            width: 70%;\r\n");
      out.write("            height: 554px;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            float: left;\r\n");
      out.write("            border: 3px solid red;\r\n");
      out.write("            overflow: scroll;\r\n");
      out.write("        }\r\n");
      out.write("        div.count{\r\n");
      out.write("            background-color: #888888;\r\n");
      out.write("            color: white;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("            width: 30%;\r\n");
      out.write("            height: 554px;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            float: left;\r\n");
      out.write("        }\r\n");
      out.write("        div.count-right{\r\n");
      out.write("            width: 60%;\r\n");
      out.write("            padding: 2% 0%;\r\n");
      out.write("            text-align: right;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            float: left;\r\n");
      out.write("        }\r\n");
      out.write("        div.count-left{\r\n");
      out.write("            width: 40%;\r\n");
      out.write("            padding: 2% 0%;\r\n");
      out.write("            text-align: left;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            float: left;\r\n");
      out.write("        }\r\n");
      out.write("        div.center{\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding: 2% 0%;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            margin: 3% 0%;\r\n");
      out.write("        }\r\n");
      out.write("        input.information{\r\n");
      out.write("            width: 80%;\r\n");
      out.write("            height: 30px;\r\n");
      out.write("        }\r\n");
      out.write("        select.information{\r\n");
      out.write("            width: 80%;\r\n");
      out.write("            height: 30px;\r\n");
      out.write("        }\r\n");
      out.write("        input.addProduct{\r\n");
      out.write("            background-color: black;\r\n");
      out.write("            color: white;\r\n");
      out.write("            width: 50%;\r\n");
      out.write("            height: 40px;\r\n");
      out.write("            line-height: 40px;\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("            margin: 5%;\r\n");
      out.write("            border: 0px;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("        input.addProduct:hover{\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("        }\r\n");
      out.write("        input.backbutton{\r\n");
      out.write("            background-color: black;\r\n");
      out.write("            color: white;\r\n");
      out.write("            width: 50%;\r\n");
      out.write("            height: 30px;\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("            margin: 5%;\r\n");
      out.write("            border: 0px;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("        input.informationSearch{\r\n");
      out.write("            width: 50%;\r\n");
      out.write("            height: 30px;\r\n");
      out.write("        }\r\n");
      out.write("        input.searchProduct{\r\n");
      out.write("            background-color: black;\r\n");
      out.write("            color: white;\r\n");
      out.write("            width: 25%;\r\n");
      out.write("            height: 35px;\r\n");
      out.write("            line-height: 35px;\r\n");
      out.write("            font-size: 15px;\r\n");
      out.write("            margin: 1%;\r\n");
      out.write("            border: 0px;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("        input.searchProduct:hover{\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("        }\r\n");
      out.write("        input.listproductprice{\r\n");
      out.write("            width: 100px;\r\n");
      out.write("            height: 100%    \r\n");
      out.write("        }\r\n");
      out.write("        th{\r\n");
      out.write("            white-space: nowrap\r\n");
      out.write("        }\r\n");
      out.write("        td{\r\n");
      out.write("            white-space: nowrap\r\n");
      out.write("        }\r\n");
      out.write("        textarea {\r\n");
      out.write("  resize: none;\r\n");
      out.write("}\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <!--tạo hiệu ứng -->\r\n");
      out.write("    <script>\r\n");
      out.write("        function myFunction() {\r\n");
      out.write("        var x = document.getElementById(\"menu-control\");\r\n");
      out.write("        var y = document.getElementById(\"menu-add\");\r\n");
      out.write("        var z = document.getElementById(\"menu-back\");\r\n");
      out.write("        if (x.style.display === \"none\") {\r\n");
      out.write("             x.style.display = \"block\";\r\n");
      out.write("            } \r\n");
      out.write("            else {\r\n");
      out.write("             x.style.display = \"none\";\r\n");
      out.write("             y.style.display = \"block\";\r\n");
      out.write("             z.style.display = \"block\";\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        function myFunction2() {\r\n");
      out.write("        var x = document.getElementById(\"menu-control\");\r\n");
      out.write("        var y = document.getElementById(\"menu-add\");\r\n");
      out.write("        var z = document.getElementById(\"menu-back\");\r\n");
      out.write("        if (y.style.display === \"none\") {\r\n");
      out.write("             y.style.display = \"block\";\r\n");
      out.write("            } \r\n");
      out.write("            else {\r\n");
      out.write("             x.style.display = \"block\";\r\n");
      out.write("             y.style.display = \"none\";\r\n");
      out.write("             z.style.display = \"none\";\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("</script>\r\n");
      out.write("<!--tạo hiệu ứng -->\r\n");
      out.write("    <div class=\"left-col\">\r\n");
      out.write("        <div class=\"object\">\r\n");
      out.write("            <img src=\"image/pos-terminal.png\" width=\"40px\" height=\"40px\"><br>\r\n");
      out.write("            bán hàng\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"object\">\r\n");
      out.write("            <img src=\"image/product.png\" width=\"40px\" height=\"40px\"><br>\r\n");
      out.write("            sản phẩm\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"object\">\r\n");
      out.write("            <img src=\"image/bill.png\" width=\"40px\" height=\"40px\"><br>\r\n");
      out.write("            hóa đơn\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"object\">\r\n");
      out.write("            <img src=\"image/promotion.png\" width=\"40px\" height=\"40px\"><br>\r\n");
      out.write("            khách hàng\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"object\">\r\n");
      out.write("            <img src=\"image/team.png\" width=\"40px\" height=\"40px\"><br>\r\n");
      out.write("            người dùng\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"right-col\">\r\n");
      out.write("        <div class=\"header\">\r\n");
      out.write("            QUẢN LÝ SẢN PHẨM\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"main-content\">\r\n");
      out.write("            <div class=\"list-product\"> \r\n");
      out.write("            <table border=\"1\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>Mã</th>\r\n");
      out.write("                        <th>Tên Sản Phẩm</th>\r\n");
      out.write("                        <th>Gía Bán(VNĐ)</th>\r\n");
      out.write("                        <th>Gía Nhập(VNĐ)</th>\r\n");
      out.write("                        <th>Số Lượng</th>\r\n");
      out.write("                        <th>Ngày Nhập</th>\r\n");
      out.write("                        <th>Loại</th>\r\n");
      out.write("                        <th>Nhà Cung Cấp</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");
 
                        response.setContentType("text/html;charset=UTF-8");
                        request.setCharacterEncoding("utf-8");
                        request.getSession();
                        SanPhamDAO spdao=new SanPhamDAO(); 
                        ArrayList<SanPham> list=spdao.getAllSanPham();
                        ArrayList listloc=(ArrayList) session.getAttribute("listloc");
                        if(session.getAttribute("listloc")!=null)
                        {
                           list=listloc;
                        }
                           for(SanPham sp : list) 
                        {                                  
                    
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <form action=\"sanphamEditController\" method=\"POST\">\r\n");
      out.write("                        <td align=\"center\">");
      out.print( sp.getMaSanPham() );
      out.write("</td>\r\n");
      out.write("                        <td><textarea name=\"tensp\" rows=\"3\" cols=\"50\" class=\"listproducttd\" type=\"text\">");
      out.print( sp.getTenSanPham() );
      out.write("</textarea></td>\r\n");
      out.write("                        <td align=\"center\"><input name=\"giabansp\" class=\"listproductprice\" type=\"number\" value=\"");
      out.print( sp.getGiaBan() );
      out.write("\"/></td>\r\n");
      out.write("                        <td align=\"center\"><input name=\"gianhapsp\"  class=\"listproductprice\" type=\"number\" value=\"");
      out.print( sp.getGiaNhap() );
      out.write("\"/></td>\r\n");
      out.write("                        <td align=\"center\"><input name=\"luongsp\"  class=\"listproductprice\" type=\"number\" value=\"");
      out.print( sp.getLuongTonKho() );
      out.write("\"/></td>\r\n");
      out.write("                        <td align=\"center\"><input name=\"ngaynhapsp\" type=\"date\" value=\"");
      out.print( sp.getThoiGianNhap() );
      out.write("\"/></td>\r\n");
      out.write("                        <td align=\"center\"><input name=\"loaisp\" type=\"text\" size=\"3\" value=\"");
      out.print( sp.getLoai() );
      out.write("\"/></td>\r\n");
      out.write("                        \r\n");
      out.write("                        <!--danh sách Các nhà cung cấp-->\r\n");
      out.write("                        <td align=\"center\"> <select name=\"maccsp\" class=\"information\" style=\"width: 150px\">\r\n");
      out.write("                        ");
  
                            NhaCungCapDAO nccdao=new NhaCungCapDAO();
                            List<NhaCungCap> listcc=nccdao.getAllNhaCungCap();
                            for(NhaCungCap ncc : listcc) 
                        {
                            if(ncc.getMaNhaCungCap()==sp.getMaNhaCungCap()){
                        
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print( ncc.getMaNhaCungCap() );
      out.write("\" selected>");
      out.print( ncc.getMaNhaCungCap() );
      out.write(')');
      out.print( ncc.getTenNhaCungCap() );
      out.write("</option>\r\n");
      out.write("                        ");
 }
                           else{
                                
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print( ncc.getMaNhaCungCap() );
      out.write('"');
      out.write('>');
      out.print( ncc.getMaNhaCungCap() );
      out.write(')');
      out.print( ncc.getTenNhaCungCap() );
      out.write("</option>     \r\n");
      out.write("                                ");

                            }  }   
                        
      out.write("\r\n");
      out.write("                    </select></td>\r\n");
      out.write("                    <!--danh sách Các nhà cung cấp-->\r\n");
      out.write("                        <td align=\"center\">\r\n");
      out.write("                            <button type=\"submit\" name=\"update\" value=\"");
      out.print( sp.getMaSanPham() );
      out.write("\">Update</button>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        </form>\r\n");
      out.write("                        <td align=\"center\">\r\n");
      out.write("                            <form action=\"sanphamDeleteController\" method=\"POST\"><button type=\"submit\" name=\"delete\" value=\"");
      out.print( sp.getMaSanPham() );
      out.write("\">Delete</button></form>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");
 }
      out.write("                   \r\n");
      out.write("            </table>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"count\">\r\n");
      out.write("                <div class=\"center\">\r\n");
      out.write("                    <form action=\"sanphamSearchController\" method=\"GET\">\r\n");
      out.write("                    <b>TÌM KIẾM SẢN PHẨM</b>\r\n");
      out.write("                    <input class=\"informationSearch\" type=\"text\" name=\"searchname\" placeholder=\"Nhập tên sản phẩm\">\r\n");
      out.write("                    <input class=\"searchProduct\" type=\"submit\" name=\"searchProduct\" >\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("                <hr>\r\n");
      out.write("                <div id=\"menu-control\">\r\n");
      out.write("                <div class=\"count-center\">\r\n");
      out.write("                    Option\r\n");
      out.write("                </div>\r\n");
      out.write("                    <input class=\"addProduct\" type=\"submit\" onclick=\"myFunction();\" value=\"Thêm\">\r\n");
      out.write("                    <hr>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <form action=\"sanphamEXPORTController\" method=\"GET\"> \r\n");
      out.write("                        <input type=\"text\" class=\"information\" name=\"filepath\" placeholder=\"Nhập đường dẫn file\" required> <br>\r\n");
      out.write("                         <input type=\"submit\" name=\"hanhdong\" class=\"searchProduct\" value=\"Export\"/><input class=\"searchProduct\" name=\"hanhdong\" type=\"submit\" onclick=\"\" value=\"Import\"/>\r\n");
      out.write("                     </form>    \r\n");
      out.write("                </div>\r\n");
      out.write("                <form action=\"sanphamAddController\" method=\"POST\" style=\"display: none\" id=\"menu-add\">\r\n");
      out.write("                <div class=\"center\">\r\n");
      out.write("                    <b>THÊM MỚI SẢN PHẨM</b>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"count-center\">\r\n");
      out.write("                    <input class=\"information\" type=\"text\" name=\"txtNameProduct\" placeholder=\"Nhập tên sản phẩm\" required>\r\n");
      out.write("                </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                <div class=\"count-center\">\r\n");
      out.write("                    <input class=\"information\" type=\"text\" name=\"txtTypeProduct\" placeholder=\"Nhập loại sản phẩm\" required>\r\n");
      out.write("                </div>\r\n");
      out.write("                <br>\r\n");
      out.write("                <div class=\"count-center\">\r\n");
      out.write("                    <input class=\"information\" type=\"text\" name=\"txtPriceProduct\" placeholder=\"Nhập giá bán\"required>\r\n");
      out.write("                </div>\r\n");
      out.write("                <br>\r\n");
      out.write("                <div class=\"count-center\">\r\n");
      out.write("                    <input class=\"information\" type=\"text\" name=\"txtIDProduct\" placeholder=\"Nhập giá nhập\" required>\r\n");
      out.write("                </div>\r\n");
      out.write("                <br>\r\n");
      out.write("                <div class=\"count-center\">\r\n");
      out.write("                    <input class=\"information\" type=\"text\" name=\"txtAmountProduct\" placeholder=\"Nhập số lượng\" required>\r\n");
      out.write("                </div>\r\n");
      out.write("                <br>\r\n");
      out.write("                <div class=\"count-center\">\r\n");
      out.write("                    \r\n");
      out.write("                    <select name=\"txtIDProducer\" class=\"information\" required>\r\n");
      out.write("                        <option value=\"\" disabled selected>Chọn nhà sản xuất</option>\r\n");
      out.write("                        ");
  
                            NhaCungCapDAO nccdao=new NhaCungCapDAO();
                            List<NhaCungCap> listcc=nccdao.getAllNhaCungCap();
                            for(NhaCungCap ncc : listcc) 
                        {       
                        
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print( ncc.getMaNhaCungCap() );
      out.write('"');
      out.write('>');
      out.print( ncc.getTenNhaCungCap() );
      out.write("</option>\r\n");
      out.write("                        ");
 }       
                        
      out.write("\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"count-center\">\r\n");
      out.write("                    <input class=\"addProduct\" type=\"submit\" name=\"addProduct\" value=\"Thêm\">\r\n");
      out.write("                </div>  \r\n");
      out.write("                   </form>\r\n");
      out.write("                <div class=\"count-left\" id=\"menu-back\" style=\"display: none\">\r\n");
      out.write("                    <input class=\"backbutton\" type=\"submit\" name=\"addProduct\" value=\"<-\" onclick=\"myFunction2();\" >\r\n");
      out.write("                </div>     \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"footer\">\r\n");
      out.write("            <div class=\"left-footer\">\r\n");
      out.write("                <b>Nhân viên: </b>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"right-footer\">\r\n");
      out.write("                <div class=\"exit\">\r\n");
      out.write("                    <form>\r\n");
      out.write("                    <img src=\"image/off.png\" width=\"20px\" height=\"20px\"><br>\r\n");
      out.write("                    <b>thoát</b>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
