package model;

import junit.framework.*;

public class TestSinhVien extends TestCase {
    private void initChuongTrinhHoc(){
        MonHoc ltrA1 = new MonHoc("01","Lap Trinh A1", 3, 2);
        MonHoc ltrA2 = new MonHoc("02", "Lap Trinh A2", 3, 2);
        MonHoc ktctri = new MonHoc("03", "Kinh te chinh tri", 5, 0);
        MonHoc mmt = new MonHoc("04", "Mang May Tinh", 3, 1);
        MonHoc ctdl1 = new MonHoc("05", "Cau truc du lieu 1", 3, 2);
        MonHoc ctdl2 = new MonHoc("06", "Cau truc du lieu 2", 2, 1);

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
    }
    SinhVien dvhthong;
    public void setUp(){
        MonHoc ltrA1 = new MonHoc("01","Lap Trinh A1", 3, 2);
        MonHoc ktctri = new MonHoc("03", "Kinh te chinh tri", 5, 0);
        MonHoc mmt = new MonHoc("04", "Mang May Tinh", 3, 1);

        dvhthong = new SinhVien("0001", "Dang Van Hoang Thong", new BangDiem());
        dvhthong.getBangDiem().themDiem(new Diem(ltrA1, 7.));
        dvhthong.getBangDiem().themDiem(new Diem(ktctri, 6.));
        dvhthong.getBangDiem().themDiem(new Diem(mmt, 4.));
    }

    public TestSinhVien() {
        initChuongTrinhHoc();
    }

    public void testCoTheDangKyHoc() {
        MonHoc ctdl1 = new MonHoc("05", "Cau truc du lieu 1", 3, 2);
        MonHoc ltrA2 = new MonHoc("02", "Lap Trinh A2", 3, 2);
        MonHoc ktctri = new MonHoc("03", "Kinh te chinh tri", 5, 0);
        MonHoc mmt = new MonHoc("04", "Mang May Tinh", 3, 1);
        MonHoc ltrA1 = new MonHoc("01","Lap Trinh A1", 3, 2);

        ltrA2.addMonTienQuyet(ltrA1);
        ctdl1.addMonTienQuyet(ltrA2);
        ctdl1.addMonTienQuyet(mmt);

        assertFalse(dvhthong.coTheDangKyHoc(ctdl1));
        assertTrue(dvhthong.coTheDangKyHoc(ltrA2));
    }
}
