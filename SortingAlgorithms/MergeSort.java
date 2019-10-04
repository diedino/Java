import java.util.Scanner;

public class MergeSort {
    static int length;
    static double[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        length = sc.nextInt();
        arr = new double[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextDouble();
        }
        mergeSort(arr, length);
        printDoubleArr(arr);
    }

    public static void mergeSort(double[] a, int n) {
        if (n < 2)
            return;
        int middle = n / 2;
        double[] l = new double[middle]; // left subarray
        double[] r = new double[n - middle]; // right subarray
        for (int i = 0; i < middle; i++) {
            l[i] = a[i];
        }
        for (int i = middle; i < n; i++) {
            r[i-middle] = a[i];
        }
        mergeSort(l, middle); // recursive for left part
        mergeSort(r, n - middle); // recursive for right part
        merge(a, l, r, middle, n - middle);
    }

    public static void merge(double[] a, double[] l, double[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) // compare elements from 2 subarrays
                a[k++] = l[i++];
            else
                a[k++] = r[j++];
        }
        // others
        while (i < left)
            a[k++] = l[i++];
        while (j < right)
            a[k++] = r[j++];
    }

    public static void printDoubleArr(double[] arr) {
        for (double d : arr) {
            System.out.print(d + " ");
        }
    }
}
