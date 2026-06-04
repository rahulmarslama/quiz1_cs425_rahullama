package miu.rahul.service;

import miu.rahul.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    List<Account> getSilverTierAccounts();
    List<Account> getGoldTierAccounts();
    List<Account> getPlatinumTierAccounts();
    Double computeTotalLiquidity();
}
