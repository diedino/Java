import java.util.Scanner;

public class Passphase {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String str = reader.next();
		int n = reader.nextInt();
		System.out.println(playPass(str, n));
	}
	public static String playPass(String s, int n) {
		String result = shifting(s, n);
		return result;
	}
	public static String shifting(String str, int shift) {
		String result="";
        for(int i=0; i< str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                result += (char) (((str.charAt(i) - 'a' + shift) % 26) + 'a');
            else
                result += (char) (((str.charAt(i) - 'A' + shift) % 26) + 'A');
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            	result += 9 - str.charAt(i);
            }
            result += str.charAt(i);
        }
        return result;
	}
}