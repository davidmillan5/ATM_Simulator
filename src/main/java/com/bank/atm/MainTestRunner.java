package com.bank.atm;


import com.bank.atm.domain.Account;
import com.bank.atm.domain.Card;
import com.bank.atm.domain.Cards;

import java.math.BigDecimal;
import java.util.List;

import static com.bank.atm.enums.AccountStatus.ACTIVE;

public class MainTestRunner {
    public static void main(String[] args) {
/*
        List<Card> cards = new Cards().getCards();

        List<Card> cardList = cards
                .stream()
                .toList();

        System.out.println(cardList);

        Long carList1 = cards
                .stream()
                .count();

        System.out.println(carList1);
*/


        Account account1 = new Account("00684846932", "Eren Yaeger", ACTIVE);
        account1.deposit(BigDecimal.valueOf(15000.00));

        System.out.println(account1.getBalance());

        account1.withdraw(BigDecimal.valueOf(-16000.00));
        System.out.println(account1.getBalance());

        System.out.println(account1.getTransactions());
    }
}
