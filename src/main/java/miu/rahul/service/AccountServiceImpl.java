package miu.rahul.service;

import miu.rahul.model.Account;
import miu.rahul.repository.AccountRepository;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl() {
        this.accountRepository = AccountRepository.getInstance();
    }

     @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .sorted(java.util.Comparator.comparing(Account::getBalance).reversed())
                .toList();
    }

    @Override
    public List<Account> getSilverTierAccounts() {
        return accountRepository.findAll()
                .stream()
                .filter(Account::isSilverTier).toList();
    }

    @Override
    public List<Account> getGoldTierAccounts() {
        return accountRepository.findAll()
                .stream()
                .filter(Account::isGoldTier).toList();
    }

    @Override
    public List<Account> getPlatinumTierAccounts() {
        return accountRepository.findAll()
                .stream()
                .filter(Account::isPlatinumTier).toList();
    }

    @Override
public Double computeTotalLiquidity() {
    return accountRepository.findAll()
            .stream()
            .mapToDouble(Account::getBalance)
            .sum();
}
}
