/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExcelWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import suabaphoian.NhanVien;
import suabaphoian.SoThuChi;

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
    public static void ghifileexle(int thang,String linkfile,String ghichu) throws FileNotFoundException, IOException{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employees sheet");
        SoThuChi stc=new SoThuChi();
        List<SoThuChi> list=stc.getThuChiTheoThang(thang,ghichu);
        
        int rownum = 0;
        Cell cell;
        Row row;
        Row row1;
        
        HSSFCellStyle style = createStyleForTitle(workbook);
        row = sheet.createRow(rownum);
        
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Tên Khoản Thu ");
        cell.setCellStyle(style);
        
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Nhân Viên Thu ");
        cell.setCellStyle(style);
        
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Số Tiền ");
        cell.setCellStyle(style);
        
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Ghi Chú ");
        cell.setCellStyle(style);
        
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Ngày Tháng ");
        cell.setCellStyle(style);
        
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Tổng Thu ");
        cell.setCellStyle(style);
        
        
        
        //---------data-----------------------------
        // dư liêu trong cơ sơ lieu đươc đưa voà 
        for(SoThuChi s : list){
           rownum++;
           row=sheet.createRow(rownum);
           cell = row.createCell(0, CellType.STRING);
           cell.setCellValue(s.getTenkhoanthuchi());
           
           cell = row.createCell(1, CellType.STRING);
           NhanVien nv=new NhanVien(s.getManv());
           cell.setCellValue(nv.getTennv());
           
           cell = row.createCell(2, CellType.STRING);
           cell.setCellValue(s.getSotien());
           
           cell = row.createCell(3, CellType.STRING);
           cell.setCellValue(s.getGhichu());
           
           cell = row.createCell(4, CellType.STRING);
           cell.setCellValue(s.getNgay().toString());
        }
        row1 = sheet.createRow(1);
        cell = row1.createCell(6, CellType.FORMULA);
        cell.setCellFormula("SUM(C2:C"+(list.size()+2)+")");
        
        File file=new File(linkfile);
        file.getParentFile().mkdirs();
 
        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
        
    }
    
}
