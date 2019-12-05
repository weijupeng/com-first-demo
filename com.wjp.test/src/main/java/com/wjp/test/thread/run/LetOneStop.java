package com.wjp.test.thread.run;

/**
 * @author wjp
 * @date 2019/11/13 16:45
 */
public class LetOneStop implements Animal.Calltoback {
    Animal an;

    public LetOneStop(Animal an) {
        this.an = an;
    }

    @Override
    public void win() {
        an.stop();
    }
}
