public class Kata {
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
