import java.math.BigInteger;
import java.util.Scanner;

public class BinPow {
    public static int binpowrecursion(int a, int b) {
        if (b==0) {
            return 1;
        }
        if (b%2==1) {
            return binpowrecursion(a, b-1)*a;
        }
        else {
            int n = binpowrecursion(a, b/2);
            return n*n;
        }
    }
    public static int binpow(int a, int b) {
        int res = 1;
        while (b>0)
            if ((b & 1) == 1) {
                res *= a;
                --b;
            }
            else {
                a *= a;
                b >>= 1;
            }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a = ");
        int a = sc.nextInt();
        System.out.print("b = ");
        int b = sc.nextInt();
        System.out.println("with recursion: " + BinPow.binpowrecursion(a,b));
        System.out.println("binpow: " + BinPow.binpow(a,b));
    }
}
