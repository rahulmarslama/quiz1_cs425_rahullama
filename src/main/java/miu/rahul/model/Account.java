package miu.rahul.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Account {
    private Long accountId;
    private String accountNumber;
    private String accountType;
    private LocalDate dateOpened;
    private Double balance;
    private Customer owner;

    public Account() {
    }

    public Account(Long accountId, String accountNumber, String accountType,
                   LocalDate dateOpened, Double balance, Customer owner) {
        if(accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
        if(owner == null) {
            throw new IllegalArgumentException("Account must have at least one owner");
        }
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.dateOpened = dateOpened;
        this.balance = balance;
        this.owner = owner;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountType() {
        return accountType;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public Double getBalance() {
        return balance;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setOwners(Customer owner) {
        this.owner = owner;
    }


    public boolean isPlatinumTier() {
        return this.balance != null &&
                this.getAccountYears() >= 10 &&
                this.balance >= 100000.00;
    }

    public boolean isGoldTier() {
        return this.balance != null &&
                this.getAccountYears() >= 5 &&
                this.balance >= 50000.00 &&
                !this.isPlatinumTier();
    }

    public boolean isSilverTier() {
        return this.balance != null &&
                this.getAccountYears() >= 2 &&
                this.balance >= 10000.00 &&
                !this.isGoldTier() &&
                !this.isPlatinumTier();
    }

    public int getAccountYears()
    {
        if (this.dateOpened == null) {
            return 0;
        }

        LocalDate currentDate = LocalDate.now();

        return Period.between(this.dateOpened, currentDate).getYears();
    }

    public String toString() {
        return toJSON();
        // return String.format("Account{id=%d, number='%s', type='%s', dateOpened=%s, balance=%.2f, owners=%s}",
        //     accountId, accountNumber, accountType, dateOpened, balance, owners);
    }
    public String toJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(String.format("\"accountId\": %d, ", accountId));
        sb.append(String.format("\"accountNumber\": \"%s\", ", accountNumber));
        sb.append(String.format("\"accountType\": \"%s\", ", accountType));
        sb.append(String.format("\"dateOpened\": \"%s\", ", dateOpened));
        sb.append(String.format("\"accountYears\": \"%s\", ", getAccountYears()));
         sb.append(String.format(java.util.Locale.US, "\"balance\": %.2f, ", balance));

        sb.append("\"owner\": ");
        if (owner != null) {
            sb.append(String.format("{\"customerId\": %d, \"firstName\": \"%s\", \"lastName\": \"%s\"}",
                    owner.getCustomerId(), owner.getFirstName(), owner.getLastName()));
        } else {
            sb.append("null");
        }

        sb.append("}");
        return sb.toString();
    }
}

