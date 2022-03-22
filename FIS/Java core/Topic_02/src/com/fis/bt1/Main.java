package com.fis.bt1;

public class Main {
    public static void main(String[] args) {
        SinhVien sinhVien = new SinhVien("SV01", "Nguyen Duy Quoc");
        sinhVien.themDiem(new Diem(new MonHoc("Ly", 2, 3), 7));
        sinhVien.themDiem(new Diem(new MonHoc("Ly", 2, 3), 7));
        sinhVien.themDiem(new Diem(new MonHoc("Hoa", 2, 3), 9));
        sinhVien.themDiem(new Diem(new MonHoc("Hoa", 2, 3), 9));
        sinhVien.themDiem(new Diem(new MonHoc("Toan", 2, 3), 9));
        sinhVien.tinhDiemTrungBinh();
//        sinhVien.bangDiem();
////        System.out.println("a");
////        System.out.println("b");
//        String s = new String("Quoc");
//        String i = new String("Nguyen");
//        String o = new String("Duy");
//        System.out.printf("%-20s %-30s %-15s", s, i, o  );
        System.out.println(sinhVien.bangDiem());
    }
}
