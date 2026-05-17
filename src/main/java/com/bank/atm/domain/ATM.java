package com.bank.atm.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class ATM {

    // Generate a random UUID
    UUID uuid = UUID.randomUUID();

    private String id = uuid.toString();
    private String location;
    private BigDecimal cashAvailable = BigDecimal.valueOf(0.00);
    private Card inserCard;
    private Account currentSessionAccount;

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getCashAvailable() {
        return cashAvailable;
    }

    public void setCashAvailable(BigDecimal cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    public Card getInserCard() {
        return inserCard;
    }

    public void setInserCard(Card inserCard) {
        this.inserCard = inserCard;
    }

    public Account getCurrentSessionAccount() {
        return currentSessionAccount;
    }

    public void setCurrentSessionAccount(Account currentSessionAccount) {
        this.currentSessionAccount = currentSessionAccount;
    }





}
