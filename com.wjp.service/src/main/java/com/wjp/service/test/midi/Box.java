package com.wjp.service.test.midi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author wjp
 * @date 2019/10/28 11:27
 */
public class Box implements Serializable {
    private int height;
    private int width;

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public static void main(String[] args) {
        Box box = new Box();
        box.setHeight(1);
        box.setWidth(2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/weijupeng/Desktop/user/foo.ear");
            ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
            os.writeObject(box);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
