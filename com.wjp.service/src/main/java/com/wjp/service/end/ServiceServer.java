package com.wjp.service.end;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author wjp
 * @date 2019/10/29 11:25
 */
public interface ServiceServer extends Remote {
    Object[] getServiceList() throws RemoteException;

    Service getService(Object serviceKey) throws RemoteException;
}
