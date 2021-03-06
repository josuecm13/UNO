package com.uno.server.card;

import com.uno.interfaces.AbsCard;
import com.uno.server.card.numberCards.NumberCard;
import com.uno.server.card.specialCards.SpecialCard;

/**
 * Created by ${gaboq} on 21/9/2017.
 */


public class CardFactory {

    public static int generateRandom(int n){
        return (int) (Math.random() * (n+1));
    }


    public static void setCardProperties(AbsCard card){
        card.setColor(generateRandom(4));
        if(!card.isSpecial()) {
            card.setNumber(generateRandom(9));
        }
    }

    public static AbsCard getCard(){
        int rand = generateRandom(100);
        AbsCard card;
        if(rand <= 68){
            card = new NumberCard();
        } else {
            card = new SpecialCard().getSpecial();
        }
        setCardProperties(card);
        return card;
    }

}
