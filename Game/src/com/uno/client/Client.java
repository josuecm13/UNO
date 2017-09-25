package com.uno.client;

import com.uno.interfaces.AbsCard;
import com.uno.interfaces.Gui;
import com.uno.interfaces.IServer;

import java.io.Serializable;
import java.net.InetAddress;
import java.rmi.Naming;

/**
 * Created by ${gaboq} on 21/9/2017.
 */

public class Client implements Serializable{

    public static String user;


    public static void main(String[] args) throws Exception {
        IServer server =(IServer) Naming.lookup("//localhost/UNOServer");
        int opt;
        do{
            opt = Gui.menu("UNO",new String[]{"ingresar usuario","obtener una carta", "revisar maso","Salir"});
            switch (opt){
                case 0:
                    String username = Gui.input("Ingresar","Usuario: ");
                    String password = Gui.input("","Contraseña: ");
                    user = username;
                    server.addPlayer(InetAddress.getLocalHost().getHostAddress().toString(),username, password);
                    break;
                case 1:
                    AbsCard card = null;
                    try {
                        card = server.generateCard(user);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("carta");
                    System.out.println("Numero " + card.getNumber());
                    System.out.println("Color " + card.getColor());
                    System.out.println("Es Carta Especial " + card.isSpecial());
                    System.out.println("Es Carta Comodin " + card.isWild());
                    break;
                case 2:
                    server.getDraw(user);
            }
        }while (opt != 3);
    }

}
