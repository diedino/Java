import java.io.*;
import java.util.*;

public class StringReverse {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        String a=sc.next();
        boolean pol=true;
        for (int i=0; i<a.length()/2; i++) {
        	if (a.charAt(i) != a.charAt(a.length()-i-1)) {
        		pol = false;
        		break;
        	}
        }
        System.out.println(pol ? "Yes" : "No");
	}
}
