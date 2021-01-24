/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Helper;


import QuanLiBanHang.DAO.KhachHangDAO;
import QuanLiBanHang.model.KhachHang;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author mac
 */
public class ReadWriteKhachHangExcel {
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static void writeFileExcel(String filename) throws FileNotFoundException, IOException, SQLException, Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        
        //Tạo sheet chứa bảng
        HSSFSheet sheet = workbook.createSheet("KhachHang sheet");
        
        //tạo thưc thể sothuchi chứa bản
        KhachHangDAO dao=new KhachHangDAO();
        
        //tạo danh sách sothuchi
        List<KhachHang> list2=dao.findAll();
        
        int rownum = 0;
        Cell cell;
        Row row;

        
        HSSFCellStyle style = createStyleForTitle(workbook);
        row = sheet.createRow(rownum);
        
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Mã Khách Hàng ");
        cell.setCellStyle(style);
        
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên Khách Hàng ");
        cell.setCellStyle(style);
        
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("SDT ");
        cell.setCellStyle(style);
        
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Địa Chỉ ");
        cell.setCellStyle(style);
        
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Email ");
        cell.setCellStyle(style);
        
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Điểm ");
        cell.setCellStyle(style);
        
        
        //---------data-----------------------------
        // dư liêu trong cơ sơ lieu đươc đưa voà 
        for(KhachHang Kh : list2){
           rownum++;
           row=sheet.createRow(rownum);
           cell = row.createCell(0, CellType.NUMERIC);
           cell.setCellValue(Kh.getMaKhachHang() );
           
           cell = row.createCell(1, CellType.STRING);
           cell.setCellValue(Kh.getTenKhachHang());
           
           cell = row.createCell(2, CellType.NUMERIC);
           cell.setCellValue(Kh.getSDT());
           
           cell = row.createCell(3, CellType.NUMERIC);
           cell.setCellValue(Kh.getDiaChi());
           
           cell = row.createCell(4, CellType.STRING);
           cell.setCellValue(Kh.getEmail());
           
           cell = row.createCell(5, CellType.STRING);
           cell.setCellValue(Kh.getDiem());
           
        }        
        File file=new File(filename);
        file.getParentFile().mkdirs();
 
        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
        
    }
    
    
    
    
    
    
    
    
    
    
    public static ArrayList<KhachHang> readFileExcel(String filename) throws IOException {
  
        ArrayList<KhachHang> list=new ArrayList<>();
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
            KhachHang Kh=new KhachHang();
            while (cellIterator.hasNext()) {
               if(i==-1){
                i++;
                break;
               }
               Cell cell;
                cell = cellIterator.next();
               CellType cellType = cell.getCellType();
            if(cellType==NUMERIC){
                Kh.setMaKhachHang((int) row.getCell(0).getNumericCellValue());
                Kh.setTenKhachHang((String) row.getCell(1).getStringCellValue());
                Kh.setSDT((String) row.getCell(2).getStringCellValue());
                Kh.setDiaChi((String) row.getCell(3).getStringCellValue());
                Kh.setEmail((String) row.getCell(4).getStringCellValue());
                Kh.setDiem((int) row.getCell(5).getNumericCellValue());
            }      
        }
        list.add(Kh);
       }
       return list;
   }
 
}

