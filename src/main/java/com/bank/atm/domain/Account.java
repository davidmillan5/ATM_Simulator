package com.bank.atm.domain;

import com.bank.atm.enums.AccountStatus;
import com.bank.atm.enums.TransactionType;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Account {

    // Generate a random UUID
    UUID uuid = UUID.randomUUID();

    private String id = uuid.toString();
    private String accountNumber;
    private String ownerName;
    private BigDecimal balance = BigDecimal.valueOf(0.00);
    private AccountStatus status;
    private List<Transaction> transactions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    void deposit(BigDecimal amount){
        balance = getBalance().add(amount);
        setBalance(balance);
    }

    void withdraw(BigDecimal amount){
        validateSufficientFunds(amount);
    }

    void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    void validateSufficientFunds(BigDecimal amount){
        if(getBalance().compareTo(amount) > 0){
            balance = getBalance().subtract(amount);
            setBalance(balance);
        }else{
            System.out.println("You don't have enough founds in your account.");
        }
    }

}
