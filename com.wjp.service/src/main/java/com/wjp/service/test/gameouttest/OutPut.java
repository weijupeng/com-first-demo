package com.wjp.service.test.gameouttest;

public class OutPut {
    public static void main(String[] args) {
        OutPut outPut = new OutPut();
        outPut.go();
    }

    private void go() {
        int y = 7;
        for (int x = 1; x < 8; x++) {
            y++;
            if (x > 4) {
                System.out.print(++y + " ");
            }
            if (y > 14) {
                System.out.println(" x = " + x);
                break;
            }
        }
    }
}
