package com.fis.frontend;

import java.util.Scanner;

public class Menu {

    public static void question1() {
//        MyNews myNews = new MyNews();
        Display display = new Display();
        Scanner scanner = new Scanner(System.in);

        int choose;
        do {
            loadmenu();
            choose = scanner.nextInt();

            switch (choose) {

                case 1:
                    System.out.println("da chon 1");
                    display.getListAccount();
                    break;

                case 2:
                    System.out.println("da chon 2");
                    display.creatAccount();
                    break;

                case 3:
                    System.out.println("da chon 3");
                    display.updateAccount();
//                    myNews.averageRate();
//                    myNews.viewListNews();
                    break;

                case 4:
                    System.out.println("da chon 4");
                    break;

                case 5:
                    System.out.println("da chon 5");
                    break;

                case 6:
                    System.out.println("da chon 6");
                    break;

                default:
                    System.out.println("Nhập sai ! Vui lòng nhập lại !");
                    break;
            }
        } while (choose != 4);
    }

    private static void loadmenu() {
        System.out.println("=========MENU=========");
        System.out.println("1. Danh sach tai khoan");
        System.out.println("2. Them moi tai khoan");
        System.out.println("3. Cap nhat thong tin tai khoan");
        System.out.println("4. Xoa tai khoan");
        System.out.println("5. Chuyen khoan");
        System.out.println("6. Exit");
        System.out.println("==Bạn chọn:           ");
    }
}
