package Main;

// BattleEntity is the SUPERCLASS, MechaBeast is the SUBCLASS
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

    public void setCurrentHp(int hp) {
        this.currentHp = hp;
        if(currentHp < 0) {
            this.currentHp = 0;
        } else if (currentHp > maxHp) {
            this.currentHp = maxHp;
        }
    }
    
    public int getCurrentHp() {
        return currentHp;
    }

    public void addSkill(Skill skill) {
        //EXCEPTION HANDLING
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
        //EXCEPTION HANDLING
        // e check if skill index is valid, enough mana, and not on cooldown
        try {
            if (skillIndex < 0 || skillIndex >= skillCount)
                return false;
            Skill skill = skills[skillIndex];
            return mana >= skill.manaCost() && skillCooldowns[skillIndex] == 0;
        } catch (Exception e) {
            System.out.println("Error checking skill: " + e.getMessage());
            return false;
        }
    }
    //Uses skill, reduces mana and sets cooldown
    public void useSkill(int skillIndex) {
        if (skillIndex >= 0 && skillIndex < skillCount) {
            Skill skill = skills[skillIndex];
            mana -= skill.manaCost();
            skillCooldowns[skillIndex] = skill.cooldown();
        }
    }

    //Regenerates mana
    public void regenerateMana() {
        mana += manaRegen;
        if (mana > maxMana) {
            mana = maxMana;
        }
    }

    //Reduces cooldowns
    public void reduceCooldowns() {
        for (int i = 0; i < skillCooldowns.length; i++) {
            if (skillCooldowns[i] > 0) {
                skillCooldowns[i]--;
            }
        }
    }
    // Returns the cooldown of a specific skill
        public int getSkillCooldown(int skillIndex) {
            Skill[] skills = getSkills();
            if (skills == null || skillIndex < 0 || skillIndex >= skills.length || skills[skillIndex] == null) {
                return 0;
            }
            return skillCooldowns[skillIndex];
        }

    //ge overrides ang fullHeal para ma restore mana and reset skills cooldowns
    @Override
    public void fullHeal() {
        super.fullHeal();
        for (int i = 0; i < skillCooldowns.length; i++) {
            skillCooldowns[i] = 0;
        }
    }

    // Creates copy of MechaBeast
    public MechaBeast copy() {
        MechaBeast copy = new MechaBeast(name, type, henshin, maxHp, speed, maxMana, manaRegen);
        for (int i = 0; i < skillCount; i++) {
            Skill skill = skills[i];
            copy.addSkill(new Skill(skill.name(), skill.type(),
                    skill.minPower(), skill.maxPower(),
                    skill.manaCost(), skill.cooldown()));
        }
        return copy;
    }

    // Displays status bar with HP and Mana
    @Override
    public String getStatusBar() {
        int hpPercent = (currentHp * 100) / maxHp;
        int manaPercent = (mana * 100) / maxMana;

        return String.format("%s | HP: %d/%d (%d%%) | Mana: %d/%d (%d%%)",
                name, currentHp, maxHp, hpPercent, mana, maxMana, manaPercent);
    }
}