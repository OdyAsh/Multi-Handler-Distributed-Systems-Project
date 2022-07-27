/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhdraft2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ash
 */
public class mhC extends UnicastRemoteObject implements mhIF {
    
    Map<String, ArrayList<subIF>> groups;
    mhGUI g;
    
    mhC(mhGUI g) throws RemoteException
    {
        groups = new HashMap();
        System.out.println("started");
        this.g = g;
    }
    
    @Override
    public void subscribe(String groupName, subIF subscriber) throws RemoteException {
        groups.putIfAbsent(groupName, new ArrayList<>());
        groups.get(groupName).add(subscriber);
        System.out.println(groupName);
        System.out.println(groups.get(groupName));
        g.dispSubsOfGroups(groupName, groups.get(groupName));
    }

    @Override
    public void unsubscribe(String groupName, subIF subscriber) throws RemoteException {
        groups.get(groupName).remove(subscriber); //ALTERNATIVE WAY
        g.dispSubsOfGroups(groupName, groups.get(groupName));
    }

    @Override
    public void updateAllChatboxes(String groupName, String msg) throws RemoteException {
        if (groupName.equals("Announcements"))
            for (ArrayList<subIF> arr : groups.values())
                for (subIF sub : arr)
                    sub.updateChatbox(msg, true);
        else
            for (subIF sub : groups.get(groupName))
                    sub.updateChatbox(msg, false);
            
    }

    @Override
    public void test() throws RemoteException {
        System.out.println("TEST");
    }
    
}
