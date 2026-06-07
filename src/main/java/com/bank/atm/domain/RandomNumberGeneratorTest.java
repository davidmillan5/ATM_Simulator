package com.bank.atm.domain;

public class RandomNumberGeneratorTest {
    public static void main(String[] args) {
        long max = 4999999999999999L;
        long min = 4000000000000000L;
        System.out.println("Generated numbers are within "+min+" to "+max);
        long randomCardNumber = min + (long)(Math.random() * ((max - min) + 1));
        System.out.println(randomCardNumber);
        System.out.println(((Object) randomCardNumber).getClass().getSimpleName());
        // Parse to String
        String cardNumber = String.valueOf(randomCardNumber);
        System.out.println(cardNumber.getClass().getSimpleName());

        RandomNumberGeneratorTest creator = new RandomNumberGeneratorTest();
        System.out.println(creator.randomCardNumberIssuerGenerator());
        creator.randomBINGenerator();
    }


    String randomcardNumberGenerator(long min, long max){
        long randomCardNumber = min + (long)(Math.random() * ((max - min) + 1));
        return String.valueOf(randomCardNumber);
    }

    void randomBINGenerator(){
        int randomBINGenerator = 1 + (int) (Math.random() * ((4 - 1) + 1));
        System.out.println(randomBINGenerator);
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





}
