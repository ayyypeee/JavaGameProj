package Main;

public class MechaBeastFactory {

    public static MechaBeast createKyoflare() {
        MechaBeast beast = new MechaBeast("Kyoflare", ElementType.FIRE, "KYOFLAAAAAAARE!",
                850, 100, 250, 30);
        beast.addSkill(new Skill("Kyoryu Tail", ElementType.NEUTRAL, 30, 35, 0, 0));
        beast.addSkill(new Skill("Blaze Fangs", ElementType.FIRE, 50, 100, 50, 2));
        beast.addSkill(new Skill("Solar Burst", ElementType.FIRE, 100, 150, 100, 3));
        return beast;
    }

    public static MechaBeast createNokami() {
        MechaBeast beast = new MechaBeast("Nokami", ElementType.WATER, "NOKAMIIIIIIII!",
                800, 150, 300, 30);
        beast.addSkill(new Skill("Swift Strike", ElementType.NEUTRAL, 30, 35, 0, 0));
        beast.addSkill(new Skill("Aqua Slice", ElementType.WATER, 50, 70, 30, 1));
        beast.addSkill(new Skill("Shuriken Wave", ElementType.WATER, 80, 100, 50, 2));
        return beast;
    }

    public static MechaBeast createVineratops() {
        MechaBeast beast = new MechaBeast("Vineratops", ElementType.GRASS, "VINERAAAAAATOPS!",
                1000, 50, 250, 30);
        beast.addSkill(new Skill("Horn Charge", ElementType.NEUTRAL, 30, 35, 0, 0));
        beast.addSkill(new Skill("Horn Vines", ElementType.GRASS, 50, 80, 50, 1));
        beast.addSkill(new Skill("Horn Bloom", ElementType.GRASS, 100, 120, 100, 3));
        return beast;
    }

    public static MechaBeast createVoltchu() {
        MechaBeast beast = new MechaBeast("Voltchu", ElementType.ELECTRIC, "VOLTCHEEEEEEEW!",
                700, 200, 300, 30);
        beast.addSkill(new Skill("Quick Draw", ElementType.NEUTRAL, 30, 35, 0, 0));
        beast.addSkill(new Skill("Electric Slash", ElementType.ELECTRIC, 50, 80, 50, 1));
        beast.addSkill(new Skill("Lightning Wrath", ElementType.ELECTRIC, 100, 110, 100, 3));
        return beast;
    }

    public static MechaBeast createZyuugor() {
        MechaBeast beast = new MechaBeast("Zyuugor", ElementType.EARTH, "ZYUUUGOOOOOOOR!",
                900, 100, 250, 30);
        beast.addSkill(new Skill("Kong Fist", ElementType.NEUTRAL, 30, 35, 0, 0));
        beast.addSkill(new Skill("Mineral Bomb", ElementType.EARTH, 50, 100, 50, 1));
        beast.addSkill(new Skill("Colossus Breaker", ElementType.EARTH, 130, 150, 100, 4));
        return beast;
    }

    public static MechaBeast createPirrot() {
        MechaBeast beast = new MechaBeast("Pirrot", ElementType.WIND, "PIRROOOOOOOT!",
                800, 150, 300, 30);
        beast.addSkill(new Skill("Feather Bullet", ElementType.NEUTRAL, 30, 35, 0, 0));
        beast.addSkill(new Skill("Wing Blade", ElementType.WIND, 50, 80, 50, 1));
        beast.addSkill(new Skill("Tempest Slash", ElementType.WIND, 90, 100, 100, 2));
        return beast;
    }

    public static MechaBeast createGekuma() {
        MechaBeast beast = new MechaBeast("Gekuma", ElementType.FIGHTING, "GEKUMAAAAAAA!",
                900, 100, 200, 30);
        beast.addSkill(new Skill("Bear Claw", ElementType.NEUTRAL, 40, 50, 0, 0));
        beast.addSkill(new Skill("Power Jab", ElementType.FIGHTING, 50, 80, 50, 1));
        beast.addSkill(new Skill("Primal Strike", ElementType.FIGHTING, 100, 120, 100, 3));
        return beast;
    }

    public static MechaBeast createShadefox() {
        MechaBeast beast = new MechaBeast("Shadefox", ElementType.DARK, "SHAAADEFOOOOXX!",
                600, 100, 500, 30);
        beast.addSkill(new Skill("Sneak Bite", ElementType.NEUTRAL, 30, 35, 0, 0));
        beast.addSkill(new Skill("Crescent Claw", ElementType.DARK, 50, 70, 50, 1));
        beast.addSkill(new Skill("Phantom Slash", ElementType.DARK, 100, 120, 100, 2));
        return beast;
    }

    public static MechaBeast createKingmantis() {
        MechaBeast beast = new MechaBeast("Kingmantis", ElementType.STEEL, "KINGMAAAAAARCH!",
                2000, 1000, 0, 0);
        beast.addSkill(new Skill("Iron Jab", ElementType.NEUTRAL, 0, 0, 0, 0));
        beast.addSkill(new Skill("Twin Dagger", ElementType.STEEL, 1000, 1000, 0, 0));
        beast.addSkill(new Skill("Sovereign Blade", ElementType.STEEL, 1000, 1000, 0, 0));
        return beast;
    }

    // Boss Beasts
    public static MechaBeast createWisdrake() {
        MechaBeast beast = new MechaBeast("Wisdrake", ElementType.PSYCHIC, "WISDRAAAAAAKE!",
                1300, 110, 500, 50);
        beast.addSkill(new Skill("Logic Claw", ElementType.NEUTRAL, 50, 60, 0, 0));
        beast.addSkill(new Skill("Neuro Pulse", ElementType.PSYCHIC, 100, 150, 70, 1));
        beast.addSkill(new Skill("Temporal Rift", ElementType.PSYCHIC, 150, 200, 100, 3));
        return beast;
    }

    public static MechaBeast createWoltrix() {
        MechaBeast beast = new MechaBeast("Woltrix", ElementType.ELECTRIC, "WOLTRIIIIIIIXXX!",
                1500, 110, 600, 50);
        beast.addSkill(new Skill("Iron Fang", ElementType.NEUTRAL, 50, 60, 0, 0));
        beast.addSkill(new Skill("Volt Saber", ElementType.ELECTRIC, 150, 200, 70, 2));
        beast.addSkill(new Skill("Thunder Barrage", ElementType.ELECTRIC, 200, 300, 200, 5));
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