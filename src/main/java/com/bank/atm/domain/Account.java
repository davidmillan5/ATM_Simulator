package com.bank.atm.domain;

import com.bank.atm.enums.AccountStatus;
import com.bank.atm.enums.TransactionType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.bank.atm.enums.TransactionType.DEPOSIT;

public class Account {

    // Generate a random UUID
    UUID uuid = UUID.randomUUID();

    private String id = uuid.toString();
    private String accountNumber;
    private String ownerName;
    private BigDecimal balance = BigDecimal.valueOf(0.00);
    private AccountStatus status;
    private List<Transaction> transactions = new ArrayList<>();

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



    public Account(String accountNumber, String ownerName, AccountStatus status) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.status = status;
    }

    public void deposit(BigDecimal amount){
        setBalance(getBalance().add(amount));
        Transaction deposit = new Transaction(DEPOSIT, amount, "Simple Deposit");
        addTransaction(deposit);
    }

    public void withdraw(BigDecimal amount){
        if(validateSufficientFunds(amount)){
            setBalance(getBalance().subtract(amount));
        }else{
            System.out.println("You don't have enough founds in your account.");
        }
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public boolean validateSufficientFunds(BigDecimal amount){
        return getBalance().compareTo(amount) >= 0;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                ", transactions=" + transactions +
                '}';
    }
}
