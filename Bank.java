package edu.java;

import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.util.Arrays;

public class Bank {

    private Account[] accounts = new Account[0];
    private AccountNumberGenerator accountNumberGenerator = new AccountNumberGenerator();


    public Account createAccount(Person person) {

        Account account = new Account(accountNumberGenerator.generateAccountNumber(), person);
        addAccount(account);
        return account;

    }
// tworzymy nową tablicę która zakryje istniejącą tablice i ją powiększy

    private void addAccount(Account account) {
        Account[] newAccounts = Arrays.copyOf(accounts, accounts.length + 1);
        newAccounts[accounts.length] = account;
        this.accounts = newAccounts;
    }

    public BigDecimal depositMoney(String accountNumber, BigDecimal value) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            return account.deposit(value);
        }
        return BigDecimal.ZERO;
    }

    private Account findAccount(String accountNumber) {
        for (Account account : this.accounts) {
            if (account.getNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    class AccountNumberGenerator {

        public String generateAccountNumber() {
            return RandomStringUtils.randomNumeric(26);
        }


    }
}
