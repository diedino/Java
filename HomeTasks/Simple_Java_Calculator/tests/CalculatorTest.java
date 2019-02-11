import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest { // testing class
    private static final double DELTA = 1e-3;

    @org.junit.jupiter.api.Test
    void getOp() {
        assertEquals(new Calculator(10, 10, 1).getOp(), "+");
        assertEquals(new Calculator(10, 10, 2).getOp(), "-");
        assertEquals(new Calculator(10, 10, 3).getOp(), "*");
        assertEquals(new Calculator(10, 10, 4).getOp(), "/");
    }

    @org.junit.jupiter.api.Test
    void calculate() {
    }

    @org.junit.jupiter.api.Test
    void addition() {
        Calculator calc = new Calculator(10, 10, 1);
        calc.calculate();
        assertEquals(calc.result, 20);
        Calculator calc1 = new Calculator(15.5f, 10.3f, 1);
        calc1.calculate();
        assertEquals(calc1.result, 25.8f);
        Calculator calc2 = new Calculator(6, 6.7f, 1);
        calc2.calculate();
        assertEquals(calc2.result, 12.7f);
    }

    @org.junit.jupiter.api.Test
    void substraction() {
        Calculator calc = new Calculator(10, 10, 2);
        calc.calculate();
        assertEquals(calc.result, 0);
        Calculator calc1 = new Calculator(15.5f, 10.3f, 2);
        calc1.calculate();
        assertEquals(calc1.result, 5.2f);
    }

    @org.junit.jupiter.api.Test
    void multiplication() {
        Calculator calc = new Calculator(10, 10, 3);
        calc.calculate();
        assertEquals(calc.result, 100);
    }

    @org.junit.jupiter.api.Test
    void division() {
        Calculator calc = new Calculator(10, 10, 4);
        calc.calculate();
        assertEquals(calc.result, 1);
    }
}