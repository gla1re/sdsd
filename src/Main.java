package com.periphery;

import com.periphery.client.SetupClient;
import com.periphery.factory.GamingPeripheryFactory;
import com.periphery.factory.OfficePeripheryFactory;
import com.periphery.factory.PeripheryFactory;

public class Main{
    public static void main(String[] args){
        PeripheryFactory officeFactory = new OfficePeripheryFactory();
        SetupClient officeClient = new SetupClient(officeFactory);
        System.out.println("---Office Setup---");
        officeClient.displaySetup();

        PeripheryFactory gamingFactory = new GamingPeripheryFactory();
        SetupClient gamingClient = new SetupClient(gamingFactory);
        System.out.println("---Gaming Setup---");
        gamingClient.displaySetup();

        System.out.println("---Testing Validation---");
        try{
            new SetupClient(null);
        } catch(IllegalArgumentException e){
            System.err.println("Caught Epxected Error: " + e.getMessage());
        }
    }
}