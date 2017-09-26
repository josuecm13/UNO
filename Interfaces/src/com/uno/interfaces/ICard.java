package com.uno.interfaces;

import com.uno.cards.AbsCard;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by ${gaboq} on 20/9/2017.
 */

public interface ICard extends Remote {

    AbsCard generateCard(int userID) throws Exception;

    boolean validateMove(AbsCard card) throws RemoteException;

    boolean validateColor(AbsCard card) throws RemoteException;

    boolean validateNumber(AbsCard card) throws RemoteException;

    void pushCard(AbsCard card) throws RemoteException;

}
