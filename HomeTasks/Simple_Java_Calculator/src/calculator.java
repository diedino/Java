/**
 * constructor
 */
class Calculator {
    private Number x;
    private Number y;
    private boolean xIsFloat;
    private boolean yIsFloat;
    private int op;
    public Number result = null;
    public Calculator(Number x, Number y, int op){
        this.x = x;
        xIsFloat = x instanceof Float; // checking float
        this.y = y;
        yIsFloat = y instanceof Float; // checking float
        this.op = op;
    }

    /**
     * method with return our operation
     * @return string with operation
     */
    public String getOp() {
        if(op == 1) return "+";
        if(op == 2) return "-";
        if(op == 3) return "*";
        if(op == 4) return "/";
        return "";
    }

    /**
     * method which print result in console
     */
    public void calculate()
    {
        String usrResult = "";
        if (op == 1) addition();
        if (op == 2) substraction();
        if (op == 3) multiplication();
        if (op == 4) division();
        if (xIsFloat) usrResult += (float) x + " ";
        else usrResult += (int) x + " ";

        usrResult += getOp() + " ";

        if (yIsFloat) usrResult += (float) y + " = ";
        else usrResult += (int) y + " = ";

        if (xIsFloat || yIsFloat) usrResult += (float) result;
        else usrResult += (int) result;

        System.out.println(usrResult);
    }

    /**
     * method for addition
     */
    public void addition() {
        if (xIsFloat) {
            if (yIsFloat) result = (float)x+(float)y;
            else result = (float) x+(int) y;
        } else if (yIsFloat) result = (int) x + (float) y;
        else result = (int) x+(int) y;
    }
    public void substraction() {
        if (xIsFloat) {
            if (yIsFloat) result = (float) x - (float) y;
            else result = (float) x - (int) y;
        } else if (yIsFloat) result = (int) x - (float) y;
        else result = (int) x - (int) y;
    }
    public void multiplication() {
        if (xIsFloat) {
            if (yIsFloat) result = (float)x * (float)y;
            else result = (float) x * (int) y;
        } else if (yIsFloat) result = (int) x * (float) y;
        else result = (int) x * (int) y;
    }
    public void division() {
        if (xIsFloat) {
            if (yIsFloat) result = (float)x / (float)y;
            else result = (float) x /(int) y;
        } else if (yIsFloat) result = (int) x /(float) y;
        else {
            result = (int) x / (int) y;
        }
    }
}
