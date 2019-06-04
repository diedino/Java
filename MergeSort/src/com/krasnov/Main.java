package com.krasnov;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    Scanner scan = new Scanner(System.in);
    /*
     * n - value for length of array. array.length = 2*n
     * m - max value of array's element
     */
    static int n, m;
    static int[] arr;
    /*
     * start - beginning of algorithm working
     * timeConsumedNanos - total time in nsec
     */
    static long start, timeConsumedNanos;
    static String output;

    public static void main(String[] args) {
        try {
            setArgs(args[0], args[1]);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.print("Exception: args is incomplete");
        }
        fillArray(n);
        printArray(arr);
        int[] subArr1 = new int[arr.length/2];
        int[] subArr2 = new int[arr.length - arr.length/2];
        System.arraycopy(arr, 0, subArr1, 0, arr.length/2);
        System.arraycopy(arr, arr.length/2, subArr2, 0, arr.length - arr.length/2);
        MergeSort mergeSort = new MergeSort(arr, 2*n);
        Thread sort = new Thread(mergeSort);
        sort.setName("First sort");
        sort.start();
        try {
            sort.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printArray(arr);
        MergeSort part1 = new MergeSort(subArr1, subArr1.length);
        Thread sortPart1 = new Thread(part1);
        sortPart1.setName("Part 1");
        MergeSort part2 = new MergeSort(subArr1, subArr1.length);
        Thread sortPart2 = new Thread(part2);
        sortPart2.setName("Part 2");
        sortPart1.start();
        sortPart2.start();
        try {
            sortPart1.join();
            sortPart2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(part2.getTimeConsumedNanos());
    }
    private static void fillArray(int n) {
        arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(0, m + 1);
        }
    }
    private static void setArgs(String arg1, String arg2){
        n = Integer.valueOf(arg1);
        m = Integer.valueOf(arg2);
    }
    private static void printArray(int[] arr) {
        for (int a : arr
        ) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
   /* private void startThread(int[] arr, String name) {
        MergeSort mergeSort = new MergeSort(arr, arr.length);
        Thread sort = new Thread(mergeSort);
        sort.setName(name);
        sort.start();
        try {
            sort.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}
