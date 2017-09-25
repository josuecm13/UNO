package com.uno.server.server;

import com.uno.interfaces.AbsCard;
import com.uno.interfaces.IServer;
import com.uno.server.card.CardFactory;
import com.uno.server.players.Player;

import javax.activity.InvalidActivityException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by ${gaboq} on 21/9/2017.
 */

public class Server extends UnicastRemoteObject implements IServer, Serializable{

    private ArrayList<Player> players;
    private Map<String, ArrayList<AbsCard>> playerCards;
    private AbsCard topCard;
    private static final long serialVersionUID = 1L;

    protected Server() throws RemoteException {
        players = new ArrayList<>();
        playerCards = new HashMap<String, ArrayList<AbsCard>>();
    }

    //ICard
    @Override
    public AbsCard generateCard(String username) throws Exception {
        AbsCard card = CardFactory.getCard();
        addToDraw(card,username);
        return card;
    }

    @Override
    public boolean validateMove(AbsCard card)throws RemoteException {
        if(card.isWild())
            return true;
        return validateColor(card) || validateNumber(card);
    }

    @Override
    public boolean validateColor(AbsCard card) throws RemoteException {
        return card.getColor() == topCard.getColor();
    }

    @Override
    public boolean validateNumber(AbsCard card) throws RemoteException {
        return card.getNumber() == topCard.getNumber();
    }

    @Override
    public void pushCard(AbsCard card) throws RemoteException {
        if(validateMove(card))
            topCard = card;
        else
            throw new InvalidActivityException("Carta invalida");
    }

    //IServer
    @Override
    public String getPlayers() throws RemoteException {
        String playerString = "";
        for (Player p: players) {
            playerString += p.getPlayer() +"\n";
        }
        return playerString;
    }

    @Override
    public void addPlayer(String ip, String username, String password) throws RemoteException {
        Player player = new Player(username,ip);
        players.add(player);
        playerCards.put(username, new ArrayList<AbsCard>());
    }

    private void addToDraw(AbsCard card, String username) throws Exception, RemoteException{
        if(!playerCards.containsKey(username)) {
            throw new Exception("No existe el usuario");
        }
        ArrayList<AbsCard> draw = playerCards.get(username);
        draw.add(card);
        playerCards.replace(username,draw);
    }

    @Override
    public String getDraw(String username) throws Exception,RemoteException {
        if(!playerCards.containsKey(username)) {
            throw new Exception("No existe el usuario");
        }
        String result = "";
        ArrayList<AbsCard> draw = playerCards.get(username);
        for (AbsCard card: draw) {
            result += "Numero " + card.getNumber() +"\n"
                    + "Color " + card.getColor() +"\n\n";
        }
        return result;
    }
}
