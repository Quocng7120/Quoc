package fis.training.minitest_with_datajpa.sevice;

import fis.training.minitest_with_datajpa.entity.Account;
import fis.training.minitest_with_datajpa.entity.Transaction;

public interface TransactionService {
    Transaction chuyenTien(Account fromAccount, Account toAccount, Double amount);
}
