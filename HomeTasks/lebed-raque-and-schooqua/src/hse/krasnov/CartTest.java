package hse.krasnov;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    @Test
    public void move() {
        Cart cart = new Cart();
        cart.move(5,0);
        assertEquals(5, cart.getX());
        cart.move(10, 90);
        assertEquals(8.939966636005579, cart.getY());
    }

    @Test
    public void printCoords() {

    }
}