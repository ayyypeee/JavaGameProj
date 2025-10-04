package Main;

public class BeastFactory {
    public static MechaBeast createKyoflare() {
        MechaBeast beast = new MechaBeast("Kyoflare", ElementType.FIRE, "Kyoryuger",
                820, 105, 300, 25);
        beast.addSkill(new Skill("Kyoryu Tail", ElementType.NEUTRAL, 28, 35, 0, 0));
        beast.addSkill(new Skill("Blaze Fangs", ElementType.FIRE, 65, 80, 50, 1));
        beast.addSkill(new Skill("Solar Burst", ElementType.FIRE, 110, 130, 90, 3));
        return beast;
    }
    public static MechaBeast createNokami () {
        MechaBeast beast = new MechaBeast("Nokami ", ElementType.FIRE, "Kyoryuger",
                820, 105, 300, 25);
        beast.addSkill(new Skill("Kyoryu Tail", ElementType.NEUTRAL, 28,     35, 0, 0));
        beast.addSkill(new Skill("Blaze Fangs", ElementType.FIRE, 65, 80, 50, 1));
        beast.addSkill(new Skill("Solar Burst", ElementType.FIRE, 110, 130, 90, 3));
        return beast;
    }


}
