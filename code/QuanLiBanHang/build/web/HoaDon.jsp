<%-- 
    Document   : HoaDon.jsp
    Created on : Jun 6, 2020, 6:14:24 PM
    Author     : user
--%>

<%@page import="QuanLiBanHang.model.Staff"%>
<%@page import="QuanLiBanHang.model.ListStasticOrder"%>
<%@page import="QuanLiBanHang.model.ChiTietHoaDon"%>
<%@page import="QuanLiBanHang.model.StasticOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hóa Đơn</title>
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
                font-weight: 600;
                width: 30%;
                height: 554px;
                box-sizing: border-box;
                float: left;
            }
            div.count-right{
                width: 40%;
                padding: 3% 0%;
                text-align: right;
                box-sizing: border-box;
                float: left;
            }
            div.count-left{
                width: 60%;
                padding: 3% 0%;
                text-align: left;
                box-sizing: border-box;
                float: left;
            }
            div.center{
                padding-top: 2%;
                text-align: center;
                width: 100%;
            }
            input.information{
                width: 30%;
                height: 30px;
            }
            input.informationToSearch{
                width: 60%;
                height: 30px;
            }
            input.fileName{
                margin-top: 2%; 
                width: 80%;
                height: 30px;
            }
            select.informationToSearch{
                width: 35%;
                height: 33px;
            }
            div.statisticBill, div.searchBill{
                width: 100%;
                padding: 2% 0%;
                text-align: center;
                box-sizing: border-box;
                float: left;
                line-height: 10px;
            }
            
            input.statistic{
                background-color:black;
                color: white;
                width: 30%;
                height: 35px;
                line-height: 20px;
                border: 0px;
                border-radius: 10px;
            }
            
            input.report{
                background-color:black;
                color: white;
                width: 40%;
                height: 35px;
                line-height: 20px;
                border: 0px;
                border-radius: 10px;
                margin-top:2%;
            }
            
            input.searchBill{
                background-color:black;
                color: white;
                width: 50%;
                height: 35px;
                line-height: 35px;
                border: 0px;
                border-radius: 10px;
            }
            
            input.statistic:hover{
                font-weight: 800;
            }
            
            input.report:hover{
                font-weight: 800;
            }
            
            input.searchBill:hover{
                font-weight: 800;
            }
        </style>
    </head>
    <body>
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
                QUẢN LÝ HÓA ĐƠN
            </div>
            <div class="main-content">
                <div class="list-product">
                    <%
                        String error = (String) session.getAttribute("ErrorReport");
                        List<StasticOrder> list=new ArrayList<>();
                        list=(List<StasticOrder>) session.getAttribute("listStasticOrder");
                        ListStasticOrder liststasticorder=new ListStasticOrder(list);
                        if(list==null){
                    %>
                            Không có nội dung thống kê
                            
                    <%
                            if(error=="error"){
                    %>
                    <script>alert("đường dẫn không tồn tại");</script>
                    <%
                                session.removeAttribute("ErrorReport");
                            }
                        }
                        else{
                            if(error=="error"){
                    %>
                    <script>alert("đường dẫn không tồn tại");</script>
                    <%
                                session.removeAttribute("ErrorReport");
                            }
                    %>
                    <table border="1px solid" cellspacing="0" style="width: 100%; text-align: center;">
                        <tr>
                            <th>MaHD</th>
                            <th>MaNV</th>
                            <th>MaKH</th>
                            <th>MaSP</th>
                            <th>SL</th>
                            <th>GiaBan</th>
                            <th>ThanhTien</th>
                            <th>ThueVAT</th>
                            <th>GiamGia</th>
                            <th>TongCong</th>
                        </tr>
                    <%
                                for(StasticOrder StaOr: liststasticorder.getList()){
                                    int size=StaOr.getList().size();
                                    
                    %>
                        <tr>
                            <td rowspan="<%= size%>"><%= StaOr.getMaHoaDon()%></td>
                            <td rowspan="<%= size%>"><%= StaOr.getMaNhanVien()%></td>
                            <td rowspan="<%= size%>"><%= StaOr.getMaKhachHang()%></td>
                            <td><%= StaOr.getList().get(0).getMaSanPham()%></td>
                            <td><%= StaOr.getList().get(0).getSoLuong()%></td>
                            <td><%= StaOr.getList().get(0).getGiaBan()%> đ</td>
                            <td><%= StaOr.getList().get(0).countTotalOrderDetail()%> đ</td>
                            <td rowspan="<%= size%>"><%= StaOr.getThueVAT()%> đ</td>
                            <td rowspan="<%= size%>"><%= StaOr.getGiamGia()%> đ</td>
                            <td rowspan="<%= size%>"><%= StaOr.countTotalOnOrder()%> đ</td>
                        </tr>
                    <%
                                    for(int i=1;i<StaOr.getList().size();i++){
                                        ChiTietHoaDon orderDetail=new ChiTietHoaDon();
                                        orderDetail=StaOr.getList().get(i);
                    %>  
                        <tr>
                            <td><%= orderDetail.getMaSanPham()%></td>
                            <td><%= orderDetail.getSoLuong()%></td>
                            <td><%= orderDetail.getGiaBan()%> đ</td>
                            <td><%= orderDetail.getSoLuong()*orderDetail.getGiaBan()%> đ</td>
                        </tr>
                    <%
                                    }
                                }
                        };
                    %>
                    </table>
                </div>
                <div class="count">
                    <div class="center">
                        TÌM KIẾM HÓA ĐƠN
                        <div class="searchBill">
                            <form action="SearchStasticOrderController" method="post">
                                <input class="informationToSearch" type="text" name="InformationSearch" placeholder="nhập thông tin" required/>
                                <select name="Element" class="informationToSearch">
                                    <option value="MaHoaDon" selected="select">Mã hóa đơn</option>
                                    <option value="MaNhanVien">Mã nhân viên</option>
                                    <option value="MaKhachHang">Mã khách hàng</option>
                                    <option value="MaSanPham">Mã sản phẩm</option>
                                </select>
                                <br><br>
                                <input class="searchBill" type="submit" name="searchBill" value="TÌM KIẾM">
                            </form>
                        </div>
                    </div>
                    <hr>
                    <div class="center">
                        THỐNG KÊ HÓA ĐƠN
                    </div>
                    <div class="statisticBill">
                        <form action="StasticOrderController" method="post">
                            <input class="information" type="text" name="txtTimeBegin" value="" placeholder="từ ngày" required>
                            <input class="information" type="text" name="txtTimeEnd" value="" placeholder="đến ngày" required>
                            <input class="statistic" type="submit" name="statisticBill" value="THỐNG KÊ">
                        </form>
                    </div>
                    <div class="count-left">
                        Số lượng hóa đơn
                    </div>
                    <div class="count-right">
                        <%
                            if(list!=null){
                                out.println(list.size());
                            }
                            else{
                                out.println("0");
                            }
                        %>
                    </div>
                    <div class="count-left">
                        Số lượng mặt hàng
                    </div>
                    <div class="count-right">
                        <%
                            if(list!=null){
                                out.println(liststasticorder.countProductListOrder());
                            }
                            else{
                                out.println("0");
                            }
                        %>
                    </div>
                    <div class="count-left">
                        Số lượng khách
                    </div>
                    <div class="count-right">
                        <%
                            if(list!=null){
                                out.println(liststasticorder.countCustomerListOrder());
                            }
                            else{
                                out.println("0");
                            }
                        %>
                    </div>
                    <div class="count-left">
                        Doanh thu
                    </div>
                    <div class="count-right">
                        <%
                            if(list!=null){
                                out.println(liststasticorder.countTotalListOrder());
                            }
                            else{
                                out.println("0");
                            }
                        %>
                    </div>
                    <div class="count-left">
                        Giảm giá
                    </div>
                    <div class="count-right">
                        <%
                            if(list!=null){
                                out.println(liststasticorder.countDiscountListOrder());
                            }
                            else{
                                out.println("0");
                            }
                        %>
                    </div>
                    <div class="count-left">
                        Lợi nhuận
                    </div>
                    <div class="count-right">
                        <%
                            if(list!=null){
                                out.println(liststasticorder.countProfitListOrder());
                            }
                            else{
                                out.println("0");
                            }
                        %>
                    </div>
                    <hr>
                    <div class="center">
                        BÁO CÁO HÓA ĐƠN
                        <form action="ReportOrderController" method="post">
                            <input class="fileName" type="text" name="txtFileName" placeholder="nhập tên file" required=/>
                            <input class="report" type="submit" name="action" value="EXPORT">
                            <input class="report" type="submit" name="action" value="IMPORT">
                        </form>
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
