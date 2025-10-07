package Main;
import java.util.Random;
import java.util.Scanner;

public class Combat {
    // initialize participants
    private MechaBeast player;
    private MechaBeast enemy;
    private boolean playerWon;

    private Scanner sc = new Scanner(System.in);
    private Random rand = new Random();

    public Combat(MechaBeast player, MechaBeast enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public boolean getOutcome() {
        return playerWon;
    }

    //Battle mechanics
    public void begin() {
        System.out.println("\n  ╔════════════════════════════════════════╗");
        System.out.println("║              BATTLE START              ║");
        System.out.println("╚════════════════════════════════════════╝");

        int round = 1;
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\n=== ROUND " + round++ + "! ===");
            playerTurn();
            if (!enemy.isAlive()) {
                break; 
            }
            enemyTurn();
            if (!player.isAlive()) {
                break; 
            }
        }ss

        checkOutcome();
    }

    //Damage calculations
    private int calculateDamage(MechaBeast attacker, MechaBeast defender) {
        // example ra ni since wla pay skills
        int minPower = 500, maxPower = 1000;
        int baseDamage = rand.nextInt(maxPower - minPower + 1) + minPower;
        double mult = attacker.getType().getEffectivenessAgainst(defender.getType());
        
        return (int) (baseDamage * mult);
    }

    //Battle UIs
    private void playerTurn() {
        System.out.println("\nYOUR BEAST!");

        takeDamage(enemy, calculateDamage(player, enemy));

    }

    private void enemyTurn() {
        System.out.println("\nENEMY'S TURN!");
        int randomSkill = rand.nextInt(3) + 1;  // 1–3
    }

    public void takeDamage(MechaBeast beast, int damage) {
    beast.setCurrentHp(beast.getCurrentHp() - damage);
    System.out.println(beast.getName() + " took " + damage + " damage! (HP: " + beast.getCurrentHp() + "/" + beast.getMaxHp() + ")");
    if (beast.getCurrentHp() < 0) {
        beast.setCurrentHp(0);
    }
}

    
    //Victory/defeat conditions
    private void checkOutcome() {
        if (player.isAlive()) {
            playerWon = true;
        } else {
           playerWon = false;
        }
    }

  //Skill cooldown and mana management
