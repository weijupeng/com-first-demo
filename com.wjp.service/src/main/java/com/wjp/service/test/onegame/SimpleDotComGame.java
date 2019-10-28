package com.wjp.service.test.onegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author weijupeng
 */
public class SimpleDotComGame {
    public static void main(String[] args) {
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();
        DotCom theDotCom = new DotCom();
        int randomNum = new Random().nextInt(4) + 1;
        List<Integer> list = new ArrayList<>();
        list.add(randomNum);
        list.add(randomNum + 1);
        list.add(randomNum + 2);
//        theDotCom.setLocationCells(integers);
        boolean isAlive = true;
        while (isAlive) {
            String guess = helper.getUserInput("enter a number");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if ("kill".equals(result)) {
                isAlive = false;
                System.out.println("you take " + numOfGuesses + " guesses");
            }
        }
    }
}
