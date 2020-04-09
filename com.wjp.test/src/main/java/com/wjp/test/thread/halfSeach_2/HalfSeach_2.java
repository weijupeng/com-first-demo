package com.wjp.test.thread.halfSeach_2;

/**
 * @author wjp
 * @date 2020/2/17 11:33
 */
public class HalfSeach_2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int key = 3;
        int i = halfSeach_2(arr, key);
        System.out.println("i = " + i);

    }

    public static int halfSeach_2(int[] arr, int key) {
        int min, max, mid;
        min = 0;
        max = arr.length - 1;
        //(max+min)/2;
        mid = (max + min) >> 1;

        while (arr[mid] != key) {
            if (key > arr[mid]) {
                min = mid + 1;
            } else if (key < arr[mid]) {
                max = mid - 1;
            }
            if (max < min) {
                return -1;
            }
            mid = (max + min) >> 1;
        }
        return mid;
    }

}
