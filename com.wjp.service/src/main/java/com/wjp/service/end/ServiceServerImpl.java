package com.wjp.service.end;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 * @author wjp
 * @date 2019/10/29 11:27
 */
public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer {
    private static final long serialVersionUID = 8708040345828213323L;
    private HashMap serviceList;


    public ServiceServerImpl() throws RemoteException {
        setUpServices();
    }

    private void setUpServices() {
        serviceList = new HashMap<>(3);
        serviceList.put("Dice Rolling Service", new DiceService());
        serviceList.put("Day of the week Service", new DayOfTheWeekService());
        serviceList.put("Visual Music Service", new MiniMusicService());
    }

    @Override
    public Object[] getServiceList() throws RemoteException {
        System.out.println("in remote");
        return serviceList.keySet().toArray();
    }

    @Override
    public Service getService(Object serviceKey) throws RemoteException {
        return (Service) serviceList.get(serviceKey);
    }

    public static void main(String[] args) {
        try {
            Naming.rebind("ServiceServer", new ServiceServerImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Remote Service is Running");
    }
}
