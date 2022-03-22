package com.fis.bt2;

import java.util.ArrayList;
import java.util.List;

public class PhieuTongKet {
    private List<IXe> xeGui = new ArrayList<>();

    public void addNewXe(){
//        Viết Phương thức thêm xe, phân biệt xe đạp hay xe máy bằng if-else
    }

    public int soXeGui(){
        return this.xeGui.size();
    }

    public double tienGiuXe(){
        double tongTien=0;
        for (IXe xe: this.xeGui) {
            tongTien+=xe.getPrice();
        }
        return tongTien;
    }

    public double tienLai(){
        double tienLai=0;
        tienLai = this.tienGiuXe();
        tienLai -= this.tienGiuXe()/10;
        tienLai -= this.soXeGui()*100;
        return tienLai;
    }
}
