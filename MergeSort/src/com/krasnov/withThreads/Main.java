package com.krasnov.withThreads;

import com.krasnov.MergeSort;
import com.krasnov.WriteFile;

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
    static long totalTimeParts;
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
        eraseFile("results/results.txt");
        fillArray(n);
        printArray(arr);
        int[] subArr1 = new int[arr.length/2];
        int[] subArr2 = new int[arr.length - arr.length/2];
        System.arraycopy(arr, 0, subArr1, 0, arr.length/2);
        System.arraycopy(arr, arr.length/2, subArr2, 0, arr.length - arr.length/2);
        MergeSort firstSort = startThread(arr, "First Sort");
        printArray(arr);
        MergeSort part1 = startThread(subArr1, "Part 1");
        MergeSort part2 = startThread(subArr2, "Part 2");
        long start = System.nanoTime();
        finalMerge(subArr1, subArr2);
        long sortedCombine = System.nanoTime() - start;
        String sortedCombineOutput = "Sorted combining time: "+sortedCombine+"\n";
        System.out.print(sortedCombineOutput);
        WriteFile.writeUsingFileWriter(sortedCombineOutput);
        String totalTimeOutput = String.format("Total sorting time: %d\n", sortedCombine+part1.getTimeConsumedNanos()+part2.getTimeConsumedNanos());
        System.out.print(totalTimeOutput);
        WriteFile.writeUsingFileWriter(totalTimeOutput);
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
    private static MergeSort startThread(int[] arr, String name) {
        MergeSort mergeSort = new MergeSort(arr, arr.length);
        Thread sort = new Thread(mergeSort);
        sort.setName(name);
        sort.start();
        try {
            sort.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  mergeSort;
    }

    private static int[] finalMerge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i=0;
        int j=0;
        int r=0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[r]=a[i];
                i++;
                r++;
            } else {
                result[r]=b[j];
                j++;
                r++;
            }
            if (i==a.length) {
                while (j<b.length) {
                    result[r]=b[j];
                    r++;
                    j++;
                }
            }
            if (j==b.length) {
                while (i<a.length) {
                    result[r]=a[i];
                    r++;
                    i++;
                }
            }
        }
        return result;
    }
    private static void eraseFile(String str) {
        File myFile = new File(str);
        if (myFile.exists()) {
            myFile.delete();
            try {
                myFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
