package com.wjp.service.test.game;

import java.io.*;

/**
 * @author wjp
 * @date 2019/10/28 14:55
 */
public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[]{"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[]{"bow", "sword", "dust"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[]{"bow", "sword", "dust"});


        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:/Users/weijupeng/Desktop/user/Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:/Users/weijupeng/Desktop/user/Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            System.out.println("One.s type: " + oneRestore.getType());
            System.out.println("Two.s type: " + twoRestore.getType());
            System.out.println("Three.s type: " + threeRestore.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
