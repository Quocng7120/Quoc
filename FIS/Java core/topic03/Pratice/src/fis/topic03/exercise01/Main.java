package fis.topic03.exercise01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		QuanLy q = new QuanLy();
//		List<GiaoDich> listTK=q.readListGD();
//		for(GiaoDich t:listTK) {
//			System.out.println(t.getId());
//			System.out.println(t.getSoTaiKhoanGui());
//			System.out.println(t.getSoTaiKhoanNhan());
//			System.out.println(t.getSoTien());
//			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//			System.out.println(formatter.format(t.getNgayGui()));
//			System.out.println(t.getNoiDung());
//		}
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		while (true) {
			System.out.println("====Dang Nhap Vao Tai Khoan");
			System.out.println("1.Dang Nhap");
			System.out.println("Chon ...");
			String key = sc.nextLine();
			switch (key) {
			case "1": {
				System.out.println("Nhap So Tai Khoan : ");
				String name = sc.nextLine();
				System.out.println("Nhap Mat Khau : ");
				String pass = sc.nextLine();
				if (q.checkTaiKhoan(name, pass)) {
					while (true) {
						System.out.println("====Quan Ly Tai Khoan");
						System.out.println("1.Kiem Tra Giao Dich");
						System.out.println("2.Thoat");
						System.out.println("Chon ...");
						String key1 = sc.nextLine();
						if (key1.equals("1")) {
							System.out.println("Nhap So Tai Khoan Gui : ");
							String STKGui =sc.nextLine();
							System.out.println("Nhap Noi Dung : ");
							String noiDung =sc.nextLine();
							System.out.println("Nhap So Tien : ");
							Double soTien =sc1.nextDouble();
							List<GiaoDich> list = q.chechkGiaoDich(STKGui, name, noiDung, soTien);
							if(list==null) System.out.println("Khong Tim Thay");
							else {
								StringBuilder str=new StringBuilder(String.format("%-10s %-15s %-10s %-20s", "STK Gui","Ngay Gui","So Tien","Noi Dung")+"\n");
								for(GiaoDich g:list) {
									str.append(String.format("%-10s %-15s %-10s %-20s",g.getSoTaiKhoanGui(),formatter.format(g.getNgayGui()),g.getSoTien(),g.getNoiDung())+"\n");
								}
								System.out.println(str);
							}
						}else if(key1.equals("2")) break;
					}
				} else
					System.out.println("Dang nhap that bai ");
				break;
			}
			default:
				System.out.println("Khong Co Chuc Nang Nay");
				break;
			}
		}
	}
}
