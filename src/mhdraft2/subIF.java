/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhdraft2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Ash
 */
public interface subIF extends Remote {
    public String getName() throws RemoteException;
    public int getID() throws RemoteException;
    public void updateChatbox(String msg, boolean toAll) throws RemoteException;
}
