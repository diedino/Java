public class Money {
    public static int calculateYears(double principal, double interest,  double tax, double desired) {
        int years = 0;
        while (principal < desired) {
            principal += principal*interest*(1-tax);
            years++;
        }
        return years;
    }
     public static void main(String[] args){
    	System.out.println(calculateYears(Double.valueOf(args[0]),Double.valueOf(args[1]),Double.valueOf(args[2]), Double.valueOf(args[3])));
    }
}