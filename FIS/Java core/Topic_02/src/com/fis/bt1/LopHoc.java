package com.fis.bt1;

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

  @Override
  public String toString() {
    return "Danh Sach Diem Lop : " + this.ten + "\n" +
            "Giao Vien Chu Nhiem  : " + this.giaoVien;
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
    this.dsLop.sort(new Comparator<SinhVien>() {
      @Override
      public int compare(SinhVien o1, SinhVien o2) {
        if (o1.tinhDiemTrungBinh() < o2.tinhDiemTrungBinh())
          return -1;
        else if(o1.tinhDiemTrungBinh()== o2.tinhDiemTrungBinh())
          return 0;
        else
          return 1;
      }
    });

    int dem = 0;
    System.out.println(toString());
    System.out.println("STT      MSSV        Ten              Diem TB   XepLoai");
    for (SinhVien sinhvien:dsLop) {
      dem++;
      String mssv = new String(sinhvien.getMssv());
      String tensv = new String(sinhvien.getTen());
      double dtt = sinhvien.tinhDiemTrungBinh();
      String xepLoai = new String(sinhvien.xepLoai());
      System.out.println(dem + "        "+ mssv +"      "+ tensv +"     "+ dtt +"       " + xepLoai);
    }
    //...
    return null;
  }

  //Cau 5
  public List<SinhVien> top10(){
    //Tra ve danh sach 10 sinh vien co diem trung binh lon nhat lop
    //...
    List<SinhVien> top10 = new ArrayList<>();
    this.dsLop.sort(new Comparator<SinhVien>() {
      @Override
      public int compare(SinhVien o1, SinhVien o2) {
        if (o1.tinhDiemTrungBinh() < o2.tinhDiemTrungBinh())
          return -1;
        else if(o1.tinhDiemTrungBinh()== o2.tinhDiemTrungBinh())
          return 0;
        else
          return 1;
      }
    });

    for (int i = 0; i < 10; i++)
    {
      top10.add(this.dsLop.get(i));
    }
    return top10;
  }

  //Cau 6
  public List<SinhVien> sinhVienYeu(){
    //Tra ve danh sach vien vien xep loai YEU
    //...
    List<SinhVien> dsYeu = new ArrayList<>();
    for (SinhVien sinhVien:dsLop) {
      if(sinhVien.xepLoai().equals("YEU"))
        dsYeu.add(sinhVien);
    }
    return dsYeu;
  }
}
