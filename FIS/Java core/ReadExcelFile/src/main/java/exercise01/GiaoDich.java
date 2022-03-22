package exercise01;

import java.util.Date;

public class GiaoDich {
	private int id;
	private String soTaiKhoanGui;
	private String soTaiKhoanNhan;
	private double soTien;
	private Date ngayGui;
	private String noiDung;
	public GiaoDich() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GiaoDich(int id, String soTaiKhoanGui, String soTaiKhoanNhan, double soTien, Date ngayGui, String noiDung) {
		super();
		this.id = id;
		this.soTaiKhoanGui = soTaiKhoanGui;
		this.soTaiKhoanNhan = soTaiKhoanNhan;
		this.soTien = soTien;
		this.ngayGui = ngayGui;
		this.noiDung = noiDung;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSoTaiKhoanGui() {
		return soTaiKhoanGui;
	}
	public void setSoTaiKhoanGui(String soTaiKhoanGui) {
		this.soTaiKhoanGui = soTaiKhoanGui;
	}
	public String getSoTaiKhoanNhan() {
		return soTaiKhoanNhan;
	}
	public void setSoTaiKhoanNhan(String soTaiKhoanNhan) {
		this.soTaiKhoanNhan = soTaiKhoanNhan;
	}
	public double getSoTien() {
		return soTien;
	}
	public void setSoTien(double soTien) {
		this.soTien = soTien;
	}
	public Date getNgayGui() {
		return ngayGui;
	}
	public void setNgayGui(Date ngayGui) {
		this.ngayGui = ngayGui;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	
	
}
