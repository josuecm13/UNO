package com.uno.server.card.specialCards;

/**
 * Created by ${gaboq} on 21/9/2017.
 */
public class WildCard extends SpecialCard{

    @Override
    public void setColor(int color) {}

    @Override
    public boolean isWild(){return true;}

    public WildCard(){color = 5;}

}
