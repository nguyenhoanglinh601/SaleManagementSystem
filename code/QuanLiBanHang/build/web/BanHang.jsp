<%-- 
    Document   : BanHang
    Created on : May 30, 2020, 11:23:10 AM
    Author     : user
--%>

<%@page import="QuanLiBanHang.model.Staff"%>
<%@page import="QuanLiBanHang.DAO.SanPhamDAO"%>
<%@page import="QuanLiBanHang.model.HoaDon"%>
<%@page import="QuanLiBanHang.DAO.HoaDonDAO"%>
<%@page import="QuanLiBanHang.model.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@page import="QuanLiBanHang.model.MatHang"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="QuanLiBanHang.model.DonHang"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bán Hàng</title>
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
            div.customer{
                text-align: center;
                width: 100%;
                padding-top: 5%;
                height: 100px;
                line-height: 30px;
            }
            div.IDproduct{
                text-align: left;
                width: 95%;
                padding: 5% 0% 0% 5%;
                height: 100px;
                line-height: 30px;
            }
            input.addProduct{
                background-color:black;
                color: white;
                width: 25%;
                height: 35px;
                line-height: 35px;
                border: 0px;
                border-radius: 5px;
            }
            input.addProduct:hover{
                font-weight: 800;
            }
            input.information{
                width: 70%;
                height: 30px;
            }
            input.informationProduct{
                width: 50%;
                height: 30px;
            }
            select.informationProduct{
                width: 52%;
                height: 34px;
            }
            input.number{
                width: 10%;
                height: 30px;
            }
            div.submit{
                width: 50%;
                padding: 3% 0%;
                text-align: center;
                box-sizing: border-box;
                float: left;
            }
            input.submit{
                background-color:black;
                color: white;
                width: 80%;
                height: 50px;
                line-height: 50px;
                border: 0px;
                border-radius: 10px;
            }
            input.submit:hover{
                font-weight: 800;
            }

            .tab {
                overflow: hidden;
                border: 1px solid #ccc;
                background-color: #f1f1f1;
            }
            
            .tab button {
              	width:50%;
                height:20px;
                line-height:0px;
                font-size: 15px;
                background-color: inherit;
                float: left;
                border: none;
                outline: none;
                cursor: pointer;
                padding: 14px 16px;
                transition: 0.3s;
            }
            
            .tab button:hover {
                background-color: #ddd;
            }

            .tab button.active {
                background-color: #ccc;
            }

            .tabcontent {
                display: none;
                height: 80px;
                padding: 2px 0px;
                border: 1px solid #ccc;
                border-top: none;
                background-color: #bbb;
            }
            .topright {
                float: right;
                cursor: pointer;
                font-size: 28px;
            }

            .topright:hover {color: red;}
            
            div.center{
                font-size: 20px;
                padding-top: 2%;
                text-align: center;
                width: 100%;
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
                BÁN HÀNG
            </div>
            <div class="main-content">
                <div class="list-product">
                    <%
                        if(session.getAttribute("message")!="" && session.getAttribute("message")!=null){
                    %>
                    <script>
                        alert("<%= session.getAttribute("message")%>");
                    </script>
                    <%        
                        }
                    %>
                    <%
                        DonHang donhang =(DonHang) session.getAttribute("order");
                        if(donhang==null){
                            out.println("chưa chọn sản phẩm nào");
                        }    
                        else{
                            List<MatHang> DanhSachMatHang=donhang.getDanhSachMatHang();
                    %>
                    <table border="1px solid" colspan="1px" width="100%">
                        <tr>
                            <th>số thứ tự</th>
                            <th>mã sản phẩm</th>
                            <th>tên sản phẩm</th>
                            <th>số lượng</th>
                            <th>giá bán</th>
                            <th>thành tiền</th>
                            <th></th>
                        </tr>
                            <%
                                int i=1;
                                for(MatHang mathang: DanhSachMatHang){
                            %>
                            <tr style="text-align: center;">
                                <td><%= i++%></td>
                                <td><%= mathang.getMaMatHang() %></td>
                                <td><%= mathang.getSanPham().getTenSanPham() %></td>
                                <td><%= mathang.getSoLuong() %></td>
                                <td><%= mathang.getGiaBan() %></td>
                                <td><%= mathang.getGiaBan()*mathang.getSoLuong() %></td>
                                <td><a href="XoaSanPhamTuDonHangController?value=<%= mathang.getMaMatHang()%>"><img src="image/rubbish.png" width="20px" height="20px"></a></td>
                            </tr>
                            <%
                                }
                                session.setAttribute("order", donhang);
                            }
                            %>
                    </table>
                </div>
                <div class="count">
                    <div class="center">THÔNG TIN ĐƠN HÀNG</div>
                    <div class="count-left">
                        Số lượng mặt hàng
                    </div>
                    <div class="count-right">
                        <%
                            if(donhang!=null){
                                out.println(donhang.getQuantityProduct());
                            }
                            else{
                                out.println("0");
                            }
                        %>
                    </div>
                    <div class="count-left">
                        Thuế VAT
                    </div>
                    <div class="count-right">
                        <%
                            if(donhang!=null){
                                out.println(donhang.getTax());
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
                            if(donhang!=null){
                                out.println(donhang.getDiscount());
                            }
                            else{
                                out.println("0");
                            }
                        %>
                    </div>
                    <div class="count-left">
                        TỔNG CỘNG
                    </div>
                    <div class="count-right">
                        <%
                            if(donhang!=null){
                                out.println(donhang.getTotalAfterDiscount());
                            }
                            else{
                                out.println("0");
                            }
                        %>
                    </div>
                    <hr>
                    <div class="center">THÔNG TIN SẢN PHẨM</div><br>
                    <div class="tab">
                        <button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen"><b>Nhập</b></button>
                        <button class="tablinks" onclick="openCity(event, 'Paris')"><b>Chọn</b></button>
                    </div>

                    <div id="London" class="tabcontent">
                        <div class="IDproduct">
                            <form style="padding-top:5%;" action="ThemSanPhamVaoDonHangController" method="post">
                                <input class="informationProduct" type="text" name="IDProduct" value="" placeholder="nhập mã sản phẩm" required>
                                <input class="number" type="number" name="NumberProduct" value="1">
                                <input class="addProduct" type="submit" name="addProduct" value="THÊM">
                            </form>
                        </div>
                    </div>

                    <div id="Paris" class="tabcontent">
                        <div class="IDproduct">
                            <form style="padding-top:5%;" action="ThemSanPhamVaoDonHangController" method="post">
                                <select class="informationProduct" name="IDProduct">
                                    <%
                                        SanPhamDAO productDao=new SanPhamDAO();
                                        List<SanPham> list=productDao.getAllProduct();
                                        for(SanPham product: list){
                                    %>
                                    <option value="<%=product.getMaSanPham()%>"><%=product.getMaSanPham()%>-<%=product.getTenSanPham()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                                <input class="number" type="number" name="NumberProduct" value="1">
                                <input class="addProduct" type="submit" name="addProduct" value="THÊM">
                            </form>
                        </div>
                    </div>
                    
                    <hr>
                    <form action="ThemHoaDonController" method="post">
                        <div class="customer">
                                THÔNG TIN KHÁCH HÀNG
                                <input class="information" type="text" name="numberPhoneCustomer" value="" placeholder="nhập số điện thoại khách hàng">
                        </div>
                        <div class="submit">
                                <input class="submit" type="submit" name="pay" value="THANH TOÁN">
                        </div>
                    </form>

                    <div class="submit">
                        <form action="HuyDonHangController" method="post">
                            <input class="submit" type="submit" name="cancel" value="HỦY PHIẾU">
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
        <script>
            function openCity(evt, cityName) {
                var i, tabcontent, tablinks;
                tabcontent = document.getElementsByClassName("tabcontent");
                for (i = 0; i < tabcontent.length; i++) {
                  tabcontent[i].style.display = "none";
                }
                tablinks = document.getElementsByClassName("tablinks");
                for (i = 0; i < tablinks.length; i++) {
                  tablinks[i].className = tablinks[i].className.replace(" active", "");
                }
                document.getElementById(cityName).style.display = "block";
                evt.currentTarget.className += " active";
            }

              // Get the element with id="defaultOpen" and click on it
            document.getElementById("defaultOpen").click();
        </script>
    </body>
</html>
