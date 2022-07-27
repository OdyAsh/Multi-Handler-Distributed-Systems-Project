/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhdraft2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Ash
 */
public class subC extends UnicastRemoteObject implements subIF  {

    String name;
    int id;
    subGUI g;
    subC(String n, int id, subGUI g) throws RemoteException
    {
        name = n;
        this.id = id;
        this.g = g;
    }
    
    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public int getID() throws RemoteException {
        return id;
    }

    @Override
    public void updateChatbox(String msg, boolean toAll) throws RemoteException {
        g.dispMessage(msg, toAll);
    }
    
}
