package com.uno.interfaces;

import java.io.Serializable;
import java.rmi.RemoteException;

public interface IClient extends Serializable {

    String getDraw(String username) throws RemoteException, Exception;

}
