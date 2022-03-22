package com.fis.backend;

import com.fis.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountController {

    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account){
        account.setId((long) accounts.size()+1);
        this.accounts.add(account);
    }

    public List<Account> getAllAcount(){
//        accounts.add(new Account(1L,"03320", "Nguyen Duy Quoc", 10000.0, 1));
//        accounts.add(new Account(2L,"03320", "Nguyen Duy Quoc", 10000.0, 1));
//        accounts.add(new Account(3L,"03320", "Nguyen Duy Quoc", 10000.0, 1));
//        accounts.add(new Account(4L,"03320", "Nguyen Duy Quoc", 10000.0, 1));
//        accounts.add(new Account(5L,"03320", "Nguyen Duy Quoc", 10000.0, 1));
        return this.accounts;
    }

    public boolean isAccount(Account account){
        for (Account isaccount:accounts) {
            if (isaccount.equals(account)){
                return true;
            }
        }
        return false;
    }

    public boolean isAccountById(long id){
        for (Account isaccount:accounts){
            if (isaccount.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public Account getAccountById(Long id){
        for (Account isaccount:accounts){
            if (isaccount.getId().equals(id)){
                return isaccount;
            }
        }
        return null;
    }

    public int getIndexOfAccountInArray(Long id){
        return accounts.indexOf(getAccountById(id));
    }

    public void updateAccount(Long id, String stt, String ttk){
        accounts.get(getIndexOfAccountInArray(id)).setAccountNumber(stt);
        accounts.get(getIndexOfAccountInArray(id)).setAccountName(ttk);
    }
}
