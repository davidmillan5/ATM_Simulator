package com.bank.atm.domain;

import java.time.LocalDate;



public class Card {

    private final String cardNumber;
    private String cardIssuer;
    private String pin;
    private boolean blocked;
    private int failedAttempts = 0;
    private LocalDate expirationDate = randomExpirationDateGenerator();

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        if (pin != null && pin.matches("[0-9]{4}")) {
            this.pin = pin;
        } else {
            System.out.println("The PIN must be exactly 4 digits (0-9).");
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

    public String getCardIssuer() {
        return cardIssuer;
    }

    public void setCardIssuer(String cardIssuer) {
        this.cardIssuer = cardIssuer;
    }

    // Constructor


    public Card() {
        this.cardNumber = randomCardNumberIssuerGenerator();
    }

    public Card(String pin) {
        this.cardNumber = randomCardNumberIssuerGenerator();
        this.pin = pin;
    }

    public Card(String cardNumber, String pin) {
        this.cardNumber = cardNumber; // Note: You'll need to remove 'final' from the field declaration or assign it via a constructor chain
        this.pin = pin;
    }

    public Card(String cardNumber, String pin, String cardIssuer) {
        this.cardNumber = cardNumber; // Note: You'll need to remove 'final' from the field declaration or assign it via a constructor chain
        this.pin = pin;
        this.cardIssuer = cardIssuer;
    }


    String randomCardNumberGenerator(long min, long max){
        long randomCardNumber = min + (long)(Math.random() * ((max - min) + 1));
        return String.valueOf(randomCardNumber);
    }


    String randomCardNumberIssuerGenerator() {
        int randomBINGenerator = 1 + (int) (Math.random() * ((4 - 1) + 1));

        String card = "";
        long min = 0L;
        long max = 0L;
        switch (randomBINGenerator) {
            case 1:
                min = 4042800000000000L;
                max = 4916479999999999L;
                card = randomCardNumberGenerator(min, max);
                break;
            case 2:
                min = 5303710000000000L;
                max = 5523369999999999L;
                card = randomCardNumberGenerator(min, max);
                break;
            case 3:
                min = 3603240000000000L;
                max = 3603249999999999L;
                card = randomCardNumberGenerator(min, max);
                break;
            case 4:
                min = 377847000000000L;
                max = 377847999999999L;
                card = randomCardNumberGenerator(min, max);
                break;
        }
        return card;
    }



    public boolean validatePin(String pin){
        boolean validation = false;
        String actualPin = getPin();
        if(actualPin.equals(pin)){
            validation = true;
        }
        return validation;
    }

    public boolean tryPin(String attemptedPin) {
        if (isBlocked()) {
            System.out.println("This card is blocked.");
            return false;
        }

        if (validatePin(attemptedPin)) {
            resetAttempts();
            return true;
        } else {
            setFailedAttempts(getFailedAttempts() + 1);
            if (getFailedAttempts() >= 3) {
                blocked = true;
                block();
            }
            return false;
        }
    }

    public void resetAttempts(){
        setFailedAttempts(0);
    }

    public void block(){
        if(blocked){
            System.out.println("Your card with number " + getCardNumber() + " has being blocked!");
        }

    }

    LocalDate randomExpirationDateGenerator(){
        LocalDate creationTime = LocalDate.now();
        LocalDate expirationDate = creationTime.plusYears(4L);
        return expirationDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardIssuer='" + cardIssuer + '\'' +
                ", pin='" + pin + '\'' +
                ", blocked=" + blocked +
                ", failedAttempts=" + failedAttempts +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
