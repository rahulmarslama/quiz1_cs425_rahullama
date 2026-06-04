package miu.rahul.db;

import miu.rahul.model.Account;
import miu.rahul.model.Customer;

import java.util.List;

public class DBContext {
    private static DBContext instance;
    private List<Account> accounts;
    private List<Customer> customers;

    private DBContext() {
    }

    public static synchronized DBContext getInstance() {
        if (instance == null) {
            instance = new DBContext();
        }
        return instance;
    }

    private void loadData() {
        // Initialize/load accounts and customers data
        Customer customer1 = new Customer(1L, "Bob", "Jones");
        Customer customer2 = new Customer(2L, "Anna", "Smith");
        Customer customer3 = new Customer(3L, "Carlos", "Jimenez");
        customers = List.of(customer1, customer2, customer3);
        Account account1 = new Account(1L, "AC1002", "Checking",
                java.time.LocalDate.of(2016, 5, 17), 155900.50,
                customer1);
        Account account2 = new Account(2L, "AC1001", "Savings",
                java.time.LocalDate.of(2021, 6, 2), 12500.95,
                customer1);
        Account account3 = new Account(3L, "AC1003", "Saving",
                java.time.LocalDate.of(2016, 7, 11), 75000.00,
                customer3);
        Account account4 = new Account(4L, "AC1004", "Checking",
                java.time.LocalDate.of(2024, 3, 29), 11700.99,
                customer2);
        accounts = List.of(account1, account2, account3, account4);
    }

    public List<Account> getAccounts() {
        if (accounts == null || accounts.isEmpty()) {
            loadData();
        }
        return accounts;
    }

    public List<Customer> getCustomers() {
        if (customers == null || customers.isEmpty()) {
            loadData();
        }
        return customers;
    }
}

