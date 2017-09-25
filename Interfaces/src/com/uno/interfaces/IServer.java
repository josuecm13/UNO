package com.uno.interfaces;

import java.rmi.RemoteException;

/**
 * Created by ${gaboq} on 21/9/2017.
 */

public interface IServer extends ICard,IClient {

    String getPlayers() throws RemoteException;

    void addPlayer(String ip, String username, String password) throws RemoteException;


}
