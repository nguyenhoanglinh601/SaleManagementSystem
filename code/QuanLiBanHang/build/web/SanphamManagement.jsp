<%@page import="QuanLiBanHang.model.Staff"%>
<%@page import="QuanLiBanHang.DAO.NhaCungCapDAO"%>
<%@page import="QuanLiBanHang.model.NhaCungCap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="QuanLiBanHang.model.SanPham"%>
<%@page import="QuanLiBanHang.DAO.SanPhamDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        *{
            font-family: Verdana, Geneva, Tahoma, sans-serif;
            margin: 0;
            padding: 0;
        }
        div.left-col{
            background-color: #888888;
            float: left;
            width: 20%;
            box-sizing: border-box;

        }
        div.right-col{
            float: left;
            width: 80%;
            box-sizing: border-box;
        }
        div.object{
            background-color: #444;
            color: #fff;
            width: 80%;
            height: 98px;
            padding: 7%;
            margin: 10%;
            box-sizing: border-box;
            text-align: center;
            border-radius: 40px;
        }
        div.object:hover{
            background-color: #000;
        }
        div.header{
            background-color: #444;
            color: #fff;
            width: 100%;
            height: 50px;
            line-height: 50px;
            text-align: center;
            font-size: 40px;
            font-weight: 600;
            box-sizing: border-box;
        }
        div.footer{
            background-color: #444;
            color: #fff;
            width: 100%;
            height: 50px;
            line-height: 50px;
            box-sizing: border-box;
        }
        div.left-footer{
            width: 50%;
            height: 50px;
            line-height: 50px;
            float: left;
            text-align: left;
            box-sizing: border-box;
        }
        div.right-footer{
            width: 50%;
            height: 50px;
            line-height: 50px;
            float: left;
            box-sizing: border-box;
        }
        div.exit{
            background-color: #888888;
            color: black;
            width: 20%;
            height: 40px;
            margin: 5px;
            padding-top: 1%;
            line-height: 10px;
            float: right;
            text-align: center;
            box-sizing: border-box;
            border-radius: 10px;
        }
        div.exit:hover{
            background-color: black;
            color: white;
        }
        div.main-content{
            width: 100%;
            height: 554px;
            box-sizing: border-box;
        }
        div.list-product{
            width: 70%;
            height: 554px;
            box-sizing: border-box;
            float: left;
            border: 3px solid red;
            overflow: scroll;
        }
        div.count{
            background-color: #888888;
            color: white;
            text-align: center;
            font-weight: 600;
            width: 30%;
            height: 554px;
            box-sizing: border-box;
            float: left;
        }
        div.count-right{
            width: 60%;
            padding: 2% 0%;
            text-align: right;
            box-sizing: border-box;
            float: left;
        }
        div.count-left{
            width: 40%;
            padding: 2% 0%;
            text-align: left;
            box-sizing: border-box;
            float: left;
        }
        div.center{
            width: 100%;
            padding: 2% 0%;
            box-sizing: border-box;
            text-align: center;
            margin: 3% 0%;
        }
        input.information{
            width: 80%;
            height: 30px;
        }
        select.information{
            width: 80%;
            height: 30px;
        }
        input.addProduct{
            background-color: black;
            color: white;
            width: 80%;
            height: 40px;
            line-height: 40px;
            font-size: 20px;
            margin: 5%;
            border: 0px;
            border-radius: 5px;
        }
        input.addProduct:hover{
            font-weight: 600;
        }
        input.backbutton{
            background-color: black;
            color: white;
            width: 50%;
            height: 30px;
            font-size: 20px;
            margin: 5%;
            border: 0px;
            border-radius: 5px;
        }
        input.informationSearch{
            width: 50%;
            height: 30px;
        }
        input.searchProduct{
            background-color: black;
            color: white;
            width: 25%;
            height: 35px;
            line-height: 35px;
            font-size: 15px;
            margin: 1%;
            border: 0px;
            border-radius: 5px;
        }
        a.searchProduct{
            background-color: black;
            color: white;
            width: 25%;
            height: 35px;
            line-height: 35px;
            font-size: 15px;
            margin: 1%;
            border: 0px;
            border-radius: 5px;
        }
        input.searchProduct:hover{
            font-weight: 600;
        }
        input.listproductprice{
            width: 100px;
            height: 100%    
        }
        th{
            white-space: nowrap
        }
        td{
            white-space: nowrap
        }
        textarea {
  resize: none;
}
    </style>
