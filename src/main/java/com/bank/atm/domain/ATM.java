package com.bank.atm.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ATM {


    // Generate a random UUID
    UUID uuid = UUID.randomUUID();

    private final String id = uuid.toString();
    private String location;
    private BigDecimal cashAvailable = BigDecimal.valueOf(0.00);
    private Card insertedCard;
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

    public void setCashAvailable(Account account) {

        this.cashAvailable = account.getBalance();
    }

    public Card getInsertedCard(Card card) {
        return card;
    }


    public Account getCurrentSessionAccount() {
        return currentSessionAccount;
    }

    public void setCurrentSessionAccount(Account currentSessionAccount) {
        this.currentSessionAccount = currentSessionAccount;
    }


    public String insertCard(Card cardInserted){
        String message = "";
        List<Card> cards = new Cards().getCards();
        boolean cardExists = cards
                .stream()
                .anyMatch(card -> card.getCardNumber().equals(cardInserted.getCardNumber()));
        if(cardExists){
            message = "Continue with your transactions";
        }else{
            message = "The card that you entered is Invalid!";
        }
        return message;
    }

    public void ejectcard(){
        System.out.println("Transaction Completed! Card Ejected");
    }

    public void validatePin(Card cardPin){
        if(!insertCard(cardPin).isEmpty()){
            List<Card> cards = new Cards().getCards();
            boolean cardPinExists = cards
                    .stream()
                    .anyMatch(card ->
                            card.getPin().equals(cardPin.getPin())
                                    && card.getCardNumber().equals(cardPin.getCardNumber()));
            if(cardPinExists){
                System.out.println("Valid Client");
            }else{
                System.out.println("Invalid PIN");
            }
        }
    }


    public void deposit(Account account, BigDecimal amount){
        account.deposit(amount);
    }

    public void withdraw(Account account, BigDecimal amount){
        account.withdraw(amount);
    }


    public void showBalance(Account account){
        account.getBalance();
    }

    public void printTransactionHistory(Account account){
        account.getTransactions();
    }
}
