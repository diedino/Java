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

