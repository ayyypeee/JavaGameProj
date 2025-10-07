package Main;

import java.util.ArrayList;
import java.util.List;

public class MechaBeast<Skill> {
    private final String name;
    private final ElementType type;
    private final String henshin;
    private final int maxHp;
    private int currentHp;
    private final int speed;
    private final int maxMana;
    private final int manaRegen;
    private final List<Skill> skills;

    public MechaBeast(String name, ElementType type, String henshin, int hp, int speed, int mana, int manaRegen) {
        this.name = name;
        this.type = type;
        this.henshin = henshin;
        this.maxHp = hp;
        this.currentHp = hp;
        this.speed = speed;
        this.maxMana = mana;
        this.manaRegen = manaRegen;
        this.skills = new ArrayList<>();
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


    public int getMaxHp() {
        return maxHp;
    }


    public int getSpeed() {
        return speed;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public boolean isAlive() {
        return currentHp > 0;
    }





    public MechaBeast copy() {
        MechaBeast copy = new MechaBeast(name, type, henshin, maxHp, speed, maxMana, manaRegen);
        for (Skill skill : skills) {
            copy.addSkill(new Skill(skill.name(), skill.type(),
                    skill.minPower(), skill.maxPower(),
                    skill.manaCost(), skill.cooldown()));
        }
        return copy;
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

    private final String displayName;

    ElementType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    //para sa battle system
    //strength ug weakness
    public double getEffectivenessAgainst(ElementType defenderType) {
        if (this == NEUTRAL || defenderType == NEUTRAL) {
            return 1.0;
        }

        switch (this) {
            case FIRE:
                if (defenderType == GRASS || defenderType == WIND || defenderType == STEEL) return 2.0;
                if (defenderType == WATER || defenderType == EARTH) return 0.5;
                break;

            case WATER:
                if (defenderType == FIRE || defenderType == EARTH) return 2.0;
                if (defenderType == GRASS || defenderType == ELECTRIC) return 0.5;
                break;

            case GRASS:
                if (defenderType == WATER || defenderType == EARTH) return 2.0;
                if (defenderType == FIRE || defenderType == WIND) return 0.5;
                break;

            case ELECTRIC:
                if (defenderType == WATER || defenderType == WIND) return 2.0;
                if (defenderType == EARTH || defenderType == STEEL) return 0.5;
                break;

            case EARTH:
                if (defenderType == ELECTRIC || defenderType == STEEL || defenderType == FIRE) return 2.0;
                if (defenderType == WATER || defenderType == GRASS || defenderType == DARK) return 0.5;
                break;

            case WIND:
                if (defenderType == GRASS || defenderType == FIGHTING) return 2.0;
                if (defenderType == FIRE || defenderType == ELECTRIC) return 0.5;
                break;

            case FIGHTING:
                if (defenderType == DARK || defenderType == STEEL) return 2.0;
                if (defenderType == WIND || defenderType == PSYCHIC) return 0.5;
                break;

            case PSYCHIC:
                if (defenderType == FIGHTING) return 2.0;
                if (defenderType == DARK || defenderType == STEEL) return 0.5;
                break;

            case DARK:
                if (defenderType == EARTH || defenderType == WIND) return 2.0;
                if (defenderType == FIGHTING || defenderType == STEEL) return 0.5;
                break;

            case STEEL:
                if (defenderType == DARK || defenderType == ELECTRIC) return 2.0;
                if (defenderType == FIRE || defenderType == EARTH) return 0.5;
                break;
        }

        return 1.0;
    }
    //message for effectiveness
    public String getEffectivenessMessage(ElementType defenderType) {
        double effectiveness = getEffectivenessAgainst(defenderType);

        if (effectiveness == 2.0) {
            return "It's SUPER EFFECTIVE! 💥";
        } else if (effectiveness == 0.5) {
            return "It's not very effective... 💨";
        } else {
            return "";
        }
    }
}
    //weakness

        //Skill system
    //Stats management (HP, Speed, Mana)
    //Beast.Beast selection



