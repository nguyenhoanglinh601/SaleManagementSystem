<%-- 
    Document   : NguoiDung
    Created on : 17-06-2020, 21:31:52
    Author     : doanv
--%>



<%@page import="QuanLiBanHang.model.Staff"%>
<%@page import="QuanLiBanHang.DAO.StaffDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            margin: 2%;
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
            QUẢN LÝ NGƯỜI DÙNG
        </div>
        <div class="main-content">
            <div class="list-product"> 
            <table border="1">
                    <tr>
                        <th>Mã</th>
                        <th>Tên Nhân Viên</th>
                        <th>SDT</th>
                        <th>Địa Chỉ</th>
                        <th>Tên Đăng Nhập</th>
                        <th>Mật Khẩu</th>
                        <th>Quyền</th>
                    </tr>
                    <% 
                        response.setContentType("text/html;charset=UTF-8");
                        request.setCharacterEncoding("utf-8");
                        request.getSession();
                        StaffDao dao=new StaffDao(); 
                        List<Staff> list=dao.findAll();
                        ArrayList outlist=(ArrayList) session.getAttribute("outlist");
                        if(session.getAttribute("outlist")!=null)
                        {
                           list=outlist;
                        }
                           for(Staff staff : list) 
                        {                                                                  
                    %>
                    <tr>
                        <form action="EditStaffController" method="post">
                        <td align="center" name = "manhanvien"><%= staff.getIdStaff()%></td>
                        <input type="hidden" name="StaffId" value="<%= staff.getIdStaff()%>"/>
                        <td><textarea name="tennhanvien" rows="3" cols="50" class="listproducttd" type="text"><%= staff.getName()%></textarea></td>
                        <td align="center"><input name="sdt" class="listproductprice" type="text" value="<%= staff.getNumberPhone()%>"/></td>
                        <td align="center"><input name="diachi"  class="listproductprice" type="text" value="<%= staff.getAddress()%>"/></td>
                        <td align="center"><input name="taikhoan"  class="listproductprice" type="text" value="<%= staff.getUsername()%>"/></td>
                        <td align="center"><input name="matkhau"  class="listproductprice" type="text" value="<%= staff.getPassword()%>"/></td>
                        <td>
                        Admin
                        <input type="radio" name="quyen" value="true"
                        <%= staff.isAccess()?"checked" : "" %>>
                        User
                        <input type="radio" name="quyen" value="false"
                        <%= !staff.isAccess()?"checked" : "" %>><br>
                        </td>
                        
                        <td align="center">
                            
                            <button type="submit" name="update" value="<%= staff.getIdStaff()%>">Update</button>
                        </td>
                        </form>
                        <td align="center">
                            <form action="DeleteStaffController" method="post">
                                <button type="submit" name="delete" value="<%= staff.getIdStaff()%>">Delete</button>
                            </form>
                        </td>
                    </tr>
                    <% }%>                   
            </table>
            </div>
            <div class="count">
                <div class="center">
                    <form action="SeachStaffController" method="get">
                    <b>TÌM KIẾM NHÂN VIÊN</b>
                    <input class="informationSearch" type="text" name="searchname" placeholder="Nhập tên nhân viên">
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
                   
                    <form action="ExportStaffController" method="GET"> 
                        <input type="text" class="information" name="filepath" placeholder="Nhập đường dẫn file" required> <br>
                         <input type="submit" name="hanhdong" class="searchProduct" value="Export"/><input class="searchProduct" name="hanhdong" type="submit" onclick="" value="Import"/>
                     </form>
                     
                </div>
                <form action="NewStaffController" method="POST" style="display: none" id="menu-add">
                <div class="center">
                    <b>THÊM NHÂN VIÊN</b>
                </div>
                
                
                <div class="count-center">
                    <input class="information" type="text" name="tennhanvien" placeholder="Nhập tên nhân viên" required>
                </div>
                <br>
                <div class="count-center">
                    <input class="information" type="text" name="sdt" placeholder="Nhập SĐT"required>
                </div>
                <br>
                <div class="count-center">
                    <input class="information" type="text" name="diachi" placeholder="Nhập địa chỉ" required>
                </div>
                <br>
                <div class="count-center">
                    <input class="information" type="text" name="taikhoan" placeholder="Nhập tài khoản" required>
                </div>
                <br>
                <div class="count-center">
                    <input class="information" type="text" name="matkhau" placeholder="Nhập mật khẩu" required>
                </div>
                <br>
                <div class="count-center">
                    
                    <input type="radio" name="quyen" value="true" required>Admin 
                    
                    <input  type="radio" name="quyen" value="false" required>User
                </div>
             
                <br>
                <div class="count-center">
                    <input class="addProduct" type="submit" name="AddNhanVien" value="Thêm">
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