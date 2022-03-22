package com.fis.frontend;

import com.fis.backend.AccountController;
import com.fis.entity.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Display {
    private AccountController accountController = new AccountController();
    private List<Integer> list = new ArrayList<>();


    private void dataForTest(){
        accountController.addAccount(new Account("033200178948", "Nguyen Duy Quoc", 10000.0, 1));
        accountController.addAccount(new Account("03321", "Nguyen Duy Quoc", 10000.0, 1));
        accountController.addAccount(new Account("03322", "Nguyen Duy Quoc", 10000.0, 1));
        accountController.addAccount(new Account("03323", "Nguyen Duy Quoc", 10000.0, 1));
        accountController.addAccount(new Account("03324", "Nguyen Duy Quoc", 10000.0, 1));
    }
    public void getListAccount(){
//        dataForTest();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);


        for (Account account: accountController.getAllAcount()) {
            System.out.println(account.getId() + "\n" + account.getAccountName());
        }

//        for (Integer i:list) {
//            System.out.println(i.toString());
//        }
    }

    public void creatAccount(){
//        dataForTest();
        Scanner scanner = new Scanner(System.in);
        String stk;
        String ttk;
        System.out.println("Nhap so tai khoan: ");
        stk = scanner.nextLine();
        System.out.println("Nhap ten tai khoan: ");
        ttk = scanner.nextLine();

        if(stk.length()==12){
            Account account = new Account(stk, ttk);
            if (!accountController.isAccount(account)){
                if (ttk.length()>5 && ttk.length()<100){
                    account.setBalance(100000.0);
                    account.setStatus(1);
                    accountController.addAccount(account);
                    System.out.println("Them thanh cong!");
                }
                else System.out.println("Ten khong thoa man!");
            }
            else System.out.println("So tai khoan da ton tai!");
        }
        else System.out.println("So tai khoan khong thoa man!");
    }

    public void updateAccount(){
        dataForTest();
        Scanner scanner = new Scanner(System.in);
        Long id;
        System.out.println("Nhap ID tai khoan: ");
        id = scanner.nextLong();
        if(accountController.isAccountById(id)){
            String stk;
            String ttk;
            System.out.println("Nhap so tai khoan: ");
            stk = scanner.nextLine();
            System.out.println("Nhap ten tai khoan: ");
            ttk = scanner.nextLine();
            if(stk.length()==12){
                    if (ttk.length()>5 && ttk.length()<100){
                        accountController.updateAccount(id, stk, ttk);
                        System.out.println("Sua thanh cong!");
                    }
                    else System.out.println("Ten khong thoa man!");
            }
            else System.out.println("So tai khoan khong thoa man!");
        }
        else System.out.println("Tai khoan chua ton tai");
    }
}
