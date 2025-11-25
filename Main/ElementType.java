package Main;

public class ElementType {
    private final String displayName;

    public static final ElementType NEUTRAL = new ElementType("Neutral");
    public static final ElementType FIRE = new ElementType("Fire");
    public static final ElementType WATER = new ElementType("Water");
    public static final ElementType GRASS = new ElementType("Grass");
    public static final ElementType ELECTRIC = new ElementType("Electric");
    public static final ElementType EARTH = new ElementType("Earth");
    public static final ElementType WIND = new ElementType("Wind");
    public static final ElementType FIGHTING = new ElementType("Fighting");
    public static final ElementType PSYCHIC = new ElementType("Psychic");
    public static final ElementType DARK = new ElementType("Dark");
    public static final ElementType STEEL = new ElementType("Steel");

    private ElementType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getEffectivenessAgainst(ElementType defenderType) {

        try {
            if (this == NEUTRAL || defenderType == NEUTRAL) {
                return 1.0;
            }

            if (this == FIRE) {
                if (defenderType == GRASS || defenderType == WIND || defenderType == STEEL) return 2.0;
                if (defenderType == WATER || defenderType == EARTH) return 0.5;
            } else if (this == WATER) {
                if (defenderType == FIRE || defenderType == EARTH) return 2.0;
                if (defenderType == GRASS || defenderType == ELECTRIC) return 0.5;
            } else if (this == GRASS) {
                if (defenderType == WATER || defenderType == EARTH) return 2.0;
                if (defenderType == FIRE || defenderType == WIND) return 0.5;
            } else if (this == ELECTRIC) {
                if (defenderType == WATER || defenderType == WIND) return 2.0;
                if (defenderType == EARTH || defenderType == STEEL) return 0.5;
            } else if (this == EARTH) {
                if (defenderType == ELECTRIC || defenderType == STEEL || defenderType == FIRE) return 2.0;
                if (defenderType == WATER || defenderType == GRASS || defenderType == DARK) return 0.5;
            } else if (this == WIND) {
                if (defenderType == GRASS || defenderType == FIGHTING) return 2.0;
                if (defenderType == FIRE || defenderType == ELECTRIC) return 0.5;
            } else if (this == FIGHTING) {
                if (defenderType == DARK || defenderType == STEEL) return 2.0;
                if (defenderType == WIND || defenderType == PSYCHIC) return 0.5;
            } else if (this == PSYCHIC) {
                if (defenderType == FIGHTING) return 2.0;
                if (defenderType == DARK || defenderType == STEEL) return 0.5;
            } else if (this == DARK) {
                if (defenderType == EARTH || defenderType == WIND) return 2.0;
                if (defenderType == FIGHTING || defenderType == STEEL) return 0.5;
            } else if (this == STEEL) {
                if (defenderType == DARK || defenderType == ELECTRIC) return 2.0;
                if (defenderType == FIRE || defenderType == EARTH) return 0.5;
            }

            return 1.0;
        } catch (Exception e) {

            System.out.println("Error calculating effectiveness: " + e.getMessage());
            return 1.0;
        }
    }

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