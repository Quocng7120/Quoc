package fis.training.minitest_with_datajpa.repository;

import fis.training.minitest_with_datajpa.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, Long> {
}
