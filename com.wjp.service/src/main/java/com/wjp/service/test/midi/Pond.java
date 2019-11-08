package com.wjp.service.test.midi;

import com.wjp.service.test.others.Duck;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author wjp
 * @date 2019/10/28 11:32
 */
public class Pond implements Serializable {
    private transient Duck duck = new Duck();

    public static void main(String[] args) {
        Pond pond = new Pond();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/weijupeng/Desktop/user/foo2.ear");
            ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
            os.writeObject(pond);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
