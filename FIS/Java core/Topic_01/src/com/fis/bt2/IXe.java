package com.fis.bt2;

public abstract class IXe {
    protected int soPhieu;
    protected double price;

    public IXe() {
    }

    public IXe(int soPhieu) {
        this.soPhieu = soPhieu;
    }

    public int getSoPhieu() {
        return soPhieu;
    }

    public abstract double getPrice();
}
