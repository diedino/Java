import java.util.Scanner;

public class QuickSort {
    static double[] arr;
    static int length;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        length = sc.nextInt();
        arr = new double[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextDouble();
        }
        quickSort(arr, 0, length-1);
        printDoubleArr(arr);
    }

    public static void quickSort(double[] a, int left, int right) {
        int pivot = right / 2;
        int i = left, j = right;
        while (i<=j) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j]>pivot) {
                j--;
            }
            if(i<=j) {
                swap(a, i++, j--);
            }
        }
        if (left<j)
            quickSort(a, left, j);
        if (right>i)
            quickSort(a, i, right);
    }

    public static void swap(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printDoubleArr(double[] arr) {
        for (double d : arr) {
            System.out.print(d + " ");
        }
    }
}
