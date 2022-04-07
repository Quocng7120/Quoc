package fis.training.filnal.service;

import fis.training.filnal.dto.TransferDto;
import fis.training.filnal.entity.Report;
import fis.training.filnal.entity.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction transfer(TransferDto dto);
    List<Transaction> findTransactionOfAnAccount(Long accountId);
    Transaction saveTransaction(Transaction transaction);
    List<Transaction> findTransactionsByAccountNumberAndTime(String accountNumber, String from, String to);
    List<Transaction> findAllByTransactionDateBetween(String from, String to);
    List<Report> findAllByTransactionDateBetweenAndStatus(String from, String to, Integer status);
    List<Object[]> reportByDay(String dateTime);
}
