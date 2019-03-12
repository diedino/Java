public class NegativeZeroValidator {
    public static boolean isNegativeZero(Float n) {
    	return n.equals(-0f);
    }

    public static void main(String[] args) {
    	System.out.println(isNegativeZero(-0f));
    }
}