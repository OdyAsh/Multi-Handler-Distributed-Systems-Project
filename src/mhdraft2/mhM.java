/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhdraft2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Ash
 */
public class mhM {
    public static void main(String[] args) throws RemoteException {
        mhGUI g = new mhGUI();
        g.setVisible(true);
        Registry r = LocateRegistry.createRegistry(1099);
        mhC mhc = new mhC(g);
        r.rebind("students hub", mhc);
        System.out.println("Running");
    }
}
