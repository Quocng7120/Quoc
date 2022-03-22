package exercise01;

public class TaiKhoan {
	private int id;
	private String soTaiKhoan;
	private String matKhau;
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(int id, String soTaiKhoan, String matKhau) {
		super();
		this.id = id;
		this.soTaiKhoan = soTaiKhoan;
		this.matKhau = matKhau;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSoTaiKhoan() {
		return soTaiKhoan;
	}
	public void setSoTaiKhoan(String soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	
}
