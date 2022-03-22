package fis.topic03.exercise02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class QuanLyCauHoi {
	private List<CauHoi> listCauHoi=new ArrayList<CauHoi>();
	
	public QuanLyCauHoi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<CauHoi> getListCauHoi() {
		return listCauHoi;
	}
	public void setListCauHoi(List<CauHoi> listCauHoi) {
		this.listCauHoi = listCauHoi;
	}
	public void addCauHoi(CauHoi cauHoi) {
		listCauHoi.add(cauHoi);
	}
	public List<CauHoi> checkTuongDong(String s) {
		String[] list=s.split(" ");
		for(CauHoi c:listCauHoi) {
			int dem=0;
			for (int i = 0; i < list.length; i++) {
				if(c.getCauHoi().contains(list[i])) dem++; 
			}
			c.setDoTuongDong(dem);
		}
		Collections.sort(listCauHoi);
		if(listCauHoi.size()<=5) return listCauHoi;
		List<CauHoi> kq=new ArrayList<CauHoi>();
		for (int i = 0; i < 5; i++) {
			kq.add(listCauHoi.get(i));
		}
		return kq;	
	}
}
