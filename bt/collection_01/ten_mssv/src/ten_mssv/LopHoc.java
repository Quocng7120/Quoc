package ten_mssv;

import java.util.*;

public class LopHoc {
  private String ten;
  private String giaoVien;
  private List<SinhVien> dsLop = new ArrayList<SinhVien>();

  public LopHoc(String ten, String giaoVien){
    this.ten = ten;
    this.giaoVien = giaoVien;
  }

  public boolean them(SinhVien svMoi){
    return dsLop.add(svMoi);
  }

  //Cau 4
  public String inDiem(){
    /*
    Danh Sach Diem Lop : ten
    Giao Vien Chu Nhiem : giaoVien
    STT      MSSV        Ten              Diem TB   XepLoai
    1        123456      Nguyen Van A     8.4       GIOI
    2        678919      Nguyen Van B     6         TB-KHA
    3        112456      Nguyen Van C     7         KHA
    */
    //...
    return null;
  }

  //Cau 5
  public List<SinhVien> top10(){
    //Tra ve danh sach 10 sinh vien co diem trung binh lon nhat lop
    //...
    return null;
  }

  //Cau 6
  public List<SinhVien> sinhVienYeu(){
    //Tra ve danh sach vien vien xep loai YEU
    //...

    return null;
  }
}
