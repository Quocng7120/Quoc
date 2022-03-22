package com.fis.bt1;

import java.util.Objects;

public class MonHoc {
  private String ten;
  private int tcLT;
  private int tcTH;

  public MonHoc(String ten, int tcLT, int tcTH){
    this.ten = ten;
    this.tcLT = tcLT;
    this.tcTH = tcTH;
  }

  public String getTen() {
    return ten;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }

  @Override
  public String toString() {
    return "MonHoc{" +
            "ten='" + ten +
            '}';
  }

//  public boolean equals(Object that){
//    //Hai mon duoc goi la bang nhau neu cung ten mon
//    if(that instanceof MonHoc){
//      return ((MonHoc)that).ten.equals(this.ten);
//    }
//    return false;
//  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MonHoc monHoc = (MonHoc) o;
    return tcLT == monHoc.tcLT && tcTH == monHoc.tcTH && Objects.equals(ten, monHoc.ten);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ten, tcLT, tcTH);
  }
}
