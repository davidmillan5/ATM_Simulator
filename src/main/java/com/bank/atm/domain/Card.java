package com.bank.atm.domain;

import java.time.LocalDate;

public class Card {

    private String cardNumber;
    private String pin;
    private boolean blocked;
    private int failedAttempts = 0;
    private LocalDate expirationDate;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }


    String validatePin(String pin){
        String message = "";
        String actualPin = getPin();
        if(actualPin.equals(pin)){
            message = "Access Granted";
        }
        return message;
    }

    void incrementFailedAttemps(){
        while((getFailedAttempts() > 0 && getFailedAttempts() <= 3)){
            if(!validatePin(pin).equals(pin)){
                failedAttempts++;
                setFailedAttempts(failedAttempts);
                System.out.println("Your PIN is incorrect. Enter a valid PIN");
            }else if(getFailedAttempts() == 3) {
                blocked = true;
                block();
            }else{
                System.out.println("Transaction approved.");
                resetAttempts();
                break;
            }
        }
    }

    void resetAttempts(){
        setFailedAttempts(0);
    }

    void block(){
        if(blocked){
            System.out.println("Your card with number " + getCardNumber() + " has being blocked!");
        }

    }

}
