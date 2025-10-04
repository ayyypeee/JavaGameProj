package Main;

import java.util.ArrayList;
import java.util.List;

public class MechaBeast {
    private final String name;
    private final ElementType type;
    private final String henshin;
    private final int maxHp;
    private int currentHp;
    private final int speed;
    private final int maxMana;
    private int currentMana;
    private final int manaRegen;
    private final List<Skill> skills;
    private final int[] skillCooldowns;

    public MechaBeast(String name, ElementType type, String henshin, int hp, int speed, int mana, int manaRegen) {
        this.name = name;
        this.type = type;
        this.henshin = henshin;
        this.maxHp = hp;
        this.currentHp = hp;
        this.speed = speed;
        this.maxMana = mana;
        this.currentMana = mana;
        this.manaRegen = manaRegen;
        this.skills = new ArrayList<>();
        this.skillCooldowns = new int[3];
    }

    public void addSkill(Skill skill) {
        if (skills.size() < 3) {
            skills.add(skill);
        }
    }

    public String getName() {
        return name;
    }

    public ElementType getType() {
        return type;
    }

    public String getHenshin() {
        return henshin;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
    enum ElementType {
        NEUTRAL("Neutral"),
        FIRE("Fire"),
        WATER("Water"),
        GRASS("Grass"),
        ELECTRIC("Electric"),
        EARTH("Earth"),
        WIND("Wind"),
        FIGHTING("Fighting"),
        PSYCHIC("Psychic"),
        DARK("Dark"),
        STEEL("Steel");
    }
    //weakness

        //Skill system
    //Stats management (HP, Speed, Mana)
    //Beast.Beast selection



