package com.uno.server.card.specialCards;

import com.uno.interfaces.AbsCard;
import com.uno.server.card.CardFactory;

/**
 * Created by ${gaboq} on 21/9/2017.
 */

public class SpecialCard extends AbsCard {

    @Override
    public boolean isSpecial(){
        return true;
    }

    public AbsCard getSpecial() {
        int rand = CardFactory.generateRandom(100);
        AbsCard card;
        if(rand <= 25){
            card = new Skip();
        } else if(rand <= 50) {
            card = new Reverse();
        } else if(rand <= 75) {
            card = new DrawTwo();
        } else if(rand <= 88) {
            card = new DrawFour();
        } else {
            card = new Wild();
        }
        return card;
    }

}
