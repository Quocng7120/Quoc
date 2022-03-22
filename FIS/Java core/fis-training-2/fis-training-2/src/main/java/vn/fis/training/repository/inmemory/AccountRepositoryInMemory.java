package vn.fis.training.repository.inmemory;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.fis.training.domain.Account;
import vn.fis.training.repository.AccountRepository;

import java.util.*;

public class AccountRepositoryInMemory implements AccountRepository {
    static final Logger LOG = LogManager.getLogger(AccountRepositoryInMemory.class);
//    static final Logger

    private Map<Long, Account> storage;

    public AccountRepositoryInMemory() {
        storage = new HashMap<>();
    }

    @Override
    public Account addAccount(Account account) {

        storage.put(account.getId(), account);
        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        return null;
    }

    @Override
    public void deleteAccount(Long id) {
        storage.remove(id);
    }

    @Override
    public List<Account> findAllAccountOrderDyIdAsc() {
        List<Account> accounts = new ArrayList<>(storage.values());
        Collections.sort(accounts, new Comparator<Account>() {
            @Override
            public int compare(Account fisrtAccount, Account secondAccount) {
                return fisrtAccount.getId().compareTo(secondAccount.getId());
            }
        });
        return accounts;
    }

    @Override
    public Account findById(Long id) {
        return null;
    }
}
