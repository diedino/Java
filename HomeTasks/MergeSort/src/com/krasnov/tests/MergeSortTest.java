package com.krasnov.tests;

import com.krasnov.MergeSort;

import static org.junit.Assert.*;

public class MergeSortTest {

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("Setting up");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("Tear down");
    }

    @org.junit.Test
    public void mergeSortTest1() {
        int[] actual = { 2, 5, 7, 1, 5, 6, 2, 7, 5, 8 };
        int[] expected = { 1, 2, 2, 5, 5, 5, 6, 7, 7, 8 };
        MergeSort sort = new MergeSort(actual, actual.length);
        sort.run();
        assertArrayEquals(expected, actual);
    }
    @org.junit.Test
    public void mergeSortTest2() {
        int[] actual = { 6, 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        MergeSort sort = new MergeSort(actual, actual.length);
        sort.run();
        assertArrayEquals(expected, actual);
    }
    @org.junit.Test
    public void mergeSortTest3() {
        int[] actual = { 25, 47, 15, 17, 49, 31, 36, 7  };
        int[] expected = { 7, 15, 17, 25, 31, 36, 47, 49 };
        MergeSort sort = new MergeSort(actual, actual.length);
        sort.run();
        assertArrayEquals(expected, actual);
    }
    @org.junit.Test
    public void mergeSortTest4() {
        int[] actual = { 9, 5, 0, 9, 3, 7 };
        int[] expected = { 0, 3, 5, 7, 9, 9  };
        MergeSort sort = new MergeSort(actual, actual.length);
        sort.run();
        assertArrayEquals(expected, actual);
    }

}