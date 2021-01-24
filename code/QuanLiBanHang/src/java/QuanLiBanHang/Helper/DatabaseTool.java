/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HocIT
 */
public class DatabaseTool {
    public static Connection connect() throws Exception{
        String DB_URL = "jdbc:mysql://localhost:3306/quanlibanhang?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String USER_NAME = "root";
        String PASSWORD = ""; 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
        return con;                    
    }      
}