</head>
<body>
    <!--tạo hiệu ứng -->
    <script>
        function MenuAdd() {
        var x = document.getElementById("menu-control");
        var y = document.getElementById("menu-add");
        var z = document.getElementById("menu-back");
        var a=document.getElementById("formsearch");
        if (x.style.display === "none") {
             x.style.display = "block";
            } 
            else {
             x.style.display = "none";
             a.style.display ="none";
             y.style.display = "block";
             z.style.display = "block";
             
            }
        }
        function MenuAddncc() {
        var x = document.getElementById("menu-control");
        var y = document.getElementById("menu-addncc");
        var z = document.getElementById("menu-back");
        var a=document.getElementById("formsearch");
        if (x.style.display === "none") {
             x.style.display = "block";
            } 
            else {
             x.style.display = "none";
             a.style.display ="none";
             y.style.display = "block";
             z.style.display = "block";
             
            }
        }
        function BackButton() {
        var x = document.getElementById("menu-control");
        var y = document.getElementById("menu-add");
        var z = document.getElementById("menu-back");
        var a=document.getElementById("formsearch");
        var b=document.getElementById("menu-addncc");
        if (x.style.display === "none") {
             x.style.display = "block";
             z.style.display="none";
             a.style.display="block";
             y.style.display="none";
             b.style.display="none";
            } 
        }
        function SearchType() {
        var x = document.getElementById("searchoption");
        var ten=document.getElementById("searchname");
        var id=document.getElementById("searchid");
        var ngay=document.getElementById("searchngay");
        var gia=document.getElementById("searchname");
        var ncc=document.getElementById("searchncc");
        var loai=document.getElementById("searchloai");
        //tên
        if (x.value === "ten") {
             ten.style.display = "block";
            }
            else{
                ten.style.display = "none";
            }
        if (x.value === "id") {
             id.style.display = "block";
            }
            else{
                id.style.display = "none";
            }
        if (x.value === "ncc") {
             ncc.style.display = "block";
            }
            else{
                ncc.style.display = "none";
            }
        if (x.value === "loai") {
             loai.style.display = "block";
            }
            else{
                loai.style.display = "none";
            }
        if (x.value === "ngaynhap") {
             ngay.style.display = "block";
            }
            else{
                ngay.style.display = "none";
            }
        }
</script>
<% if(session.getAttribute("xoa")!=null){ %>
<script>alert("Xóa thành công");</script>
<% session.removeAttribute("xoa");} %>


<% if(session.getAttribute("them")!=null){ %>
<script>alert("Thêm thành công");</script>
<% session.removeAttribute("them");} %>


<% if(session.getAttribute("capnhat")!=null){ %>
<script>alert("Cập nhật thành công");</script>
<% session.removeAttribute("capnhat");} %>


