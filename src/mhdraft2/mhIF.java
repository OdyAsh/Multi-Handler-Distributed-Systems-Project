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
public interface mhIF extends Remote {
    public void subscribe(String groupName, subIF subscriber) throws RemoteException;
    public void unsubscribe(String groupName, subIF subscriber) throws RemoteException;
    public void updateAllChatboxes(String groupName, String msg) throws RemoteException;
    public void test() throws RemoteException;
}
