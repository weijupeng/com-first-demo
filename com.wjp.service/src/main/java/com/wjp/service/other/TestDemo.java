package com.wjp.service.other;

/**
 * @author wjp
 * @date 2019/10/29 16:14
 */
public class TestDemo {
    private static int MAX_NUM = 9;

    public static void main(String[] args) {
        new TestDemo().times();
    }

    private void times() {
        System.out.println("==================乘法口诀表==================");

        for (int i = 1; i <= MAX_NUM; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + " ");
            }
            System.out.println();
        }
    }

    private void go() {
        Pig.Big big = new Pig.Big();
        big.go();
        StringBuffer sb = new StringBuffer("spring");
        sb = sb.delete(3, 6).insert(2, "umme").deleteCharAt(1);
        System.out.println("sb = " + sb);
    }

    private void nums() {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 3, 4, 5};
        int[] c = new int[]{3, 4, 5, 6};
        int[] d = new int[]{4, 5, 6, 7};

        int[][] f = new int[][]{a, b, c, d};


        for (int i = 0; i < f.length; i++) {
            for (int i1 = 0; i1 < f[i].length; i1++) {
                System.out.print(f[i][i1]);
                if (i1 != f[i].length - 1) {
                    System.out.print("x");
                } else {
                    System.out.println();
                }
            }
        }
    }
}
