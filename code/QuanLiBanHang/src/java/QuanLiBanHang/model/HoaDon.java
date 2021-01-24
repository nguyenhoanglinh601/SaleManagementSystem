package QuanLiBanHang.model;

import com.itextpdf.text.Document;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Hashtable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.jasper.el.JasperELResolver;

public class HoaDon implements Serializable{
    private int MaHoaDon;
    private int MaKhachHang;
    private int MaNhanVien;
    private float ThueVAT;
    private float GiamGia;
    private String ThoiGianBan;

    public HoaDon() {
    }

    public HoaDon(int MaHoaDon, int MaKhachHang, int MaNhanVien, float ThueVAT, float GiamGia, String ThoiGianBan) {
        this.MaHoaDon = MaHoaDon;
        this.MaKhachHang = MaKhachHang;
        this.MaNhanVien = MaNhanVien;
        this.ThueVAT = ThueVAT;
        this.GiamGia = GiamGia;
        this.ThoiGianBan = ThoiGianBan;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public float getThueVAT() {
        return ThueVAT;
    }

    public void setThueVAT(float ThueVAT) {
        this.ThueVAT = ThueVAT;
    }

    public float getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(float GiamGia) {
        this.GiamGia = GiamGia;
    }

    public String getThoiGianBan() {
        return ThoiGianBan;
    }

    public void setThoiGianBan(String ThoiGianBan) {
        this.ThoiGianBan = ThoiGianBan;
    }
    
    public void XuatHoaDon() throws FileNotFoundException{
/*        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        try {

            // Tạo đối tượng PdfWriter
            PdfWriter.getInstance(document, new FileOutputStream("C:\\test\\"+MaHoaDon+".pdf"));

            // Mở file để thực hiện ghi
            document.open();
            
            Font font = FontFactory.getFont("/fonts/VNI-Times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f,Font.NORMAL, BaseColor.BLACK);
            BaseFont baseFont = font.getBaseFont();
            
            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC);
            PdfPCell pdfWordCell = new PdfPCell();
            // Thêm nội dung sử dụng add function
            Paragraph title = new Paragraph("Hóa Đơn Mua Hàng", baseFont);
            document.add(new Paragraph(title));
            document.add(new Paragraph("Hóa Đơn Mua Hàng"));
            document.add(new Paragraph(""));
            document.add(new Paragraph("Mã hóa đơn: "+getMaHoaDon()));
            document.add(new Paragraph("Mã nhân viên: "+getMaNhanVien()));
            document.add(new Paragraph("Mã khách hàng: "+getMaKhachHang()));
            document.add(new Paragraph("Thời gian: "+getThoiGianBan()));

            Anchor anchorTarget = new Anchor("First page of the document.");
            anchorTarget.setName("BackToTop");
            document.add(anchorTarget);

            // Đóng File
            document.close();
            System.out.println("Write file succes!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
*/

/*        try {
            String k1 = "<html>"
                        + "<body>"
                            +"<div style=\"width: 100%; text-align: center; font-size: 20px;\">CUA HANG THIET BI DIEN TU KIM LONG</div>"
                            +"<div style=\"width: 100%; text-align: center; font-size: 20px;\">212 Nguyen Son, P.Phu Thanh, Q.Tan Phu, Tp.Ho Chi Minh</div>"
                            +"<div style=\"width: 100%; text-align: center; font-size: 20px;\">SDT: 0969076447</div>"
                            +"<hr style=\"width: 50%; text-align: center;\">"
                            +"<div style=\"width: 100%; text-align: center; font-size: 30px; font-weight: 600;\">HOA DON MUA HANG</div>";
                        +" </body>"
                        + "</html>";
                String k3 =  "<div style=\"margin: 3% 25% 0% 25%; font-size: 20px;\">"
                                +"<div style=\"width: 50%; float: left;\">"
                                    +"Ma hoa don:<br>"
                                    +"Ma nhan vien: <br>"
                                +"</div>";
                String k4 =     "<div style=\"width: 50%; float: left;\">"
                                    +"Ma khach hang: <br>"
                                    +"Thoi gian: <br>"
                                +"</div>";
                String k5 =     "<table border=\"1px solid\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; \">"
                                    +"<tr>"
                                        +"<th>STT</th>"
                                        +"<th>Ma san pham</th>"
                                        +"<th>So luong</th>"
                                        +"<th>Don gia</th>"
                                        +"<th>Thanh tien</th>"
                                    +"</tr>"
                                +"</table>";
                String k6 =     "<br>"
                                +"<div style=\"width: 50%; float: left;\">Tong so:</div>"
                                +"<div style=\"width: 50%; float: left;\">Tong cong:</div>"
                                +"<br><br>"
                                +"<div style=\"font-style: italic; text-align: center;\">CAM ON QUY KHACH</div>"
                            +"</div>"
                        + " </body>"
                    + "</html>";
            OutputStream file = new FileOutputStream(new File("C:\\test\\Test.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(k1));
            document.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

*/
/*        String link="C:\\Users\\user\\Documents\\NetBeansProjects\\QuanLiBanHang\\src\\java\\QuanLiBanHang\\GUI\\HoaDon.jrxml";
        
        Class.forName("com.mysql.jdbc.Driver");
        String database="jdbc:mysql://localhost:3306/quanlibanhang";
        String us="root";
        String pa="";
        Connection con=DriverManager.getConnection(database,us,pa);
        JasperReport jr= JasperCompileManager.compileReport(link);
        JasperPrint jp=JasperFillManager.fillReport(jr, null, con);
        JasperViewer.viewReport(jp);
*/
/*        Class.forName("com.mysql.jdbc.Driver");
        String database="jdbc:mysql://localhost:3306/quanlibanhang";
        String us="root";
        String pa="";
        Connection con=DriverManager.getConnection(database,us,pa);

        Hashtable map=new Hashtable();
        JasperReport report= JasperCompileManager.compileReport("C:\\Users\\user\\Documents\\NetBeansProjects\\QuanLiBanHang\\src\\java\\QuanLiBanHang\\GUI\\HoaDon.jrxml");
        map.put("MaHoaDon", getMaHoaDon());
        JasperPrint p=JasperFillManager.fillReport(report, map, con);
        JasperViewer.viewReport(p,false);
*/

        PrintWriter printWriter = new PrintWriter("C:\\test\\thu.txt");
        printWriter.println("                 CUA HANG THIET BI DIEN TU KIM LONG");
        printWriter.println("      212 Nguyen Son, P.Phu Thanh, Q.Tan Phu, Tp.Ho Chi Minh");
        printWriter.println("                         SDT: 0969076447");
        printWriter.println("\n");
        printWriter.println("                         HOA DON MUA HANG");
        printWriter.println("\n");
        printWriter.println("       Ma hoa don:                 Ma khach hang:");
        printWriter.println("       Ma nhan vien:               Thoi gian:");
        printWriter.println("\n");
        printWriter.println("       STT     MaSP    TenSp   Soluong    Giaban     Thanhtien");
        printWriter.close();
    }
}
