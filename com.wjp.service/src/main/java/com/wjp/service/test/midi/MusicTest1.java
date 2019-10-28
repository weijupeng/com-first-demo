package com.wjp.service.test.midi;

import javax.sound.midi.*;

/**
 * @author wjp
 * @date 2019/10/25 15:05
 */
public class MusicTest1 {
    public static void main(String[] args) {
        MusicTest1 test1 = new MusicTest1();
        test1.play();
    }

    private void play() {
        try {

            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track t = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);

            MidiEvent noteOn = new MidiEvent(a, 1);

            t.add(noteOn);

            player.setSequence(seq);

            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
