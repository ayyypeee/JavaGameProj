package Main;
//Ako ge add kay mao ning base class sa characters and enemies na makaapil sa away(blueprint)
//Parent class
public abstract class BattleEntity implements Damageable {

    protected String name;
    protected int maxHp;
    protected int currentHp;
    protected int speed;

    public BattleEntity(String name, int hp, int speed) {
        this.name = name;
        this.maxHp = hp;
        this.currentHp = hp;
        this.speed = speed;
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
    }

    public abstract String getStatusBar();
}
