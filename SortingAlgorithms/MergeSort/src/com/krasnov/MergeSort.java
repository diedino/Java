package com.krasnov;

public class MergeSort implements Runnable {

    int[] a;
    int n;
    String output;
    long timeConsumedNanos;
    public MergeSort(int[] a, int n){
        this.a = a;
        this.n = n;
    }

    public void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }
    private void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    @Override
    public void run() {
        long start = System.nanoTime();
        mergeSort(a, n);
        timeConsumedNanos = System.nanoTime() - start;
        Thread thread = Thread.currentThread();
        output = thread.getName()+": "+"Sequential sorting time = "+timeConsumedNanos+" nsec\n";
        System.out.print(output);
        WriteFile.writeUsingFileWriter(output);
    }

    public String getOutput() {
        return output;
    }

    public long getTimeConsumedNanos() {
        return timeConsumedNanos;
    }
}
