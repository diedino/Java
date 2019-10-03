import java.util.Scanner;

public class Permutations {
    private static int[] arr;

    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }
        permutations(0);
    }


    private static void permutations(int index) {
        if (index == arr.length - 1)
            printIntArray(arr);

        for (int i = index; i < arr.length; i++) {
            swap(index, i);
            permutations(index + 1);
            swap(index, i);
        }
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printIntArray(int[] arr) {
        System.out.print(count + "    ");

        for (int a :  arr) {
            System.out.print(a + " ");
        }

        System.out.println();

        count++;
    }
}
