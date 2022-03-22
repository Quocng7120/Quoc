package com.fis.bt2;

import java.util.ArrayList;
import java.util.List;

public class Diem {
    private MonHoc monHoc;
    //Phan tu dau tien trong dsDiem la diem lan 1;
    //Phan tu thu hai trong dsDiem la diem lan 2;
    //Phan tu thu ... trong dsDiem la diem lan ...;
    private List<Double> dsDiem = new ArrayList<Double>();

    public Diem(MonHoc monHoc, Double diemLan1) {
        this.monHoc = monHoc;
        this.dsDiem.add(diemLan1);
    }

    public boolean addDiem(Double diem){
        return this.dsDiem.add(diem);
    }

    //Xem ky dinh nghia giong nhau
    public boolean equals(Object that){
        if(that == null) return false;
        if (!(that instanceof Diem))
            return false;
        Diem thatMonHoc = (Diem) that;
        return this.monHoc.equals(thatMonHoc.monHoc);
    }

    public boolean isMonHoc(MonHoc monHoc) {
        return this.monHoc.equals(monHoc);
    }

    public double getDiemCuoiCung() {
        return this.dsDiem.get(this.dsDiem.size() - 1);
    }
}
