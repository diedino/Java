package hse.krasnov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void moveCart() {
        Animal animal = new Animal("testAnimal", 0);
        Cart cart = new Cart();
        animal.moveCart(cart);
    }

    @Test
    void isActive() {
    }
}