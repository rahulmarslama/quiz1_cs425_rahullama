package miu.rahul.repository;

import miu.rahul.db.DBContext;
import miu.rahul.model.Account;

import java.util.List;

public class AccountRepository {
    private static AccountRepository instance;
    private DBContext dbContext;

    private AccountRepository() {
        dbContext = DBContext.getInstance();
    }

    public static synchronized AccountRepository getInstance() {
        if (instance == null) {
            instance = new AccountRepository();
        }
        return instance;
    }

    public List<Account> findAll() {
        return dbContext.getAccounts();
    }

    public Account findById(Long accountId) {
        return dbContext.getAccounts().stream()
                .filter(a -> a.getAccountId().equals(accountId))
                .findFirst()
                .orElse(null);
    }

}

