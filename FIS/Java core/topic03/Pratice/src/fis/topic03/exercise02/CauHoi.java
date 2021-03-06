package fis.topic03.exercise02;

public class CauHoi implements Comparable<CauHoi>{
	private int id;
	private String cauHoi;
	private String cauTraLoi;
	private int doTuongDong;
	
	public CauHoi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CauHoi(int id, String cauHoi, String cauTraLoi) {
		super();
		this.id = id;
		this.cauHoi = cauHoi;
		this.cauTraLoi = cauTraLoi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCauHoi() {
		return cauHoi;
	}
	public void setCauHoi(String cauHoi) {
		this.cauHoi = cauHoi;
	}
	public String getCauTraLoi() {
		return cauTraLoi;
	}
	public void setCauTraLoi(String cauTraLoi) {
		this.cauTraLoi = cauTraLoi;
	}
	public int getDoTuongDong() {
		return doTuongDong;
	}
	public void setDoTuongDong(int doTuongDong) {
		this.doTuongDong = doTuongDong;
	}
	@Override
	public int compareTo(CauHoi o) {
		// TODO Auto-generated method stub
		return o.getDoTuongDong()-this.getDoTuongDong();
	}
	
}
