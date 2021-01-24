package QuanLiBanHang.Helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {
    public static Connection openConnection(){
        Connection conn = null;
        try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlibanhang?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "");
                System.out.println("connect successfully!");
            } catch (Exception ex) {
                System.out.println("connect failure!");
                ex.printStackTrace();
            }
        return conn;
    }
}
