package com.bank.atm;


import com.bank.atm.domain.Card;
import com.bank.atm.domain.Cards;

import java.util.List;

public class MainTestRunner {
    public static void main(String[] args) {

        List<Card> cards = new Cards().getCards();

        List<Card> cardList = cards
                .stream()
                .toList();

        System.out.println(cardList);

        Long carList1 = cards
                .stream()
                .count();

        System.out.println(carList1);

    }
}
