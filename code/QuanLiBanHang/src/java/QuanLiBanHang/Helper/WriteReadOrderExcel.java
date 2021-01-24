package QuanLiBanHang.Helper;

import QuanLiBanHang.model.ChiTietHoaDon;
import QuanLiBanHang.model.ListStasticOrder;
import QuanLiBanHang.model.StasticOrder;
import static com.itextpdf.kernel.pdf.PdfName.Row;
import com.itextpdf.layout.element.Cell;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.export.tabulator.Row;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class WriteReadOrderExcel {
    private static XSSFCellStyle createStyleForTitle(XSSFWorkbook workbook) {
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
    
    public static void WriteOrderExcel(String fileName, List<StasticOrder> liststasticorder) throws FileNotFoundException, IOException{
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Order sheet");
            
            int rownum = 0;
            
            XSSFCell cell;
            XSSFRow row;
            XSSFCellStyle style = createStyleForTitle(workbook);
            row = sheet.createRow(rownum);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("OrderId");
            cell.setCellStyle(style);
            
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("EmployeeId");
            cell.setCellStyle(style);
            
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("CustomerId");
            cell.setCellStyle(style);
            
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("ProductId");
            cell.setCellStyle(style);
            
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Quantity");
            cell.setCellStyle(style);
            
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Price");
            cell.setCellStyle(style);
            
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Total Amount");
            cell.setCellStyle(style);
            
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("VAT");
            cell.setCellStyle(style);
            
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Discount");
            cell.setCellStyle(style);
            
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Total");
            cell.setCellStyle(style);
            
            for (StasticOrder StaOr : liststasticorder) {
                for(int i=0;i<StaOr.getList().size();i++){
                    rownum++;
                    row = sheet.createRow(rownum);
                    if(i==0){
                        cell = row.createCell(0, CellType.NUMERIC);
                        cell.setCellValue(StaOr.getMaHoaDon());
                        
                        cell = row.createCell(1, CellType.NUMERIC);
                        cell.setCellValue(StaOr.getMaNhanVien());
                        
                        cell = row.createCell(2, CellType.NUMERIC);
                        cell.setCellValue(StaOr.getMaKhachHang());
                    }
                    else{
                        cell = row.createCell(0, CellType.STRING);
                        cell.setCellValue("");
                        
                        cell = row.createCell(1, CellType.STRING);
                        cell.setCellValue("");
                        
                        cell = row.createCell(2, CellType.STRING);
                        cell.setCellValue("");
                    }
                    
                    cell = row.createCell(3, CellType.NUMERIC);
                    cell.setCellValue(StaOr.getList().get(i).getMaSanPham());

                    cell = row.createCell(4, CellType.NUMERIC);
                    cell.setCellValue(StaOr.getList().get(i).getSoLuong());

                    cell = row.createCell(5, CellType.NUMERIC);
                    cell.setCellValue(StaOr.getList().get(i).getGiaBan());

                    cell = row.createCell(6, CellType.NUMERIC);
                    cell.setCellValue(StaOr.getList().get(i).countTotalOrderDetail());
                    
                    if(i==0){
                        cell = row.createCell(7, CellType.NUMERIC);
                        cell.setCellValue(StaOr.getThueVAT());
                        
                        cell = row.createCell(8, CellType.NUMERIC);
                        cell.setCellValue(StaOr.getGiamGia());
                        
                        cell = row.createCell(9, CellType.NUMERIC);
                        cell.setCellValue(StaOr.countTotalOnOrder());
                    }
                    else{
                        cell = row.createCell(7, CellType.STRING);
                        cell.setCellValue("");
                        
                        cell = row.createCell(8, CellType.STRING);
                        cell.setCellValue("");
                        
                        cell = row.createCell(9, CellType.STRING);
                        cell.setCellValue("");
                    }
                }
            }
            
            rownum++;
            
            ListStasticOrder list=new ListStasticOrder(liststasticorder);
            
            rownum++;
            row = sheet.createRow(rownum);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Amount Order");
            cell.setCellStyle(style);
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(liststasticorder.size());
            
            rownum++;
            row = sheet.createRow(rownum);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Amount Customer");
            cell.setCellStyle(style);
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(list.countCustomerListOrder());
            
            rownum++;
            row = sheet.createRow(rownum);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Amount Item");
            cell.setCellStyle(style);
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(list.countProductListOrder());
            
            rownum++;
            row = sheet.createRow(rownum);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Proceeds");
            cell.setCellStyle(style);
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(list.countTotalListOrder());
            
            rownum++;
            row = sheet.createRow(rownum);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Discount");
            cell.setCellStyle(style);
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(list.countDiscountListOrder());
            
            rownum++;
            row = sheet.createRow(rownum);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Profit");
            cell.setCellStyle(style);
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(list.countProfitListOrder());
            
            File file = new File(fileName);
            file.getParentFile().mkdirs();
            
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            outFile.close();
            System.out.println("Created file: " + file.getAbsolutePath());
        } catch (SQLException ex) {
            Logger.getLogger(WriteReadOrderExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public static List<StasticOrder> ReadFileExcel(String PathFile) throws FileNotFoundException, IOException{
        List<StasticOrder> list=new ArrayList<>();
        int i=-1;
        FileInputStream inputStream = new FileInputStream(new File(PathFile));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        
        Iterator<org.apache.poi.ss.usermodel.Row> rowIterator = sheet.iterator();
        rowIterator.next();
        
        while(rowIterator.hasNext()){
            org.apache.poi.ss.usermodel.Row row = rowIterator.next();
            Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator = row.cellIterator();
            
            CellType cellTypeAtFirstCell=row.getCell(0).getCellType();
            org.apache.poi.ss.usermodel.Cell cell;
            if(cellTypeAtFirstCell==NUMERIC){
                StasticOrder order=new StasticOrder();
                list.add(order);
                i++;
                
                list.get(i).setMaHoaDon((int) row.getCell(0).getNumericCellValue());
                list.get(i).setMaNhanVien((int) row.getCell(1).getNumericCellValue());
                list.get(i).setMaKhachHang((int) row.getCell(2).getNumericCellValue());
                list.get(i).setThueVAT((float) row.getCell(7).getNumericCellValue());
                list.get(i).setGiamGia((float) row.getCell(8).getNumericCellValue());
                
                ChiTietHoaDon orderDetail=new ChiTietHoaDon();
                orderDetail.setMaHoaDon(list.get(i).getMaHoaDon());
                orderDetail.setMaSanPham((int) row.getCell(3).getNumericCellValue());
                orderDetail.setSoLuong((int) row.getCell(4).getNumericCellValue());
                orderDetail.setGiaBan((float) row.getCell(5).getNumericCellValue());
                
                list.get(i).getList().add(orderDetail);
            }
            else{
                ChiTietHoaDon orderDetail=new ChiTietHoaDon();
                orderDetail.setMaHoaDon(list.get(i).getMaHoaDon());
                orderDetail.setMaSanPham((int) row.getCell(3).getNumericCellValue());
                orderDetail.setSoLuong((int) row.getCell(4).getNumericCellValue());
                orderDetail.setGiaBan((float) row.getCell(5).getNumericCellValue());
                
                list.get(i).getList().add(orderDetail);
            }
            
        }
        return list;
    }
    
    public static void main(String[] argc) throws IOException{
        /*List<StasticOrder> list = ReadFileExcel();
        System.err.println(list.size());
        for(StasticOrder l:list){
            System.err.print(l.getMaHoaDon()+" ");
            System.err.print(l.getMaNhanVien()+" ");
            System.err.print(l.getMaKhachHang()+" ");
            System.err.print(l.getList().get(0).getMaSanPham()+" ");
            System.err.print(l.getList().get(0).getSoLuong()+" ");
            System.err.print(l.getList().get(0).getGiaBan()+" ");
            System.err.print(l.getList().get(0).getGiaBan()*l.getList().get(0).getSoLuong()+" ");
            System.err.print(l.getThueVAT()+" ");
            System.err.print(l.getGiamGia()+" ");
            System.err.println("\n");
            for(ChiTietHoaDon orderDetail: l.getList()){
                System.err.print(orderDetail.getMaHoaDon()+" ");
                System.err.print(orderDetail.getMaSanPham()+" ");
                System.err.print(orderDetail.getSoLuong()+" ");
                System.err.print(orderDetail.getGiaBan()+" ");
                System.err.print(orderDetail.getGiaBan()*orderDetail.getSoLuong()+" ");
                System.err.println("\n");
            }
        }*/
    }
}
