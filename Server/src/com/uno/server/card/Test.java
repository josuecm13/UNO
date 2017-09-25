package com.uno.server.card;

/**
 * Created by ${gaboq} on 21/9/2017.
 */

public class Test {

    public static void main(String[] args) {
        for (int i = 0; i < 7 ; i++) {
            AbsCard card = CardFactory.getCard();
            System.out.println(card.color);
            System.out.println(card.power);
            System.out.println(card.number + "\n");

        }
    }

}
