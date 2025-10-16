package Main;

public class MechaBeastFactory {

    public static MechaBeast createKyoflare() {
        MechaBeast beast = new MechaBeast("Kyoflare", ElementType.FIRE, "Kyoryuger",
                820, 105, 300, 25);
        beast.addSkill(new Skill("Kyoryu Tail", ElementType.NEUTRAL, 28, 35, 0, 0));
        beast.addSkill(new Skill("Blaze Fangs", ElementType.FIRE, 65, 80, 50, 1));
        beast.addSkill(new Skill("Solar Burst", ElementType.FIRE, 110, 130, 90, 3));
        return beast;
    }

    public static MechaBeast createNokami() {
        MechaBeast beast = new MechaBeast("Nokami", ElementType.WATER, "Shurikenger",
                770, 115, 280, 20);
        beast.addSkill(new Skill("Swift Strike", ElementType.NEUTRAL, 28, 35, 0, 0));
        beast.addSkill(new Skill("Aqua Slice", ElementType.WATER, 60, 70, 45, 1));
        beast.addSkill(new Skill("Shuriken Wave", ElementType.WATER, 85, 105, 70, 2));
        return beast;
    }

    public static MechaBeast createVineratops() {
        MechaBeast beast = new MechaBeast("Vineratops", ElementType.GRASS, "Zyuuranger",
                940, 85, 260, 30);
        beast.addSkill(new Skill("Horn Charge", ElementType.NEUTRAL, 22, 28, 0, 0));
        beast.addSkill(new Skill("Horn Vines", ElementType.GRASS, 70, 80, 55, 1));
        beast.addSkill(new Skill("Horn Bloom", ElementType.GRASS, 100, 120, 80, 3));
        return beast;
    }

    public static MechaBeast createVoltchu() {
        MechaBeast beast = new MechaBeast("Voltchu", ElementType.ELECTRIC, "Shinkenger",
                760, 120, 270, 18);
        beast.addSkill(new Skill("Quick Draw", ElementType.NEUTRAL, 28, 35, 0, 0));
        beast.addSkill(new Skill("Electric Slash", ElementType.ELECTRIC, 65, 75, 50, 1));
        beast.addSkill(new Skill("Lightning Wrath", ElementType.ELECTRIC, 95, 110, 85, 3));
        return beast;
    }

    public static MechaBeast createZyuugor() {
        MechaBeast beast = new MechaBeast("Zyuugor", ElementType.EARTH, "Zyuohger",
                1000, 75, 320, 35);
        beast.addSkill(new Skill("Kong Fist", ElementType.NEUTRAL, 22, 28, 0, 0));
        beast.addSkill(new Skill("Mineral Bomb", ElementType.EARTH, 75, 85, 60, 1));
        beast.addSkill(new Skill("Colossus Breaker", ElementType.EARTH, 120, 140, 100, 4));
        return beast;
    }

    public static MechaBeast createPirrot() {
        MechaBeast beast = new MechaBeast("Pirrot", ElementType.WIND, "Gokaiger",
                780, 118, 260, 20);
        beast.addSkill(new Skill("Feather Bullet", ElementType.NEUTRAL, 28, 35, 0, 0));
        beast.addSkill(new Skill("Wing Blade", ElementType.WIND, 65, 75, 50, 1));
        beast.addSkill(new Skill("Tempest Slash", ElementType.WIND, 95, 115, 80, 2));
        return beast;
    }

    public static MechaBeast createGekuma() {
        MechaBeast beast = new MechaBeast("Gekuma", ElementType.FIGHTING, "Gekiranger",
                860, 95, 290, 28);
        beast.addSkill(new Skill("Bear Claw", ElementType.NEUTRAL, 28, 35, 0, 0));
        beast.addSkill(new Skill("Power Jab", ElementType.FIGHTING, 65, 75, 50, 1));
        beast.addSkill(new Skill("Primal Strike", ElementType.FIGHTING, 90, 110, 75, 3));
        return beast;
    }

    public static MechaBeast createShadefox() {
        MechaBeast beast = new MechaBeast("Shadefox", ElementType.DARK, "Lupinranger",
                750, 119, 280, 20);
        beast.addSkill(new Skill("Sneak Bite", ElementType.NEUTRAL, 28, 35, 0, 0));
        beast.addSkill(new Skill("Crescent Claw", ElementType.DARK, 65, 75, 50, 1));
        beast.addSkill(new Skill("Phantom Slash", ElementType.DARK, 90, 100, 80, 2));
        return beast;
    }

    // OP mecha beast
    public static MechaBeast createKingmantis() {
        MechaBeast beast = new MechaBeast("Kingmantis", ElementType.STEEL, "KingOhger",
                1200, 110, 400, 50);
        beast.addSkill(new Skill("Iron Jab", ElementType.NEUTRAL, 40, 75, 0, 0));
        beast.addSkill(new Skill("Twin Dagger", ElementType.STEEL, 90, 100, 55, 1));
        beast.addSkill(new Skill("Sovereign Blade", ElementType.STEEL, 1000, 1000, 0, 0));
        return beast;
    }

    // Boss Beasts
    public static MechaBeast createWisdrake() {
        MechaBeast beast = new MechaBeast("Wisdrake", ElementType.PSYCHIC, "Timeranger",
                860, 98, 360, 35);
        beast.addSkill(new Skill("Logic Claw", ElementType.NEUTRAL, 28, 36, 0, 0));
        beast.addSkill(new Skill("Neuro Pulse", ElementType.PSYCHIC, 65, 82, 55, 1));
        beast.addSkill(new Skill("Temporal Rift", ElementType.PSYCHIC, 120, 138, 95, 3));
        return beast;
    }

    public static MechaBeast createWoltrix() {
        MechaBeast beast = new MechaBeast("Woltrix", ElementType.ELECTRIC, "Dekaranger",
                1350, 110, 520, 50);
        beast.addSkill(new Skill("Iron Fang", ElementType.NEUTRAL, 40, 50, 0, 0));
        beast.addSkill(new Skill("Volt Saber", ElementType.ELECTRIC, 95, 115, 75, 2));
        beast.addSkill(new Skill("Thunder Barrage", ElementType.ELECTRIC, 150, 190, 120, 4));
        return beast;
    }

    // Returns array of all beasts
    public static MechaBeast[] getAllStarterBeasts() {
        MechaBeast[] starters = new MechaBeast[9];
        starters[0] = createKyoflare();
        starters[1] = createNokami();
        starters[2] = createVineratops();
        starters[3] = createVoltchu();
        starters[4] = createZyuugor();
        starters[5] = createPirrot();
        starters[6] = createGekuma();
        starters[7] = createShadefox();
        starters[8] = createKingmantis();
        return starters;
    }
}