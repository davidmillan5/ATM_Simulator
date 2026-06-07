package com.bank.atm.domain;

import java.time.LocalDate;

public class Card {

    private String cardNumber = randomCardNumberIssuerGenerator();
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
        if(pin.length()>=4){
            this.pin = pin;
        }else if(pin.length() < 4){
            System.out.println("The PIN must have 4 numbers to vi a valid PIN.");
        }else{
            System.out.println("The PIN must not have more than 4 digits! Try again! ");
        }

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


    String randomcardNumberGenerator(long min, long max){
        long randomCardNumber = min + (long)(Math.random() * ((max - min) + 1));
        return String.valueOf(randomCardNumber);
    }


    String randomCardNumberIssuerGenerator() {
        int randomBINGenerator = 1 + (int) (Math.random() * ((4 - 1) + 1));
        //System.out.println(randomBINGenerator);

        String card = "";
        long min = 0L;
        long max = 0L;
        switch (randomBINGenerator) {
            case 1:
                min = 4042800000000000L;
                max = 4916479999999999L;
                card = randomcardNumberGenerator(min, max);
                break;
            case 2:
                min = 5303710000000000L;
                max = 5523369999999999L;
                card = randomcardNumberGenerator(min, max);
                break;
            case 3:
                min = 3603240000000000L;
                max = 3603249999999999L;
                card = randomcardNumberGenerator(min, max);
                break;
            case 4:
                min = 377847000000000L;
                max = 377847999999999L;
                card = randomcardNumberGenerator(min, max);
                break;
        }
        return card;
    }



    String validatePin(String pin){
        String message = "Access Denied";
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
