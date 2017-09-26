package com.uno.gui;


import com.uno.cards.AbsCard;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static com.uno.gui.CardManager.setCardImage;


/**
 * Created by ${gaboq} on 25/9/2017.
 */

public class GameView {

    public static ImageIcon generateCardIcon(AbsCard card) {
        ImageIcon img = new ImageIcon(setCardImage(card));
        Image resizedImg = getScaledImage(img.getImage(), 156, 229);
        img = new ImageIcon(resizedImg);
        return img;
    }

    static Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

    static GridBagConstraints setButtonProps(JButton btn, ImageIcon img) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        btn.setIcon(img);
        btn.setOpaque(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        return gbc;
    }


    //===================== Main ========================
    public static void main(String[] args) {
        new MainLayout();
    }

}
