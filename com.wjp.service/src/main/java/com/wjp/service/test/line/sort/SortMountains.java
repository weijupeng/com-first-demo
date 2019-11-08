package com.wjp.service.test.line.sort;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author wjp
 * @date 2019/10/29 9:37
 */
public class SortMountains {
    private ArrayList<Mountain> mtn = new ArrayList<>();

    class HeightCompare implements Comparator<Mountain> {
        @Override
        public int compare(Mountain one, Mountain two) {
            return (two.height - one.height);
        }
    }

    private void go() {
        mtn.add(new Mountain("a", 14255));
        mtn.add(new Mountain("b", 14355));
        mtn.add(new Mountain("c", 14156));
        mtn.add(new Mountain("d", 14256));

        System.out.println("as entered:\n" + mtn);

        mtn.sort((one, two) -> two.name.compareTo(one.name));
        System.out.println("as entered:\n" + mtn);

        HeightCompare heightCompare = new HeightCompare();
        mtn.sort(heightCompare);
        System.out.println("as entered:\n" + mtn);
    }

    public static void main(String[] args) {
        new SortMountains().go();
    }
}
