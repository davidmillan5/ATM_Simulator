package com.bank.atm.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
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
        List<Card> cards = new Cards().getCards();
        boolean cardExists = cards
                .stream()
                .anyMatch(card -> card.getCardNumber() == cardInserted.getCardNumber());
        if(cardExists){
            System.out.println("Which");
        }else{
            System.out.println("The card that you entered is Invalid!");
        }




        /**

        String cardConfirmation = "";
        if(card != null){
            cardConfirmation = "The card number " + card.getCardNumber() + " is valid";
        }else{
            cardConfirmation = "You entered an invalid card.";
        }
        System.out.println(cardConfirmation);

         **/

        return "";
    }

    public void ejectcard(){
        System.out.println("Transaction Completed! Card Ejected");
    }

    public void validatePin(Card card){


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
