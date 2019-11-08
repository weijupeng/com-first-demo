package com.wjp.service.remote.service;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * @author wjp
 * @date 2019/10/29 10:58
 */
public class MyRemoteImpl implements MyRemote {
    @Override
    public String sayHello() {
        return "Server say, 'Hey'";
    }

    public MyRemoteImpl() throws RemoteException {
    }

    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("Remote", service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
