package com.fis.bt1;

import java.io.Serializable;
import java.util.Objects;

public class Diem implements Comparable<Diem>, Serializable {
  private MonHoc mon;
  private int diem;

  public Diem(MonHoc mon, int diem){
    this.mon = mon;
    this.diem = diem;
  }

  public int getDiem() {
    return diem;
  }

  public MonHoc getMon() {
    return mon;
  }

//  public boolean equals(Object that){
//    // Hai diem duoc goi la bang nhau neu cua cung mot mon
//    if( that instanceof Diem){
//      return this.mon.equals(((Diem)that).mon);
//    }
//    return false;
//  }

  @Override
  public int compareTo(Diem o) {
    return 0;
  }

//  @Override
//  public int hashCode() {
//    return 1;
//  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Diem diem1 = (Diem) o;
    return diem == diem1.diem && Objects.equals(mon, diem1.mon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mon, diem);
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
