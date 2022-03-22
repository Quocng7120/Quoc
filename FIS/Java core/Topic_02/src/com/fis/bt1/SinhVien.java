package com.fis.bt1;

import java.util.*;

public class SinhVien {
  private String mssv;
  private String ten;

  private Set<Diem> monDaHoc = new HashSet<Diem>();

  public SinhVien(String mssv, String ten){
    this.mssv = mssv;
    this.ten = ten;
  }

  public String getMssv() {
    return mssv;
  }

  public void setMssv(String mssv) {
    this.mssv = mssv;
  }

  public String getTen() {
    return ten;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }

  @Override
  public String toString() {
    return "MSSV : " + this.mssv + "\n" +
            "TEN  : " + this.ten;
  }

  public boolean themDiem(Diem diemMoi){
    return this.monDaHoc.add(diemMoi);
  }

  //Cau 1
  public double tinhDiemTrungBinh(){
    //Giong nhu cach tinh hien tai cua truong
    OptionalDouble avg;
    avg = monDaHoc.stream()
            .mapToDouble(t -> t.getDiem())
            .average();
    return avg.isPresent() ? avg.getAsDouble() : 0.0;
  }


  //Cau 2
  public String bangDiem(){
    /*
     MSSV : 0203044
     Ten  : Nguyen Van A
     Danh Sach Diem
     STT  Ten Mon            Diem       So Tin Chi
     1    Cau Truc Du Lieu 1  8          3
     2    Cau Truc Du Lieu 2  8          3
     com.fis.bt1.Diem Trung Binh   8.0
    */

    String bangDiem;
    bangDiem = "MSSV : " + mssv.toString() + "\n";
    bangDiem += "Ten :  " + ten.toString() +"\nDanh sach diem \n";
    bangDiem += String.format("%-4s%-20s%-10s%s", "STT", "Ten Mon", "Diem", "So Tin Chi");
    for (Diem diem : monDaHoc) {
      int dem = 1;
      bangDiem += String.format("\n%-4s%-20s%-10s%s", dem, diem.getMon().getTen(), diem.getDiem(), "3");
    }
    bangDiem += "\nTrung Binh" + tinhDiemTrungBinh();


    //...
    return bangDiem;
  }


  //Cau 3
  public String xepLoai(){
    /*
    Quy tac xep loai nhu sau
        DiemTB < 5 -> YEU
        DiemTB >= 5 va DiemTB < 6 -> TB
        DiemTB >= 6 va DiemTB < 7 -> TB-KHA
        DiemTB >= 7 va DiemTB < 8 -> KHA
        DiemTB >= 8 -> GIOI
    */

    //...
    double dtt = this.tinhDiemTrungBinh();
    if(dtt>=8)
    {
      return "GIOI";
    }
    else if(dtt>=7 && dtt<8)
    {
      return "KHA";
    }
    else if(dtt>=6 && dtt<7)
    {
      return "TB-KHA";
    }
    else if(dtt>=5 && dtt<6)
    {
      return "TB";
    }
    else
    {
      return "YEU";
    }
  }

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//    SinhVien sinhVien = (SinhVien) o;
//    return Objects.equals(mssv, sinhVien.mssv) && Objects.equals(ten, sinhVien.ten) && Objects.equals(monDaHoc, sinhVien.monDaHoc);
//  }
//
//  @Override
//  public int hashCode() {
//    return 1;
//  }
}
