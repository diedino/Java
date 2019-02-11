package hse.krasnov;

/*
Krasnov Vasiliy, 173_2
* */

public class Main {

    public static void main(String... args) {
        Cart cart;
        if (args.length == 0) {
            cart = new Cart();
        }
        else {
            cart = new Cart(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        }
        Pulling pulling = new Pulling(
                cart,
                new Animal("lebed", 60),
                new Animal("raque", 180),
                new Animal("schooqua", 300));
        pulling.start();
    }
}
