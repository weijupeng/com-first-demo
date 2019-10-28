package com.wjp.service.test.objecttest;

class DrumKitTestDrive {
    public static void main(String[] args) {
        DrumKit d = new DrumKit();
        d.snare = false;
        d.playSnare();
        d.playTopHat();
        if (d.snare) {
            d.playSnare();
        }
    }
}