import java.util.Scanner;

public class Arrangement {
    static int[] arr;
    static int n;
    static int k;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        arrange(0);
    }

    public static void arrange(int index) {
        if (index == k) {
            printIntArray(arr);
        }

        for (int i = index; i < arr.length; i++) {
            swap(index, i);
            arrange(index + 1);
            swap(index, i);
        }
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printIntArray(int[] array) {
        System.out.print(count + "    ");

        for (int i=0; i<k; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();

        count++;
    }
}
