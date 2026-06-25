package com.bank.atm.domain;

import java.util.List;

public class Cards {
    public List<Card> getCards() {
        return List.of(

                new Card("3603244604058393", "4829", "Dinners"),
                new Card("3603245925091448", "0134", "Dinners"),
                new Card("377847935476120", "9562", "Amex"),
                new Card("4802427721039742", "3810", "Visa"),


                new Card("4125839401127465", "7451", "Visa"),
                new Card("5412756384910234", "0042", "Mastercard"),
                new Card("4916470011223344", "8193", "Visa"),
                new Card("5303719988776655", "5627", "Mastercard"),


                new Card("377847112233445", "1904", "Amex"),
                new Card("3603240000123456", "6375", "Dinners"),
                new Card("377847556677889", "2841", "Amex"),
                new Card("3603249999888777", "8902", "Dinners"),


                new Card("4042801234567890", "4413", "Visa"),
                new Card("5523361234567890", "0726", "Mastercard"),
                new Card("4532718293847561", "9158", "Visa"),
                new Card("5411223344556677", "3361", "Mastercard"),


                new Card("377847000000001", "6209", "Amex"),
                new Card("3603241111111111", "5574", "Amex"),
                new Card("4812345678901234", "1083", "Visa"),
                new Card("5355667788990011", "7942", "Mastercard")
        );
    }
}