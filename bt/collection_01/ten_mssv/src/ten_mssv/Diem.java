package ten_mssv;

public class Diem {
  private MonHoc mon;
  private int diem;

  public Diem(MonHoc mon, int diem){
    this.mon = mon;
    this.diem = diem;
  }

  public boolean equals(Object that){
    // Hai diem duoc goi la bang nhau neu cua cung mot mon
    if( that instanceof Diem){
      return this.mon.equals(((Diem)that).mon);
    }
    return false;
  }
}
