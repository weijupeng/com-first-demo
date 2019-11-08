package com.wjp.service.remote.client;

import com.wjp.service.remote.service.MyRemote;

import java.rmi.Naming;

/**
 * @author wjp
 * @date 2019/10/29 11:03
 */
public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    private void go() {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/Remote");
            String s = service.sayHello();

            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
