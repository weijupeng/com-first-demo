package com.wjp.service.remote.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author wjp
 * @date 2019/10/29 10:56
 */
public interface MyRemote extends Remote {
    /**
     * sayHello
     *
     * @return string
     * @throws RemoteException 异常
     */
    String sayHello() throws RemoteException;
}
