package com.uno.gui;


import com.uno.interfaces.AbsCard;

import javax.swing.*;
import java.awt.*;


public class CardGUI {

    //=================================================================== fields
    private AbsCard _card;
    private ImageIcon _image;
    private int       _x;
    private int       _y;

    //============================================================== constructor
    public CardGUI(ImageIcon image, AbsCard card) {
        _image = image;
        _card = card;
    }

    public AbsCard getCard() {
        return _card;
    }

    //=================================================================== moveTo
    public void moveTo(int x, int y) {
        _x = x;
        _y = y;
    }

    //================================================================= contains
    public boolean contains(int x, int y) {
        return (x > _x && x < (_x + getWidth()) &&
                y > _y && y < (_y + getHeight()));
    }

    //================================================================= getWidth
    public int getWidth() {
        return _image.getIconWidth();
    }

    //================================================================ getHeight
    public int getHeight() {
        return _image.getIconHeight();
    }

    //===================================================================== getX
    public int getX() {
        return _x;
    }

    //===================================================================== getY
    public int getY() {
        return _x;
    }

    //===================================================================== draw
    public void draw(Graphics g, Component c) {
        _image.paintIcon(c, g, _x, _y);
    }
}