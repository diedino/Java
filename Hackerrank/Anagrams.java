import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Anagrams {

    static boolean isAnagramWithArrays(String a, String b) {
        if (a.length() != b.length())
            return false;
        a = a.toLowerCase();
        b = b.toLowerCase();
        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();
        Arrays.sort(achar);
        Arrays.sort(bchar);
        a = new String(achar);
        b = new String(bchar);
        return a.equals(b);
    }

    static char[] sortChars(char[] a) {
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a.length; j++) {
                if (a[i]>a[j]) {
                    char swap = a[i];
                    a[i] = a[j];
                    a[j]=swap;
                }
            }
        }
        return a;
    }
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        a = a.toLowerCase();
        b = b.toLowerCase();
        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();
        achar = sortChars(achar);
        bchar = sortChars(bchar);
        a = new String(achar);
        b = new String(bchar);
        return a.equals(b);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
