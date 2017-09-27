package com.uno.interfaces;

import java.io.Serializable;

/**
 * Created by ${gaboq} on 20/9/2017.
 */

public abstract class AbsCard implements Serializable {

    protected int number;

    protected int color;

    protected String power;


    public void setNumber(int number) {
        this.number = number;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public int getColor() {
        return color;
    }

    public boolean isWild() {
        return false;
    }

    public boolean isSpecial(){
        return false;
    }

}
