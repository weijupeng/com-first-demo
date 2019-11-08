package com.wjp.service.test.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author wjp
 * @date 2019/10/28 15:16
 */
class ReadaFile {

    public static void main(String[] args) {
        try {
            File file = new File("C:/Users/weijupeng/Desktop/user/3.0发版须知");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
