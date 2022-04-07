package fis.training.filnal.convert;

import fis.training.filnal.dto.CustomerDto;
import fis.training.filnal.dto.TransferDto;
import fis.training.filnal.entity.Account;
import fis.training.filnal.entity.Customer;
import fis.training.filnal.entity.Transaction;

import java.time.LocalDateTime;

public class TransactionConvert {
    public static Transaction convertDto(TransferDto dto, Account fromAccount, Account toAccount){

        Transaction transaction = new Transaction();
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setAmount(dto.getAmount());
        transaction.setContent(dto.getContent());
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);

        if (fromAccount.getStatus() != 1) {
            transaction.setErrorReason("Tai khoan di khong hieu luc");
            transaction.setStatus(1);
        }else
            if (toAccount.getStatus() != 1) {
                transaction.setErrorReason("Tai khoan nhan khong hieu luc");
                transaction.setStatus(2);
            } else
                if (fromAccount.getBalance() < dto.getAmount()) {
                    transaction.setErrorReason("Tai khoan gui khong du so du");
                    transaction.setStatus(3);
                } else {
                    fromAccount.setBalance(fromAccount.getBalance() - dto.getAmount());
                    toAccount.setBalance(toAccount.getBalance() + dto.getAmount());
                    transaction.setStatus(0);
                }

        return transaction;
    }
}
