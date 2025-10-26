package Main;
//Ako ge add kay mao ning base class sa characters and enemies na makaapil sa away(blueprint)
//Parent class
public abstract class BattleEntity implements Damageable {

    protected String name;
    protected int maxHp;
    protected int currentHp;
    protected int speed;
    protected int mana;
    protected int maxMana;

    public BattleEntity(String name, int hp, int speed, int maxMana) {
        this.name = name;
        this.maxHp = hp;
        this.currentHp = hp;
        this.speed = speed;
        this.maxMana = maxMana;
        this.mana = maxMana; // start with max mana
    }

    public String getName() {
        return name;
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

    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void takeDamage(int damage) {
        currentHp -= damage;
        if (currentHp < 0) currentHp = 0;
    }

    @Override
    public boolean isAlive() {
        return currentHp > 0;
    }

    @Override
    public void fullHeal() {
        currentHp = maxHp;
        mana = maxMana;
    }
    
    @Override
    public void reduceMana(int amount) {
        this.mana = Math.max(this.mana - amount, 0);
    }

    @Override
    public void regainMana(int amount) {
        this.mana = Math.min(this.mana + amount, this.maxMana);
    }

    public boolean hasEnoughMana(int amount) {
        return this.mana >= amount;
    }

    public abstract String getStatusBar();
}
