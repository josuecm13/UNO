package com.uno.gui;


import com.uno.cards.AbsCard;
import com.uno.cards.CardFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import static com.uno.gui.CardManager.placeDeck;


public class MainLayout extends GameView{

    //=================================================================== fields
    private ArrayList<CardGUI> hand = new ArrayList<>();
    public static CardGUI card;

    //============================================================== Images
    private ImageIcon backCard = new ImageIcon("res/back.png");
    private ImageIcon UNObtn = new ImageIcon("res/botnUNO.png");
    private ImageIcon orientImgInv = new ImageIcon("res/rotateImgInv.png");
    private ImageIcon orientImg = new ImageIcon("res/rotateImg.png");

    //============================================================== constructor
    public MainLayout() {
        generateDeck(7);
        JFrame window = new JFrame("UNO");
        ImageIcon img_icon = new ImageIcon("res/uno_icon.png");
        window.setIconImage(img_icon.getImage());
        //window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.setResizable(false);
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(window, "Desea cerrar la aplicacion?", "Cerrar programa", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        window.setContentPane(new CardManager(hand, card));
        window.add(new CardManager(hand, card));
        window.setLayout(new GridBagLayout());
        setDrawButton(window);
        setUNOButton(window);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    //================================================================
    private void generateDeck(int cardNumb) {
        for (int face=0; face < cardNumb; face++) {
            AbsCard card = CardFactory.getCard();
            ImageIcon img = generateCardIcon(card);
            CardGUI cardGUI = new CardGUI(img, card);
            hand.add(cardGUI);
        }
        placeDeck(hand);
    }

    private void drawCard(JFrame frame) {
        AbsCard card = CardFactory.getCard();
        ImageIcon img = generateCardIcon(card);
        CardGUI cardGUI = new CardGUI(img, card);
        hand.add(cardGUI);
        placeDeck(hand);
        frame.repaint();
    }

    private void setDrawButton(JFrame frame) {
        JButton drawButton;
        drawButton = new JButton("");
        ImageIcon img = new ImageIcon(getScaledImage(backCard.getImage(), 177, 249));
        GridBagConstraints gbc = setButtonProps(drawButton, img);
        drawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawCard(frame);
                System.out.println(hand.size());
            }
        });
        frame.add(drawButton, gbc);
    }

    private void setUNOButton(JFrame frame) {
        JButton btn;
        btn = new JButton("");
        ImageIcon img = new ImageIcon(getScaledImage(UNObtn.getImage(), 249, 249));
        GridBagConstraints gbc = setButtonProps(btn, img);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(hand.size() == 1)
                    System.exit(0);
            }
        });
        frame.add(btn, gbc);
    }

    private void setOrientatonLabel(JFrame frame) {
        JLabel lbl;
    }

}
