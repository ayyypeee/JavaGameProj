package Main;

import java.util.Random;

public class Skill {

    // Random number generator for damage calculation
    private static final Random random = new Random();

    private final String name;          // Name of the skill
    private final ElementType type;     // Element type
    private final int minPower;         // Minimum damage
    private final int maxPower;         // Maximum damage
    private final int manaCost;         // How much mana it costs to use
    private final int cooldown;         // How many turns before can use again

    public Skill(String name, ElementType type, int minPower, int maxPower,
                 int manaCost, int cooldown) {
        this.name = name;
        this.type = type;
        this.minPower = minPower;
        this.maxPower = maxPower;
        this.manaCost = manaCost;
        this.cooldown = cooldown;
    }

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

    public int calculateDamage() {

        if (maxPower <= minPower) {
            return minPower;
        }

        return random.nextInt(maxPower - minPower + 1) + minPower;
    }

    public String getDescription() {
        return String.format("%s (%s) | Power: %d-%d | Mana: %d | CD: %d",
                name,
                type.getDisplayName(),
                minPower,
                maxPower,
                manaCost,
                cooldown);
    }
}