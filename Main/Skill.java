
package Main;

import java.util.Random;

public class Skill {
    private static final Random rand = new Random();

    private final String name;
    private final ElementType type;
    private final int minPower;
    private final int maxPower;
    private final int manaCost;
    private final int cooldown;

    public Skill(String name, ElementType type, int minPower, int maxPower, int manaCost, int cooldown) {
        this.name = name;
        this.type = type;
        this.minPower = minPower;
        this.maxPower = maxPower;
        this.manaCost = manaCost;
        this.cooldown = cooldown;
    }

    // getter
    public String name() {
        return name;
    }

    public ElementType type() {
        return type;
    }

    public int minPower() {
        return minPower;
    }

    public int maxPower() {
        return maxPower;
    }

    public int manaCost() {
        return manaCost;
    }

    public int cooldown() {
        return cooldown;
    }

    // random damage
    public int calculateDamage() {
        if (maxPower <= minPower)
            return minPower;
        return rand.nextInt(maxPower - minPower + 1) + minPower;
    }

    public String getDescription() {
        return String.format("%s (%s) | Power: %d-%d | Mana: %d | CD: %d",
                name, type.getDisplayName(), minPower, maxPower, manaCost, cooldown);
    }
}
