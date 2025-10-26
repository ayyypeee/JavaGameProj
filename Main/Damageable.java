package Main;
//ge make ra nko para naa tay interface HAHAHAH
//para reusable siya sa lain classes

public interface Damageable {
    //INTERFACE
    void takeDamage(int damage);
    boolean isAlive();
    void fullHeal();
    void reduceMana(int amount);
    void regainMana(int amount);
    boolean hasEnoughMana(int amount);
}