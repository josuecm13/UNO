package card;

/**
 * Created by ${gaboq} on 20/9/2017.
 */

public abstract class AbsCard {

    protected int number;

    protected int color;

    protected String power;


    protected void setNumber(int number) {
        this.number = number;
    }

    protected void setColor(int color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public int getColor() {
        return color;
    }

    public String getPower() {
        return power;
    }

    public boolean isSpecial() {
        return false;
    }



}
