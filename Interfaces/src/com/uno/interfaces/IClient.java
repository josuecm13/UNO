package com.uno.interfaces;

import java.io.Serializable;
import java.rmi.RemoteException;

public interface IClient extends Serializable {

    String getDraw(int clientID) throws RemoteException, Exception;

}
