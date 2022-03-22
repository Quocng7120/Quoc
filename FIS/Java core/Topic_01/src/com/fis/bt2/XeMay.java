package com.fis.bt2;

public class XeMay extends IXe {
    private String soXe;

    public XeMay(String soXe) {
        this.soXe = soXe;
    }


    public double getPrice() {
        return Constant.PRICE.XE_MAY;
    }
}