<% if(session.getAttribute("ncc")!=null)
   { 
        boolean kiemtra=(boolean) session.getAttribute("ncc");
        if(kiemtra){
%>
<script>alert("Thêm nhà cung cấp thành công");</script>
<% session.removeAttribute("ncc");} 
else{ %>
<script>alert("Nhà cung cấp bị trùng");</script>
<% session.removeAttribute("ncc");}} %>
<!--tạo hiệu ứng -->
    <div class="left-col">
        <a href="Controller?action=Sell">
                <div class="object">
                    <img src="image/pos-terminal.png" width="40px" height="40px"><br>
                    bán hàng
                </div>
            </a>
            <a href="Controller?action=ProductManagement">
                <div class="object">
                    <img src="image/product.png" width="40px" height="40px"><br>
                    sản phẩm
                </div>
            </a>
            <a href="Controller?action=OrderManagement">
                <div class="object">
                    <img src="image/bill.png" width="40px" height="40px"><br>
                    hóa đơn
                </div>
            </a>
            <a href="Controller?action=CustomerManagement">
                <div class="object">
                    <img src="image/promotion.png" width="40px" height="40px"><br>
                    khách hàng
                </div>
            </a>
            <a href="Controller?action=UserManagement">
                <div class="object">
                    <img src="image/team.png" width="40px" height="40px"><br>
                    người dùng
                </div>
            </a>
    </div>
    <div class="right-col">
        <div class="header">
            QUẢN LÝ SẢN PHẨM
        </div>
        <div class="main-content">
            <div class="list-product"> 
            <table border="1">
                    <tr>
                        <th>Mã</th>
                        <th>Tên Sản Phẩm</th>
                        <th>Gía Bán(VNĐ)</th>
                        <th>Gía Nhập(VNĐ)</th>
                        <th>Số Lượng</th>
                        <th>Ngày Nhập</th>
                        <th>Loại</th>
                        <th>Nhà Cung Cấp</th>
                    </tr>
                    <% 
                         response.setContentType("application/vnd-excel");
                         response.setHeader("Conten-Disposition", "inline;filename=sanphamlist.xls");
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
                    %>
                    <tr>
                        <form action="sanphamEditController" method="POST">
                        <td align="center"><%= sp.getMaSanPham() %></td>
                        <input type="hidden" name="ProductId" value="<%= sp.getMaSanPham() %>"/>
                        <td><textarea name="tensp" rows="3" cols="50" class="listproducttd" type="text"><%= sp.getTenSanPham() %></textarea></td>
                        <td align="center"><input name="giabansp" class="listproductprice" type="number" value="<%= sp.getGiaBan() %>"/></td>
                        <td align="center"><input name="gianhapsp"  class="listproductprice" type="number" value="<%= sp.getGiaNhap() %>"/></td>
                        <td align="center"><input name="luongsp"  class="listproductprice" type="number" value="<%= sp.getLuongTonKho() %>"/></td>
                        <td align="center"><input name="ngaynhapsp" type="date" value="<%= sp.getThoiGianNhap() %>"/></td>
                        <td align="center"><input name="loaisp" type="text" size="3" value="<%= sp.getLoai() %>"/></td>
                        
                        <!--danh sách Các nhà cung cấp-->
                        <td align="center"> <select name="maccsp" class="information" style="width: 150px">
                        <%  
                            NhaCungCapDAO nccdao=new NhaCungCapDAO();
                            List<NhaCungCap> listcc=nccdao.getAllNhaCungCap();
                            for(NhaCungCap ncc : listcc) 
                        {
                            if(ncc.getMaNhaCungCap()==sp.getMaNhaCungCap()){
                        %>
                        <option value="<%= ncc.getMaNhaCungCap() %>" selected><%= ncc.getMaNhaCungCap() %>)<%= ncc.getTenNhaCungCap() %></option>
                        <% }
                           else{
                                %>
                        <option value="<%= ncc.getMaNhaCungCap() %>"><%= ncc.getMaNhaCungCap() %>)<%= ncc.getTenNhaCungCap() %></option>     
                                <%
                            }  }   
                        %>
                    </select></td>
                    <!--danh sách Các nhà cung cấp-->
                        <td align="center">
                            
                            <button type="submit" name="update" value="<%= sp.getMaSanPham() %>">Update</button>
                        </td>
                        </form>
                        <td align="center">
                            <form action="sanphamDeleteController" method="POST"><button type="submit" name="delete" value="<%= sp.getMaSanPham() %>">Delete</button></form>
                        </td>
                    </tr>
                    <% }%>                   
            </table>
            </div>
            <div class="count">
                
                
                
                
                
                 <!--MENU TÌM KIẾM-------------------------------------------------------------------------------------------------------------------->
                <div class="center">
                    <form action="sanphamSearchController" method="GET" id="formsearch">
                    <b>TÌM KIẾM SẢN PHẨM THEO</b>
                    <br>
                    <select id="searchoption" name="searchoption" onchange="SearchType()">
                        <option value="" selected>
                            Tìm kiếm Theo
                        </option>
                        <option value="ten">
                            Tên
                        </option>
                        <option value="id">
                            ID
                        </option>
                        <option value="ncc">
                            Nhà Cung Cấp
                        </option>
                        <option value="loai">
                            Loại
                        </option>
                        <option value="ngaynhap">
                            Ngày nhập
                        </option>
                    </select>
                    <br>
                    <div class="count-center" id="searchloai" style="display: none"><input class="informationSearch" type="text" name="searchloai" placeholder="Nhập loại sản phẩm"></div>
                    
                    <div class="count-center" id="searchid" style="display: none"><input class="informationSearch" type="text" name="searchID" placeholder="Nhập ID sản phẩm" ></div>
                    
                    <div class="count-center" id="searchname" style="display: none"><input class="informationSearch" type="text" name="searchname" placeholder="Nhập tên sản phẩm" ></div>
                   
                    <div class="count-center" id="searchncc" style="display: none">
                    
                    <select name="searchncc" class="information">
                        <option value="" disabled selected>Chọn nhà sản xuất</option>
                        <%  
                            NhaCungCapDAO nccdao=new NhaCungCapDAO();
                            List<NhaCungCap> listcc=nccdao.getAllNhaCungCap();
                            for(NhaCungCap ncc : listcc) 
                        {       
                        %>
                        <option value="<%= ncc.getMaNhaCungCap() %>"><%= ncc.getTenNhaCungCap() %></option>
                        <% }       
                        %>
                    </select>
                </div>
                    
                    <div style="display: none" id="searchngay"> Từ <br> <input class="informationSearch" type="date" name="searchstart" placeholder="Nhập ngày bắt đầu"><br>Đến <br>
                     
                        <input class="informationSearch" type="date" name="searchend" placeholder="Nhập ngày kết thúc"></div>
                      
                        <br> <input class="searchProduct" type="submit" value="Tìm Kiếm" name="searchProduct" >
                    
                    </form>
                </div>
                <hr>
                 
                
                
                
                <!--MENU CHỨC NĂNG-------------------------------------------------------------------------------------------------------------------->
                <div id="menu-control">
                <div class="count-center">
                    Option
                </div>
                    <input class="addProduct" type="submit" onclick="MenuAdd();" value="Thêm Sản Phẩm">
                     <input class="addProduct" type="submit" onclick="MenuAddncc();" value="Thêm nhà cung cấp">
                     <form action="sanphamSearchController" method="POST"><input class="addProduct" type="submit" name="hanhdong" value="Làm mới danh sách"></form>
                     <form action="sanphamEXPORTController" method="GET"> 
                        <input type="text" class="information" accepted=".xls" name="filepath" placeholder="Nhập đường dẫn file" > <br>
                        <input type="submit" class="searchProduct" onclick="" value="Export" name="hanhdong" value="Export"></input><input class="searchProduct" name="hanhdong" type="submit" onclick="" value="Import"/>
                    </form>
                </div>
                
                
                
                
                
                <!--Thêm sản phẩm-------------------------------------------------------------------------------------------------------------------->
                <form action="sanphamAddController" method="POST" style="display: none" id="menu-add">
                <div class="center">
                    <b>THÊM MỚI SẢN PHẨM</b>
                </div>
                
                <div class="count-center">
                    <input class="information" type="text" name="txtNameProduct" placeholder="Nhập tên sản phẩm" required>
                </div>
                    <br>
                <div class="count-center">
                    <input class="information" type="text" name="txtTypeProduct" placeholder="Nhập loại sản phẩm" required>
                </div>
                <br>
                <div class="count-center">
                    <input class="information" type="text" name="txtPriceProduct" placeholder="Nhập giá bán"required>
                </div>
                <br>
                <div class="count-center">
                    <input class="information" type="text" name="txtIDProduct" placeholder="Nhập giá nhập" required>
                </div>
                <br>
                <div class="count-center">
                    <input class="information" type="text" name="txtAmountProduct" placeholder="Nhập số lượng" required>
                </div>
                <br>
                <div class="count-center">
                    
                    <select name="txtIDProducer" class="information" required>
                        <option value="" disabled selected>Chọn nhà sản xuất</option>
                        <%  
                            for(NhaCungCap ncc : listcc) 
                        {       
                        %>
                        <option value="<%= ncc.getMaNhaCungCap() %>"><%= ncc.getTenNhaCungCap() %></option>
                        <% }       
                        %>
                    </select>
                </div>
                <div class="count-center">
                    <input class="addProduct" type="submit" name="addProduct" value="Thêm">
                </div>  
                   </form>
              <!--Thêm sản phẩm-------------------------------------------------------------------------------------------------------------------->
                
              
              
              
              
               <!--THÊM NHÀ CUNG CẤP-------------------------------------------------------------------------------------------------------------------->
              <form action="nhacungcapAddController" method="POST" style="display: none" id="menu-addncc">
                <div class="center">
                    <b>THÊM MỚI NHÀ CUNG CẤP</b>
                </div>
                
                <div class="count-center">
                    <input class="information" type="text" name="NameProducer" placeholder="Nhập tên nhà cung cấp" required>
                </div>
                    <br>
                <div class="count-center">
                    <input class="information" type="text" name="SDTProducer" placeholder="Nhập số điện thoại" required>
                </div>
                <br>                        
                <div class="count-center">
                    <input class="information" type="text" name="DiaChiProducer" placeholder="Nhập Địa chỉ" required>
                </div>
                <br>                        
                <div class="count-center">
                    <input class="information" type="text" name="EmailProducer" placeholder="Nhập Email" required>
                </div>
                <br>
                <div class="count-center">
                    <input class="addProduct" type="submit" name="addProduct" value="Thêm">
                </div>  
                   </form>
               <!--THÊM NHÀ CUNG CẤP-------------------------------------------------------------------------------------------------------------------->
              
              
               <!--nút back-------------------------------------------------------------------------------------------------------------------->
              <div class="count-left" id="menu-back" style="display: none">
                    <input class="backbutton" type="submit" name="addProduct" value="<-" onclick="BackButton();" >
                </div> 
                <!--nút back-------------------------------------------------------------------------------------------------------------------->
            </div>
        </div>
        <div class="footer">
            <div class="left-footer">
                    <% 
                        Staff staff=(Staff) session.getAttribute("staff");
                        String name=staff.getName();
                        if(staff.isAccess()==true){
                            name+=" (Admin)";
                        }
                    %>
                    <b>Nhân viên: <%= name%></b>
            </div>
            <div class="right-footer">
                <a href="Controller?action=Exit">
                    <div class="exit">
                        <img src="image/off.png" width="20px" height="20px"><br>
                        <b>thoát</b>
                    </div>
                </a>
            </div>
        </div>
    </div>
</body>
</html>