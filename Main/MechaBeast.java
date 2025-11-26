package Main;

// MechaBeast is a subclass of BattleEntity
public class MechaBeast extends BattleEntity {

    private ElementType type;
    private String henshin;
    private int manaRegen;
    private Skill[] skills;
    private int[] skillCooldowns;
    private int skillCount;

    public MechaBeast(String name, ElementType type, String henshin, int hp, int speed, int mana, int manaRegen) {
        super(name, hp, speed, manaRegen);
        this.type = type;
        this.henshin = henshin;
        this.maxMana = mana;
        this.mana = mana;
        this.manaRegen = manaRegen;
        this.skills = new Skill[3];
        this.skillCooldowns = new int[3];
        this.skillCount = 0;
    }

    public void addSkill(Skill skill) {
        try {
            if (skillCount < 3) {
                skills[skillCount] = skill;
                skillCount++;
            }
        } catch (Exception e) {
            System.out.println("Error adding skill: " + e.getMessage());
        }
    }

    public ElementType getType() {
        return type;
    }

    public String getHenshin() {
        return henshin;
    }

    public Skill[] getSkills() {
        return skills;
    }

    public boolean canUseSkill(int skillIndex) {
        try {
            if (skillIndex < 0 || skillIndex >= skillCount) return false;
            Skill skill = skills[skillIndex];
            return mana >= skill.manaCost() && skillCooldowns[skillIndex] == 0;
        } catch (Exception e) {
            System.out.println("Error checking skill: " + e.getMessage());
            return false;
        }
    }

    public void useSkill(int skillIndex) {
        if (skillIndex >= 0 && skillIndex < skillCount) {
            Skill skill = skills[skillIndex];
            mana -= skill.manaCost();
            if (mana < 0) mana = 0;
            skillCooldowns[skillIndex] = Math.max(0, skill.cooldown() + 1);
        }
    }

    public void regenerateMana() {
        mana += manaRegen;
        if (mana > maxMana) mana = maxMana;
    }

    public void reduceCooldowns() {
        for (int i = 0; i < skillCooldowns.length; i++) {
            if (skillCooldowns[i] > 0) skillCooldowns[i]--;
        }
    }

    public int getSkillCooldown(int skillIndex) {
        Skill[] skills = getSkills();
        if (skills == null || skillIndex < 0 || skillIndex >= skills.length || skills[skillIndex] == null) {
            return 0;
        }
        return skillCooldowns[skillIndex];
    }

    @Override
    public void fullHeal() {
        super.fullHeal();
        for (int i = 0; i < skillCooldowns.length; i++) skillCooldowns[i] = 0;
    }

    public MechaBeast copy() {
        MechaBeast copy = new MechaBeast(name, type, henshin, maxHp, speed, maxMana, manaRegen);
        for (int i = 0; i < skillCount; i++) {
            Skill skill = skills[i];
            copy.addSkill(new Skill(skill.name(), skill.type(), skill.minPower(), skill.maxPower(), skill.manaCost(), skill.cooldown()));
        }
        return copy;
    }

    @Override
    public String getStatusBar() {
        int hpPercent = (int) Math.ceil((currentHp * 100.0) / maxHp);
        int manaPercent = (int) Math.ceil((mana * 100.0) / maxMana);

        return String.format("%s | HP: %d/%d (%d%%) | Mana: %d/%d (%d%%)",
                name, currentHp, maxHp, hpPercent, mana, maxMana, manaPercent);
    }
}
