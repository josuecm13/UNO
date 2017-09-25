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
    public static int clientID;


    public static void main(String[] args) throws Exception {
        IServer server =(IServer) Naming.lookup("//localhost/UNOServer");
        int opt;
        user = Gui.input("log in", "ingrese un nombre de usuario:");
        clientID = server.addPlayer(InetAddress.getLocalHost().getHostAddress().toString(),user, "0");
        do{
            opt = Gui.menu("UNO",new String[]{"obtener una carta", "revisar maso","Salir"});
            switch (opt){
                case 0:
                    AbsCard card = null;
                    card = server.generateCard(clientID);
                    /*System.out.println("Numero " + card.getNumber());
                    System.out.println("Color " + card.getColor());
                    System.out.println("Es Carta Especial " + card.isSpecial());
                    System.out.println("Es Carta Comodin " + card.isWild());
                    */
                    break;
                case 1:
                    System.out.println(server.getDraw(clientID));
            }
        }while (opt != 2);
    }

}
