/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuanLiBanHang.Helper;

import QuanLiBanHang.model.Staff;
import QuanLiBanHang.DAO.StaffDao;
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
 * @author doanv
 */

public class ReadWriteNhanVienExcel {
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
        HSSFSheet sheet = workbook.createSheet("NhanVien Sheet");
        
        //tạo thưc thể sothuchi chứa bản
        StaffDao dao=new StaffDao();
        
        //tạo danh sách sothuchi
        List<Staff> list2=dao.findAll();
        
        int rownum = 0;
        Cell cell;
        Row row;

        
        HSSFCellStyle style = createStyleForTitle(workbook);
        row = sheet.createRow(rownum);
        
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Mã Nhân Viên ");
        cell.setCellStyle(style);
        
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên Nhân Viên ");
        cell.setCellStyle(style);
        
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("SDT ");
        cell.setCellStyle(style);
        
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Địa Chỉ ");
        cell.setCellStyle(style);
        
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Tài Khoản ");
        cell.setCellStyle(style);
        
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Mật Khẩu ");
        cell.setCellStyle(style);
        
        
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Quyền ");
        cell.setCellStyle(style);
        
        //---------data-----------------------------
        // dư liêu trong cơ sơ lieu đươc đưa voà 
        for(Staff staff : list2){
           rownum++;
           row=sheet.createRow(rownum);
           cell = row.createCell(0, CellType.NUMERIC);
           cell.setCellValue(staff.getIdStaff());
           
           cell = row.createCell(1, CellType.STRING);
           cell.setCellValue(staff.getName());
           
           cell = row.createCell(2, CellType.STRING);
           cell.setCellValue(staff.getNumberPhone());
           
           cell = row.createCell(3, CellType.STRING);
           cell.setCellValue(staff.getAddress());
           
           cell = row.createCell(4, CellType.STRING);
           cell.setCellValue(staff.getUsername());
           
           cell = row.createCell(5, CellType.STRING);
           cell.setCellValue(staff.getPassword());
           
           cell = row.createCell(6, CellType.BOOLEAN);
           cell.setCellValue(staff.isAccess());
           
        }        
        File file=new File(filename);
        file.getParentFile().mkdirs();
 
        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
        
    }
    
    
    
    
    
    
    
    
    
    
    public static ArrayList<Staff> readFileExcel(String filename) throws IOException {
  
        ArrayList<Staff> list=new ArrayList<>();
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
            Staff staff=new Staff();
            while (cellIterator.hasNext()) {
               if(i==-1){
                i++;
                break;
               }
               Cell cell;
                cell = cellIterator.next();
               CellType cellType = cell.getCellType();
            if(cellType==NUMERIC){
                staff.setIdStaff((int) row.getCell(0).getNumericCellValue());
                staff.setName((String) row.getCell(1).getStringCellValue());
                staff.setNumberPhone((String) row.getCell(2).getStringCellValue());
                staff.setAddress((String) row.getCell(3).getStringCellValue());
                staff.setUsername((String) row.getCell(4).getStringCellValue());
                staff.setPassword( (String) row.getCell(5).getStringCellValue());
                staff.setAccess((Boolean) row.getCell(6).getBooleanCellValue());
            }      
        }
        list.add(staff);
       }
       return list;
   }
   
 
}


