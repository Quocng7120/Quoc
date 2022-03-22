package com.fis.bt2;

import java.util.*;

public class DataForTest {
    MonHoc ltrA1 = new MonHoc("01","Lap Trinh A1", 3, 2);
    MonHoc ltrA2 = new MonHoc("02","Lap Trinh A2", 3, 2);
    MonHoc ktctri = new MonHoc("03","Kinh te chinh tri", 5, 0);
    MonHoc mmt = new MonHoc("04","Mang May Tinh", 3, 1);
    MonHoc ctdl1 = new MonHoc("05","Cau truc du lieu 1", 3, 2);
    MonHoc ctdl2 = new MonHoc("06","Cau truc du lieu 2", 2, 1);

    SinhVien ntphuoc = new SinhVien("0001", "Nguyen Thanh Phuoc", new BangDiem());
    SinhVien ntphuc = new SinhVien("0001", "Nguyen Thanh Phuc", new BangDiem());
    SinhVien dvhthong = new SinhVien("0001", "Dang Van Hoang Thong", new BangDiem());
    SinhVien tptam = new SinhVien("0001", "Truong Phong Tam", new BangDiem());
    SinhVien ntnguyet = new SinhVien("0001", "Nguyen Thu Nguyet", new BangDiem());
    SinhVien lttloc = new SinhVien("0001", "Lam Tran Thien Loc", new BangDiem());

    public DataForTest(){
        ltrA2.addMonTienQuyet(ltrA1);
        ctdl1.addMonTienQuyet(ltrA2);
        ctdl1.addMonTienQuyet(mmt);
        ctdl2.addMonTienQuyet(ctdl1);

        ChuongTrinhHoc.SINGLETON.addMonHoc(ltrA1);
        ChuongTrinhHoc.SINGLETON.addMonHoc(ltrA2);
        ChuongTrinhHoc.SINGLETON.addMonHoc(ktctri);
        ChuongTrinhHoc.SINGLETON.addMonHoc(mmt);
        ChuongTrinhHoc.SINGLETON.addMonHoc(ctdl1);
        ChuongTrinhHoc.SINGLETON.addMonHoc(ctdl2);

        ntphuoc.getBangDiem().themDiem(new Diem(ltrA1, 4.));
        ntphuoc.getBangDiem().themDiem(new Diem(ktctri, 6.));
        ntphuoc.getBangDiem().themDiem(new Diem(mmt, 7.));

        ntphuc.getBangDiem().themDiem(new Diem(ltrA1, 5.));
        ntphuc.getBangDiem().themDiem(new Diem(ktctri, 6.));
        ntphuc.getBangDiem().themDiem(new Diem(mmt, 7.));

        dvhthong.getBangDiem().themDiem(new Diem(ltrA1, 7.));
        dvhthong.getBangDiem().themDiem(new Diem(ktctri, 6.));
        dvhthong.getBangDiem().themDiem(new Diem(mmt, 4.));

        tptam.getBangDiem().themDiem(new Diem(ltrA1, 5.));
        tptam.getBangDiem().themDiem(new Diem(ktctri, 9.));
        tptam.getBangDiem().themDiem(new Diem(mmt, 7.));

        ntnguyet.getBangDiem().themDiem(new Diem(ltrA1, 4.));
        ntnguyet.getBangDiem().themDiem(new Diem(ktctri, 6.));
        ntnguyet.getBangDiem().themDiem(new Diem(mmt, 1.));

        lttloc.getBangDiem().themDiem(new Diem(ltrA1, 5.));
        lttloc.getBangDiem().themDiem(new Diem(ktctri, 4.));
        lttloc.getBangDiem().themDiem(new Diem(mmt, 7.));
    }
}
