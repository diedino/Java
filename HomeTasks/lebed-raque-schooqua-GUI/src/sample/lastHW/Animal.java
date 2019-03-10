package sample.lastHW;


import java.util.Random;

public class Animal {
    private String name;
    private int angle;
    private boolean active;
    private Random rand = new Random();

    public Animal(String name, int angle) {
        this.name = name;
        this.angle = angle;
        active = true;
    }

    public void moveCart(Cart cart) {
        double coef = generateValue(1, 10);
        cart.move(coef, angle);
        cart.printCoords();
        System.out.printf("%s moved cart with %f coef\n", name, coef);
        cart.printCoords();
        rest();
    }

    private void rest() {
        double sleepTime = generateValue(1000, 5000);
        try {
            Thread.sleep((long) sleepTime);
        }
        catch (Exception ex){
            System.out.println("ex is occurred =((\n");
        }
    }

    private double generateValue(int a, int b) {
        return rand.nextDouble() * (b - a) + a;
    }

    public String getName() {
        return name;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean state) {
        active = state;
    }
}
