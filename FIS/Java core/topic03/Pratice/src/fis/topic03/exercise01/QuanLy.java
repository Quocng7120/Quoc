package fis.topic03.exercise01;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.util.CellReference;

public class QuanLy {
	public List<TaiKhoan> readListTK() {
		ArrayList<TaiKhoan> listTK=new ArrayList<TaiKhoan>();
		try (FileInputStream file = new FileInputStream(new File("C:/Users/ThanhTran/Desktop/TaiKhoan.xlsx"));) {
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(0);
			int dem=-1;
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				dem++;
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				
				TaiKhoan taiKhoan=new TaiKhoan();
				DataFormatter formatter = new DataFormatter();
				taiKhoan.setId(Integer.parseInt( formatter.formatCellValue(sheet.getRow(dem).getCell(0)))) ;
				taiKhoan.setSoTaiKhoan(formatter.formatCellValue(sheet.getRow(dem).getCell(1))) ;
				taiKhoan.setMatKhau(formatter.formatCellValue(sheet.getRow(dem).getCell(2))) ;
				listTK.add(taiKhoan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTK;
	}
	public List<GiaoDich> readListGD() {
		ArrayList<GiaoDich> listGD=new ArrayList<GiaoDich>();
		try (FileInputStream file = new FileInputStream(new File("C:/Users/ThanhTran/Desktop/TaiKhoan.xlsx"));) {
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(1);
			int dem=-1;
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				dem++;
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				
				GiaoDich giaoDich=new GiaoDich();
				DataFormatter formatter = new DataFormatter();
				giaoDich.setId(Integer.parseInt( formatter.formatCellValue(sheet.getRow(dem).getCell(0)))) ;
				giaoDich.setSoTaiKhoanGui(formatter.formatCellValue(sheet.getRow(dem).getCell(1))) ;
				giaoDich.setSoTaiKhoanNhan(formatter.formatCellValue(sheet.getRow(dem).getCell(2))) ;
				giaoDich.setSoTien(Double.parseDouble(formatter.formatCellValue(sheet.getRow(dem).getCell(3))));
				String stringDate = formatter.formatCellValue(sheet.getRow(dem).getCell(4));
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
				giaoDich.setNgayGui(date) ;
				giaoDich.setNoiDung(formatter.formatCellValue(sheet.getRow(dem).getCell(5)));
				listGD.add(giaoDich);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listGD;
	}
	public boolean checkTaiKhoan(String name ,String pass) {
		List<TaiKhoan> listTK=readListTK();
		for(TaiKhoan t:listTK) {
			if(t.getSoTaiKhoan().equals(name)&&t.getMatKhau().equals(pass)) return true;
		}
		return false;
	}
	public List<GiaoDich> chechkGiaoDich(String STKGui,String STKNhan,String noiDung,double soTien){
		List<GiaoDich> listGD=readListGD();
		List<GiaoDich> list=new ArrayList<GiaoDich>();
		for(GiaoDich g:listGD) {
			if(g.getSoTaiKhoanNhan().equals(STKNhan)&&g.getSoTaiKhoanGui().equals(STKGui)&&g.getNoiDung().equals(noiDung)&&g.getSoTien()==soTien) {
				list.add(g);
			}
		}
		return list;
	}

}
