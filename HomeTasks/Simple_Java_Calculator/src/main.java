
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.Clock;

class main {
    public static void main(String[] args) {
        boolean xInit, yInit, isFloat, opInit;
        Number x = null, y = null;
        int op=0;
        Scanner in = new Scanner(System.in);
        /**
         * regular expression for checking input string
         */
        String rePattern = "(-)?\\d+(\\.\\d+)?";
        Matcher re;
        while (true) {
            xInit = false;
            yInit = false;
            opInit = false;
            isFloat = false;
            while (!xInit || !yInit || !opInit) {
                String input = in.nextLine();
                re = Pattern.compile(rePattern).matcher(input);
                /**
                 * check is this exit
                 */
                if (input.contains("exit")) {
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String formatDateTime = now.format(formatter);
                    System.out.println(formatDateTime + "\nBye!");
                    return;
                    /**
                     * check is there = sign
                     */
                } else if (input.contains("=")) {
                    boolean isX = input.toLowerCase().contains("x");
                    boolean isY = input.toLowerCase().contains("y");
                    isFloat = input.toLowerCase().contains("f") || input.toLowerCase().contains(".");
                    if (isX && re.find()) {
                        xInit = true;
                        try {
                            if (isFloat) {
                                x = Float.parseFloat(re.group());
                                System.out.println("Now x = " + (float) x);
                            } else {
                                x = Integer.parseInt(re.group());
                                System.out.println("Now x = " + (int) x);
                            }
                        }
                        /**
                         * exception with number more than float
                         */
                        catch (NumberFormatException e) {
                            System.out.println("This number is too much");
                        }
                    } else if (isY && re.find()) {
                        yInit = true;
                        try {
                            if (isFloat) {
                                y = Float.parseFloat(re.group());
                                System.out.println("Now y = " + (float) y);
                            } else {
                                y = Integer.parseInt(re.group());
                                System.out.println("Now y = " + (int) y);
                            }
                        }
                        /**
                         * exception with number more than float
                         */
                        catch (NumberFormatException e){
                            System.out.println("This number is too much");
                        }
                    } else {
                        System.out.println("Can't understand such variable");
                    }
                } else if (input.contains("+")) {
                    op = 1;
                    opInit = true;
                    System.out.println("Now calculator have operator '+'");
                } else if (input.contains("-")) {
                    op = 2;
                    opInit = true;
                    System.out.println("Now calculator have operator '-'");
                } else if (input.contains("*")) {
                    op = 3;
                    opInit = true;
                    System.out.println("Now calculator have operator '*'");
                } else if (input.contains("/")) {
                    op = 4;
                    opInit = true;
                    System.out.println("Now calculator have operator '/'");
                } else {
                    System.out.println("Wrong operand");
                }
            }
            try {
                /**
                 * doing calculation
                 */
                Calculator calc = new Calculator(x, y, op);
                calc.calculate();
            }
            /**
             * divided by zero or another arithmetic errors
             */
            catch (ArithmeticException e) {
                System.out.println("You can't divide by zero");
            }
        }
    }
}
