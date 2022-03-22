package com.fis.bt2;

import java.util.*;

public class ChuongTrinhHoc {
    private String ten;
    private Calendar ngayDuocDuyet;
    private List<MonHoc> dsMonHoc = new ArrayList<MonHoc>();
    public static ChuongTrinhHoc SINGLETON = new ChuongTrinhHoc("Cong nghe thong tin", new GregorianCalendar(2000,0,1));

    private ChuongTrinhHoc(String ten, Calendar ngayDuocDuyet) {
        this.ten = ten;
        this.ngayDuocDuyet = ngayDuocDuyet;
    }

    public boolean addMonHoc(MonHoc monHoc){
        return this.dsMonHoc.add(monHoc);
    }
    public boolean isMonHoc(MonHoc monHoc){
        for (MonHoc mon:dsMonHoc) {
            if (mon.equals(monHoc)){
                return true;
            }
        }
        return false;
    }
}
