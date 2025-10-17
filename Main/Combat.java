package Main;
import java.util.Random;
import java.util.Scanner;
public class Combat {
    Scanner scanner = new Scanner(System.in);
    // initialize participants
    Player player;
    Player enemy;
    private boolean playerWon = false;
    private boolean isTutorial;


    public Combat(Player player, Player enemy, boolean isTutorial) {
        this.player = player;
        this.enemy = enemy;
        this.isTutorial = isTutorial;
    }

    public void setOutcome(boolean playerWon) {
        this.playerWon = playerWon;
    }

    public boolean getOutcome() {
        return playerWon;
    }

    //Battle mechanics
    public boolean begin() {
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
        }

        return getOutcome();
    }

    //Damage calculations
    //sa skills ni nko e butang para dali ra ma access ang min ug max e call lng ang calculateDamage sa skills
    private int calculateDamage(MechaBeast attacker, MechaBeast defender) {
        // example ra ni since wla pay skills
        int minPower = 500, maxPower = 1000;
        int baseDamage = rand.nextInt(maxPower - minPower + 1) + minPower;
        double mult = attacker.getType().getEffectivenessAgainst(defender.getType());

        return (int) (baseDamage * mult);
    }

    //Battle UIs
    // e boolean lng ni para e check ug kinsay mo una base sa speed
    // Mao nang interface sa battle pilion lng ang action
    /*    private boolean playerTurn(MechaBeast playerBeast, MechaBeast enemyBeast) {
        System.out.println("\n━━━ YOUR TURN ━━━");
        System.out.println("Choose your action:");
        System.out.println("1-3: Use Skill");
        System.out.println("4: Switch Beast");
        System.out.println("5: View Enemy Info");
        System.out.println("6: View Type Chart");

        displaySkills(playerBeast);
         System.out.print("\nYour choice: ");
        int action = getIntInput(6);

     */
    private void playerTurn() {

        System.out.println("\nYOUR BEAST!");
        takeDamage(enemy, calculateDamage(player, enemy));

    }
    /* ga suway rakog make ug ai sa enemy nga ang skill nga isog ang gamiton pero wa pa ni nko na testingan nag suwaysuway rako HAHAHHA
    private void enemyTurn(MechaBeast playerBeast, MechaBeast enemyBeast) {
        System.out.println("\n━━━ ENEMY TURN ━━━");

        // Simple AI ug unsa ang isog nga skill maoy gamiton
        int skillToUse = -1;
        for (int i = 2; i >= 0; i--) {
            if (enemyBeast.canUseSkill(i)) {
                skillToUse = i;
                break;
            }
        }

        if (skillToUse != -1) {
            Skill skill = enemyBeast.getSkills()[skillToUse];
            int baseDamage = skill.calculateDamage();

            // Calculate type effectiveness
            double effectiveness = skill.type().getEffectivenessAgainst(playerBeast.getType());
            int finalDamage = (int) Math.round(baseDamage * effectiveness);

            System.out.println(" " + enemyBeast.getName() + " used " + skill.name() + "!");

            // Show type advantage message
            String effectivenessMsg = skill.type().getEffectivenessMessage(playerBeast.getType());
            if (!effectivenessMsg.isEmpty()) {
                System.out.println(" " + effectivenessMsg);
            }

            System.out.println(" You took " + finalDamage + " damage!");
            if (effectiveness != 1.0) {
                System.out.println("   (Base: " + baseDamage + " × " + effectiveness + "x type bonus)");
            }

            playerBeast.takeDamage(finalDamage);
            enemyBeast.useSkill(skillToUse);
        } else {
            System.out.println(enemyBeast.getName() + " is recovering...");
        }
    }*/
    private void enemyTurn() {
        System.out.println("\nENEMY'S TURN!");
        takeDamage(enemy, calculateDamage(player, enemy));
    }
    //ako ni ge butang sa battleEntity
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
            setOutcome(true);
        } else {
            setOutcome(false);
        }
    }
    //ui ra
    private void displayBattleStatus(MechaBeast playerBeast, MechaBeast enemyBeast) {
        System.out.println("\n┌─ YOUR BEAST ─────────────────────────┐");
        System.out.println("│ " + playerBeast.getStatusBar());
        System.out.println("└──────────────────────────────────────┘");

        System.out.println("\n┌─ ENEMY ──────────────────────────────┐");
        System.out.println("│ " + enemyBeast.getStatusBar());
        System.out.println("└──────────────────────────────────────┘");
    }
    //if e type ang 5 mao ni mo gawas
    private void displayEnemyInfo(MechaBeast enemy) {
        System.out.println("\n╔══ ENEMY INFO ══╗");
        System.out.println("Name: " + enemy.getName());
        System.out.println("Type: " + enemy.getType().getDisplayName());
        System.out.println("HP: " + enemy.getCurrentHp() + "/" + enemy.getMaxHp());
        System.out.println("Speed: " + enemy.getSpeed());
        System.out.println("\nSkills:");
        Skill[] skills = enemy.getSkills();
        for (int i = 0; i < 3; i++) {
            if (skills[i] != null) {
                System.out.println("- " + skills[i].getDescription());
            }
        }
        System.out.println("╚═══════════════╝");

    }
    //if e type ang 6 mao ni mo gawas
    private void displayTypeChart() {
        System.out.println("\n╔════════════════ TYPE CHART ════════════════╗");
        System.out.println("║  SUPER EFFECTIVE (2x damage):              ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ FIRE    → Grass, Wind, Steel               ║");
        System.out.println("║ WATER   → Fire, Earth                      ║");
        System.out.println("║ GRASS   → Water, Earth                     ║");
        System.out.println("║ ELECTRIC→ Water, Wind                      ║");
        System.out.println("║ EARTH   → Electric, Steel, Fire            ║");
        System.out.println("║ WIND    → Grass, Fighting                  ║");
        System.out.println("║ FIGHTING→ Dark, Steel                      ║");
        System.out.println("║ PSYCHIC → Fighting                         ║");
        System.out.println("║ DARK    → Earth, Wind                      ║");
        System.out.println("║ STEEL   → Dark, Electric                   ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║  NOT VERY EFFECTIVE (0.5x damage):         ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ FIRE    ← Water, Earth                     ║");
        System.out.println("║ WATER   ← Grass, Electric                  ║");
        System.out.println("║ GRASS   ← Fire, Wind                       ║");
        System.out.println("║ ELECTRIC← Earth, Steel                     ║");
        System.out.println("║ EARTH   ← Water, Grass, Dark               ║");
        System.out.println("║ WIND    ← Fire, Electric                   ║");
        System.out.println("║ FIGHTING← Wind, Psychic                    ║");
        System.out.println("║ PSYCHIC ← Dark, Steel                      ║");
        System.out.println("║ DARK    ← Fighting, Steel                  ║");
        System.out.println("║ STEEL   ← Fire, Earth                      ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("\nTIP: Match your skill type to the enemy's");
        System.out.println("         weakness for maximum damage!");
        pressEnterToContinue();
    }
    private void pressEnterToContinue() {
        System.out.println("\n[Press ENTER to continue]");
        scanner.nextLine();
    }
    //Input validation
    //kani ra gamita if mag input ug number
    private int getIntInput(int max) {
        while (true) {
            try {
                String input = scanner.nextLine();
                int value = Integer.parseInt(input);
                if (value >= 1 && value <= max) {
                    return value;
                }
                System.out.print("Please enter a number between " + 1 + " and " + max + ": ");
            } catch (NumberFormatException e) {

                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    //Skill cooldown and mana management
}