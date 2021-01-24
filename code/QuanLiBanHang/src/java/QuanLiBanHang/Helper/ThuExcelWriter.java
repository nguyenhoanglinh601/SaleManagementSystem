/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Helper;

import QuanLiBanHang.DAO.SanPhamDAO;
import QuanLiBanHang.DAO.SanPhamDAO;
import QuanLiBanHang.model.SanPham;
import QuanLiBanHang.model.SanPham;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author mac
 */
public class ThuExcelWriter {
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
    
    
    
    
    
    
    
    
    
    public static void ghifileexle(String filename) throws FileNotFoundException, IOException, SQLException{
        
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        
        //Tạo sheet chứa bảng
        HSSFSheet sheet = workbook.createSheet("SanPham1 sheet");
        
        //tạo thưc thể sothuchi chứa bản
        SanPhamDAO dao=new SanPhamDAO();
        
        //tạo danh sách sothuchi
        List<SanPham> list2=dao.getAllSanPham();
        
        int rownum = 0;
        Cell cell;
        Row row;

        
        HSSFCellStyle style = createStyleForTitle(workbook);
        row = sheet.createRow(rownum);
        
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Mã Sản Phẩm ");
        cell.setCellStyle(style);
        
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên Sản Phẩm ");
        cell.setCellStyle(style);
        
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Gía Bán ");
        cell.setCellStyle(style);
        
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Gía Nhập ");
        cell.setCellStyle(style);
        
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Ngày Nhập ");
        cell.setCellStyle(style);
        
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Loại ");
        cell.setCellStyle(style);
        
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Nhà Cung Cấp ");
        cell.setCellStyle(style);
        
         cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Số Lượng ");
        cell.setCellStyle(style);
        
        
        
        //---------data-----------------------------
        // dư liêu trong cơ sơ lieu đươc đưa voà 
        for(SanPham sp : list2){
           rownum++;
           row=sheet.createRow(rownum);
           cell = row.createCell(0, CellType.NUMERIC);
           cell.setCellValue(sp.getMaSanPham());
           
           cell = row.createCell(1, CellType.STRING);
           cell.setCellValue(sp.getTenSanPham());
           
           cell = row.createCell(2, CellType.NUMERIC);
           cell.setCellValue(sp.getGiaBan());
           
           cell = row.createCell(3, CellType.NUMERIC);
           cell.setCellValue(sp.getGiaNhap());
           
           cell = row.createCell(4, CellType.STRING);
           cell.setCellValue(String.valueOf(sp.getThoiGianNhap()));
           
           cell = row.createCell(5, CellType.STRING);
           cell.setCellValue(sp.getLoai());
           
           cell = row.createCell(6, CellType.NUMERIC);
           cell.setCellValue(sp.getMaNhaCungCap());
           
           cell = row.createCell(7, CellType.NUMERIC);
           cell.setCellValue(sp.getLuongTonKho());
        }        
        File file=new File(filename);
        
 
        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        
    }
    
    
    
    
    
    
    
    
    
    
    public static ArrayList<SanPham> docfileexle(String filename) throws IOException {
  
        ArrayList<SanPham> list=new ArrayList<>();
        int i=-1;
       // Đọc một file XSL.
       FileInputStream inputStream = new FileInputStream(new File(filename));
  
       // Đối tượng workbook cho file XSL.
       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
 
  
       // Lấy ra sheet đầu tiên từ workbook
       HSSFSheet sheet = workbook.getSheetAt(0);
 
  
       // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
       Iterator<Row> rowIterator = sheet.iterator();
 
       while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
     
           // Lấy Iterator cho tất cả các cell của dòng hiện tại.
           Iterator<Cell> cellIterator = row.cellIterator();
            SanPham sp=new SanPham();
            while (cellIterator.hasNext()) {
               if(i==-1){
                i++;
                break;
               }
               Cell cell = cellIterator.next();
               CellType cellType = cell.getCellType();
            if(cellType==NUMERIC){
                sp.setMaSanPham((int) row.getCell(0).getNumericCellValue());
                sp.setGiaBan((int) row.getCell(2).getNumericCellValue());
                sp.setGiaNhap((int) row.getCell(3).getNumericCellValue());
                sp.setLuongTonKho((int) row.getCell(7).getNumericCellValue());
                sp.setMaNhaCungCap((int) row.getCell(6).getNumericCellValue());
            }
            else{
                 sp.setTenSanPham(String.valueOf( row.getCell(1).getStringCellValue()));
                 sp.setThoiGianNhap(Date.valueOf(row.getCell(4).getStringCellValue()));
                 sp.setLoai(String.valueOf(row.getCell(5).getStringCellValue()));    
            }
            
        }
        list.add(sp);
       }
       return list;
   }
 
}

