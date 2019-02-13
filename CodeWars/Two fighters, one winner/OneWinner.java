import java.util.Random;

public class OneWinner {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        if (fighter1.name.equals(firstAttacker))
            return fight(fighter1, fighter2);
        else
            return fight(fighter2, fighter1);
    }

    private static String fight(Fighter first,Fighter second) {
        second.health -= first.damagePerAttack;
        if (second.health <=0) return first.name;
        return fight(second, first);
    }
    public static void main(String[] args){
        Random rnd = new Random(System.currentTimeMillis());
        Fighter fighter1 = new Fighter(args[0], 5 + rnd.nextInt(15 - 5 + 1), 1 + rnd.nextInt(5 - 1 + 1));
        Fighter fighter2 = new Fighter(args[1], 5 + rnd.nextInt(15 - 5 + 1), 1 + rnd.nextInt(5 - 1 + 1));
        if (rnd.nextInt(2) == 0) 
            System.out.println(declareWinner(fighter1, fighter2, fighter1.name));
        else
            System.out.println(declareWinner(fighter1, fighter2, fighter2.name));
    }
}

class Fighter {
    public String name;
    public int health, damagePerAttack;
    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }
}
