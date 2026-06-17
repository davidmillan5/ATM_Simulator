package com.bank.atm.domain;

import com.bank.atm.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    UUID uuid = UUID.randomUUID();
    private final String id = uuid.toString();
    private TransactionType transactionType;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private String description;


    public Transaction(UUID uuid, TransactionType transactionType, BigDecimal amount, LocalDateTime timestamp, String description) {
        this.uuid = uuid;
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = timestamp;
        this.description = description;
    }

    public UUID getUuid() {
        return uuid;
    }


    public String getId() {
        return id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "uuid=" + uuid +
                ", id='" + id + '\'' +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", description='" + description + '\'' +
                '}';
    }
}
