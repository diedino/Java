package hse.krasnov;

public class Cart {
    private double x, y;

    public Cart(){
        x = 0;
        y = 0;
    }
    public Cart(double x, double y) {
        this.x = x;
        this.y = y;
    }

    synchronized public void move(double coef, int angle) {
        x = coef * Math.cos((double) angle);
        y = coef * Math.sin((double) angle);
    }

    public void printCoords() {
        System.out.printf("Cart coords ----- x: %f; y: %f \n", x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
