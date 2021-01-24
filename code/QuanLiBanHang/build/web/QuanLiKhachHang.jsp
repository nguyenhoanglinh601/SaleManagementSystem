<%@page import="QuanLiBanHang.model.Staff"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="QuanLiBanHang.model.KhachHang"%>
<%@page import="QuanLiBanHang.DAO.KhachHangDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            width: 50%;
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
        function myFunction() {
        var x = document.getElementById("menu-control");
        var y = document.getElementById("menu-add");
        var z = document.getElementById("menu-back");
        if (x.style.display === "none") {
             x.style.display = "block";
            } 
            else {
             x.style.display = "none";
             y.style.display = "block";
             z.style.display = "block";
            }
        }
        function myFunction2() {
        var x = document.getElementById("menu-control");
        var y = document.getElementById("menu-add");
        var z = document.getElementById("menu-back");
        if (y.style.display === "none") {
             y.style.display = "block";
            } 
            else {
             x.style.display = "block";
             y.style.display = "none";
             z.style.display = "none";
            }
        }
</script>
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
            QUẢN LÝ KHÁCH HÀNG
        </div>
        <div class="main-content">
            <div class="list-product"> 
            <table border="1">
                    <tr>
                        <th>Mã</th>
                        <th>Tên Khách Hàng</th>
                        <th>SDT</th>
                        <th>Địa Chỉ</th>
                        <th>Email</th>
                        <th>Điểm</th>
                    </tr>
                    <% 
                        response.setContentType("text/html;charset=UTF-8");
                        request.setCharacterEncoding("utf-8");
                        request.getSession();
                        KhachHangDAO khdao=new KhachHangDAO(); 
                        ArrayList<KhachHang> list=khdao.findAll();
                        ArrayList listloc=(ArrayList) session.getAttribute("listloc");
                        if(session.getAttribute("listloc")!=null)
                        {
                           list=listloc;
                        }
                           for(KhachHang Kh : list) 
                        {                                                                  
                    %>
                    <tr>
                        <form action="EditKhachHangController" method="POST">
                        <td align="center"><%= Kh.getMaKhachHang()%></td>
                        <td><textarea name="TenKhachHang" rows="3" cols="50" class="listproducttd" type="text"><%= Kh.getTenKhachHang()%></textarea></td>
                        <td align="center"><input name="SDT" class="listproductprice" type="text" value="<%= Kh.getSDT()%>"/></td>
                        <td align="center"><input name="DiaChi"  class="listproductprice" type="text" value="<%= Kh.getDiaChi()%>"/></td>
                        <td align="center"><input name="Email"  class="listproductprice" type="text" value="<%= Kh.getEmail()%>"/></td>
                        <td align="center"><input name="Diem" type="number" value="<%= Kh.getDiem() %>"/></td>
                        
                        
                        <td align="center">
                            <button type="submit" name="update" value="<%= Kh.getMaKhachHang() %>">Update</button>
                        </td>
                        </form>
                        <td align="center">
                            <form action="DeleteKhachHangController" method="POST">
                                <button type="submit" name="delete" value="<%= Kh.getMaKhachHang()%>">Delete</button>
                            </form>
                        </td>
                    </tr>
                    <% }%>                   
            </table>
            </div>
            <div class="count">
                <div class="center">
                    <form action="searchKhachHangController" method="GET">
                    <b>TÌM KIẾM KHÁCH HÀNG</b>
                    <input class="informationSearch" type="text" name="searchname" placeholder="Nhập tên khách hàng">
                    <input class="searchProduct" type="submit" name="searchProduct" value="Tìm Kiếm">
                    </form>
                </div>
                <hr>
                <div id="menu-control">
                <div class="count-center">
                    Option
                </div>
                    <input class="addProduct" type="submit" onclick="myFunction();" value="Thêm">
                    <hr>
                    <br>
                    <form action="ExportKhachHangController" method="GET"> 
                        <input type="text" class="information" name="filepath" placeholder="Nhập đường dẫn file" required> <br>
                         <input type="submit" name="hanhdong" class="searchProduct" value="Export"/><input class="searchProduct" name="hanhdong" type="submit" onclick="" value="Import"/>
                     </form>    
                </div>
                <form action="AddKhachHangController" method="POST" style="display: none" id="menu-add">
                <div class="center">
                    <b>THÊM MỚI KHÁCH HÀNG</b>
                </div>
                    <br>
                <div class="count-center">
                    <input class="information" type="text" name="TenKhachHang" placeholder="Nhập tên khách hàng" required>
                </div>
                <br>
                <div class="count-center">
                    <input class="information" type="text" name="SDT" placeholder="Nhập SĐT"required>
                </div>
                <br>
                <div class="count-center">
                    <input class="information" type="text" name="DiaChi" placeholder="Nhập địa chỉ" required>
                </div>
                <br>
                <div class="count-center">
                    <input class="information" type="text" name="Email" placeholder="Nhập email" required>
                </div>
                <br>
                <div class="count-center">
                    <input class="addProduct" type="submit" name="AddKhachHang" value="Thêm">
                </div>  
                   </form>
                <div class="count-left" id="menu-back" style="display: none">
                    <input class="backbutton" type="submit" name="add" value="<-" onclick="myFunction2();" >
                </div>     
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