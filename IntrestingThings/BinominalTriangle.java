import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinominalTriangle {
    static int arr[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int n = sc.nextInt();
        System.out.print("k = ");
        int k = sc.nextInt();
        arr = new int[n+1][n+1];
        doPascal(n+1);
        System.out.println(getPascalNumber(n,k));
    }

    public static void doPascal(int n)
    {
        for (int line = 0; line < n; line++)
        {
            for (int i = 0; i <= line; i++)
            {
                if (line == i || i == 0)
                    arr[line][i] = 1;
                else
                    arr[line][i] = arr[line-1][i-1] + arr[line-1][i];
                System.out.print(arr[line][i]);
            }
            System.out.println();
        }
    }

    public static int getPascalNumber(int n, int k) {
        return arr[n][k];
    }
}
