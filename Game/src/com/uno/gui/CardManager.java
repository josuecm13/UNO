package com.uno.gui;

import com.uno.interfaces.AbsCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


/**
 * Created by ${gaboq} on 24/9/2017.
 */

public class CardManager extends JComponent implements MouseListener {

    private static final Color BACKGROUND_COLOR = Color.decode("#CC0000");
    private static final int   TABLE_WIDTH = 1460;
    private static final int   TABLE_HEIGHT = 930;

    private static final String[] cards = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] colors = {"_red", "_green", "_yellow", "_blue", ""};

    private ArrayList<CardGUI> deck;
    private CardGUI card;
    private CardGUI currentCard = null;

    public CardManager(ArrayList<CardGUI> cards, CardGUI cardAux) {
        deck = cards;
        card = cardAux;
        setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        setBackground(Color.blue);
        addMouseListener(this);
    }

    private void processCard() {
        CardGUI aux;
        if (currentCard != null) {
            int index = deck.indexOf(currentCard);
            aux = deck.get(index);
            deck.remove(index);
            /*====================================================
            if(movePosible(card.getCard() , aux.getCard())) {
                aux = ;
                card = aux;
                repaint();
            } else {
                JDialog d = new JDialog();
                d.setLocationRelativeTo(this);
                d.setVisible(true);
            }
            ====================================================*/
            placeDeck(deck);
            repaint();
        }
    }

    public static String setCardImage(AbsCard card) {

        String cardStr;
        int color = card.getColor();
        if(!card.isSpecial()) {
            cardStr = setImageNumber(card) + colors[color];
        } else {
            cardStr = card.getPower() + colors[color];
        }
        return "res/" + cardStr + ".png";
    }

    private static String setImageNumber(AbsCard card) {
        int number = card.getNumber();
        return cards[number];
    }

    public static void placeDeck(ArrayList<CardGUI> hand) {
        int initX = 656;
        int initY = 675;
        int cant = hand.size();
        if(cant > 15) {
            int xPos = initX - (cant * 22);
            for (CardGUI c : hand) {
                c.moveTo(xPos, initY);
                xPos += 45;
            }
        } else {
            int xPos = initX - (cant * 33);
            for (CardGUI c : hand) {
                c.moveTo(xPos, initY);
                xPos += 70;
            }
        }
    }

    public static boolean movePosible(AbsCard card, AbsCard dropedCard) {
        if(card.getColor() == dropedCard.getColor()) {
            return true;
        } else if(card.getNumber() == dropedCard.getNumber()) {
            return true;
        } else if(dropedCard.getColor() == 4){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, width, height);

        for (CardGUI c : deck) {
            c.draw(g, this);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();   // Save the x coord of the click
        int y = e.getY();   // Save the y coord of the click
        for (int crd=deck.size()-1; crd>=0; crd--) {
            CardGUI testCard = deck.get(crd);
            if (testCard.contains(x, y)) {
                currentCard = testCard;  // Remember what we're dragging.
                processCard();
                System.out.println("carta");
                break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {
        currentCard = null;
    }
}
