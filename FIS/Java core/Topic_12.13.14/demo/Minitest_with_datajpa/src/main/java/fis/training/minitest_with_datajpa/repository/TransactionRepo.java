package fis.training.minitest_with_datajpa.repository;

import fis.training.minitest_with_datajpa.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepo extends CrudRepository<Transaction, Long> {
}
