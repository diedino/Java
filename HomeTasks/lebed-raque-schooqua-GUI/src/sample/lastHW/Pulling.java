package sample.lastHW;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Pulling {

    private List<Animal> animals;
    private Cart cart;
    private ExecutorService executor;
    private long sleeptime;

    public Pulling(Cart cart, long sleeptime, Animal... animals) {
        this.animals = Arrays.asList(animals);
        this.cart = cart;
        this.sleeptime = sleeptime;
        executor = Executors.newFixedThreadPool(this.animals.size());
    }

    public void start() {
        List<CompletableFuture<Void>> launchedAnimals = animals
                .stream()
                .map(a -> launchAnimal(a, cart))
                .collect(Collectors.toList());
        long startingPoint = 0;
        try {
            while (startingPoint < sleeptime) {
                Thread.sleep(1000);
                startingPoint += 1000;
                System.out.printf("Current time: %s/%s\n", startingPoint, sleeptime);
                if (startingPoint % 2000 == 0) {
                    cart.printCoords();
                }
            }
            animals.forEach(a -> a.setActive(false));
            executor.shutdown();
        } catch (Exception ex) {
            System.out.println("Program is interrupted!");
            launchedAnimals.forEach(a -> a.completeExceptionally(ex));
        }
    }

    private CompletableFuture<Void> launchAnimal(Animal animal, Cart cart) {
        return CompletableFuture.supplyAsync(() -> {
            while (animal.isActive()) {
                animal.moveCart(cart);
            }
            System.out.printf("%s now is inactive\n", animal.getName());
            return null;
        }, executor);
    }
}
