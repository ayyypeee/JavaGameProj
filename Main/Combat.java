package Main;

import java.util.Scanner;

public class Combat {

    private Scanner scanner;
    private Player player;
    private MechaBeast enemy;
    private boolean isTutorial;
    private String stageName;

    public Combat(Player player, MechaBeast enemy, boolean isTutorial, String stageName) {
        this.scanner = new Scanner(System.in);
        this.player = player;
        this.isTutorial = isTutorial;
        if (stageName != null) {
            this.stageName = stageName;
        } else {
            this.stageName = "";
        }

        this.enemy = prepareEnemy(enemy);
    }

    private MechaBeast prepareEnemy(MechaBeast originalEnemy) {
        try {
            if (!isTutorial) return originalEnemy.copy();

            int tutorialHp = Math.max(1, originalEnemy.getMaxHp() / 3);
            int tutorialSpeed = Math.max(1, originalEnemy.getSpeed() - 20);
            int tutorialMana = Math.max(1, originalEnemy.getMaxMana() / 3);
            int tutorialManaRegen = 5;

            MechaBeast nerfedEnemy = new MechaBeast(originalEnemy.getName(), originalEnemy.getType(), originalEnemy.getHenshin(),
                    tutorialHp, tutorialSpeed, tutorialMana, tutorialManaRegen);

            Skill[] originalSkills = originalEnemy.getSkills();
            if (originalSkills != null) {
                for (Skill skill : originalSkills) {
                    if (skill == null) continue;
                    int weakMinPower = Math.max(1, (int) Math.round(skill.minPower() * 0.5));
                    int weakMaxPower = Math.max(weakMinPower, (int) Math.round(skill.maxPower() * 0.5));
                    int weakManaCost = Math.max(0, skill.manaCost() / 2);
                    nerfedEnemy.addSkill(new Skill(skill.name(), skill.type(), weakMinPower, weakMaxPower, weakManaCost, skill.cooldown()));
                }
            }

            return nerfedEnemy;
        } catch (Exception e) {
            System.out.println("Error preparing enemy: " + e.getMessage());
            return originalEnemy.copy();
        }
    }

    public boolean begin() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║            BATTLE START                ║");
        System.out.println("╚════════════════════════════════════════╝");

        player.healAllBeasts();
        enemy.fullHeal();

        MechaBeast[] playerBeasts = player.getMechaBeasts();
        int totalBeasts = player.getBeastCount();

        if (totalBeasts > 1) showBeastSelectionMenu(playerBeasts, totalBeasts);

        MechaBeast newBeast = player.getCurrentBeast();
        if (newBeast != null && newBeast.getHenshin() != null && !newBeast.getHenshin().isEmpty()) {
            System.out.println("⚡ Announcer: " + newBeast.getHenshin().toUpperCase() + "! ⚡");
        }

        scanner.nextLine();
        int turnNumber = 1;
        boolean playerGoesFirst = player.getCurrentBeast().getSpeed() >= enemy.getSpeed();

        while (player.hasAliveBeast() && enemy.getCurrentHp() > 0) {
            String stage = stageName.isEmpty() ? "" : stageName + " - ";
            System.out.println("\n═══ " + stage + "TURN " + turnNumber + " ═══");
            displayBattleStatus(player.getCurrentBeast(), enemy);

            if (playerGoesFirst) {
                if (executePlayerTurn(player.getCurrentBeast(), enemy)) return true;
                if (executeEnemyTurn(player.getCurrentBeast(), enemy)) return false;
            } else {
                if (executeEnemyTurn(player.getCurrentBeast(), enemy)) return false;
                if (executePlayerTurn(player.getCurrentBeast(), enemy)) return true;
            }

            player.getCurrentBeast().reduceCooldowns();
            enemy.reduceCooldowns();
            player.getCurrentBeast().regenerateMana();
            enemy.regenerateMana();
            turnNumber++;
        }

        return player.hasAliveBeast();
    }

    private void showBeastSelectionMenu(MechaBeast[] beasts, int count) {
        System.out.println("\n╔══ CHOOSE YOUR BEAST ══╗");

        for (int i = 0; i < count; i++) {
            MechaBeast beast = beasts[i];

            if (beast == null) {
                System.out.printf("%d: ---\n", i + 1);
                continue;
            }

            String statusFlag;
            if (beast.isAlive()) {
                statusFlag = "";
            } else {
                statusFlag = " (FAINTED)";
            }


            System.out.printf("%d: %s (%s)%s (HP: %d/%d | Speed: %d | Mana: %d)%n",
                    (i + 1),
                    beast.getName(),
                    beast.getType().getDisplayName(),
                    statusFlag,
                    beast.getCurrentHp(),
                    beast.getMaxHp(),
                    beast.getSpeed(),
                    beast.getMaxMana()
            );
        }

        System.out.print("\nYour choice: ");
        int choice = getValidIntInput(count);
        player.setCurrentBeastIndex(choice - 1);
    }

    private boolean executePlayerTurn(MechaBeast playerBeast, MechaBeast enemyBeast) {
        System.out.println("\n━━━ YOUR TURN ━━━");
        System.out.println("Choose your action:");
        System.out.println("1-3: Use Skill");
        System.out.println("4: Switch Beast");
        System.out.println("5: View Enemy Info");
        System.out.println("6: View Type Chart");

        displaySkills(playerBeast);
        System.out.print("\nYour choice: ");
        int action = getValidIntInput(6);

        switch(action) {
            case 1:
            case 2:
            case 3:
                // Use a skill
                return useSkill(playerBeast, enemyBeast, action - 1);

            case 4:
                // Switch to different beast
                switchBeast();
                break;

            case 5:
                // View enemy information
                displayEnemyInfo(enemyBeast);
                return executePlayerTurn(playerBeast, enemyBeast);  // Re-do turn

            case 6:
                // View type effectiveness chart
                displayTypeChart();
                return executePlayerTurn(playerBeast, enemyBeast);  // Re-do turn
        }

        return false;
    }


    private boolean useSkill(MechaBeast attacker, MechaBeast defender, int skillIndex) {
        // Check if the skill can be used
        if (!attacker.canUseSkill(skillIndex)) {
            System.out.println("\n❌ Skill is unavailable!");
            return false;
        }

        Skill selectedSkill = attacker.getSkills()[skillIndex];

        // Calculate base damage (random between min and max power)
        int baseDamage = selectedSkill.calculateDamage();

        // Calculate type effectiveness (2x for super effective, 0.5x for not very effective)
        double typeMultiplier = selectedSkill.type().getEffectivenessAgainst(defender.getType());

        // Calculate final damage with type bonus
        int finalDamage = (int) Math.round(baseDamage * typeMultiplier);

        System.out.println("\n💥 You used " + selectedSkill.name() + "!");

        //ype effectiveness message
        String effectivenessMessage = selectedSkill.type().getEffectivenessMessage(defender.getType());
        if (!effectivenessMessage.isEmpty()) {
            System.out.println(effectivenessMessage);
        }

        // Apply damage to enemy
        System.out.println("⚔️  Enemy took " + finalDamage + " damage!");

        // Show damage calculation
        if (typeMultiplier != 1.0) {
            System.out.println("   (Base: " + baseDamage + " × " + typeMultiplier + "x type bonus)");
        }

        defender.takeDamage(finalDamage);
        attacker.useSkill(skillIndex);

        // Check if enemy is defeated
        if (!defender.isAlive()) {
            System.out.println("\n💀 Enemy " + defender.getName() + " has fainted!");
            return true;
        }

        return false;
    }

    private void switchBeast() {
        System.out.println("\n╔══ SWITCHING BEAST ══╗");
        MechaBeast[] beasts = player.getMechaBeasts();
        MechaBeast currentBeast = player.getCurrentBeast();
        int beastCount = player.getBeastCount();

        // If player has no other alive beast, inform and return
        boolean otherAliveExists = false;
        for (int i = 0; i < beastCount; i++) {
            MechaBeast b = beasts[i];
            if (b != null && b.isAlive() && b != currentBeast) {
                otherAliveExists = true;
                break;
            }
        }
        if (!otherAliveExists) {
            System.out.println("❗ No other available Mecha Beasts to switch to.");
            return;
        }

        while (true) {
            System.out.println("Choose a beast to switch to:");

            // Display all available beasts
            for (int i = 0; i < beastCount; i++) {
                MechaBeast beast = beasts[i];

                if (beast == null) {
                    System.out.printf("%d: ---%n", (i + 1));
                    continue;
                }

                String status = "";
                if (beast == currentBeast) {
                    status = " [CURRENT]";
                } else if (!beast.isAlive()) {
                    status = " [FAINTED]";
                }

                System.out.printf("%d: %s (%s)%s (HP: %d/%d)%n",
                        (i + 1),
                        beast.getName(),
                        beast.getType().getDisplayName(),
                        status,
                        beast.getCurrentHp(),
                        beast.getMaxHp()
                );
            }

            System.out.print("Your choice: ");
            int choice = getValidIntInput(beastCount);

            try {
                MechaBeast chosenBeast = beasts[choice - 1];

                if (chosenBeast == null) {
                    System.out.println("❌ That slot is empty. Choose another beast.");
                    continue;
                }

                if (!chosenBeast.isAlive()) {
                    System.out.println("❌ " + chosenBeast.getName() + " has fainted and cannot battle! Choose another beast.");
                    continue;
                }

                player.setCurrentBeastIndex(choice - 1);
                System.out.println("✓ You switched to " + chosenBeast.getName() + "!");
                break;

            } catch (Exception e) {
                System.out.println("Invalid selection. Please choose a valid beast.");
            }
        }
    }

    private boolean executeEnemyTurn(MechaBeast playerBeast, MechaBeast enemyBeast) {
        System.out.println("\n━━━ ENEMY TURN ━━━");

        // Simple AI: Try to use the strongest available skill
        int skillToUse = -1;
        for (int i = 2; i >= 0; i--) {
            try {
                if (enemyBeast.canUseSkill(i)) {
                    skillToUse = i;
                    break;
                }
            } catch (Exception ignored) { }
        }

        // If no usable skill found, fall back to index 0 if present
        if (skillToUse == -1) {
            skillToUse = 0;
        }

        Skill skill = enemyBeast.getSkills()[skillToUse];

        // Calculate damage
        int baseDamage = skill.calculateDamage();
        double typeMultiplier = skill.type().getEffectivenessAgainst(playerBeast.getType());
        int finalDamage = (int) Math.round(baseDamage * typeMultiplier);

        // Messages
        System.out.println("\nEnemy used " + skill.name() + "!");
        String effectivenessMessage = skill.type().getEffectivenessMessage(playerBeast.getType());
        if (!effectivenessMessage.isEmpty()) {
            System.out.println(effectivenessMessage);
        }
        System.out.println("You took " + finalDamage + " damage!");
        if (typeMultiplier != 1.0) {
            System.out.println("(Damage modified by x" + typeMultiplier + ")");
        }

        // Apply damage and consume skill resources
        playerBeast.takeDamage(finalDamage);
        enemyBeast.useSkill(skillToUse);

        // If player's current beast fainted
        if (!playerBeast.isAlive()) {
            System.out.println("\nYour " + playerBeast.getName() + " fainted!");

            // If player has any alive beasts left, force a switch
            if (player.hasAliveBeast()) {
                System.out.println("Choose another Mecha Beast to continue the battle.");
                switchBeast();
                return false;
            } else {
                // No beasts left -> player loses the battle
                System.out.println("All your Mecha Beasts have fainted. The match will restart.");
                return true;
            }
        }

        return false;
    }

    private void displayBattleStatus(MechaBeast playerBeast, MechaBeast enemyBeast) {
        System.out.println("\n┌─ YOUR BEAST ─────────────────────────┐");
        System.out.println("│ " + playerBeast.getStatusBar());
        System.out.println("└──────────────────────────────────────┘");

        System.out.println("\n┌─ ENEMY ──────────────────────────────┐");
        System.out.println("│ " + enemyBeast.getStatusBar());
        System.out.println("└──────────────────────────────────────┘");
    }

    private void displayEnemyInfo(MechaBeast enemy) {
        System.out.println("\n╔══ ENEMY INFO ══╗");
        System.out.println("Name: " + enemy.getName());
        System.out.println("Type: " + enemy.getType().getDisplayName());
        System.out.println("HP: " + enemy.getCurrentHp() + "/" + enemy.getMaxHp());
        System.out.println("Speed: " + enemy.getSpeed());
        System.out.println("\nSkills:");

        Skill[] enemySkills = enemy.getSkills();
        for (int i = 0; i < 3; i++) {
            if (enemySkills[i] != null) {
                System.out.println("- " + enemySkills[i].getDescription());
            }
        }
        System.out.println("╚═══════════════╝");
    }

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
        System.out.println("\n💡 TIP: Match your skill type to the enemy's");
        System.out.println("         weakness for maximum damage!");
        pressEnterToContinue();
    }

    private void displaySkills(MechaBeast beast) {
        System.out.println("\n" + beast.getName() + " TYPE: " + beast.getType().getDisplayName());
        System.out.println("║ Available skills for " + beast.getName() + " ║");

        Skill[] skills = beast.getSkills();

        for (int i = 0; i < skills.length; i++) {
            Skill skill = skills[i];

            if (skill == null) {
                System.out.println((i + 1) + ": ---");
                continue;
            }

            // Check skill availability
            int cooldownTurns = beast.getSkillCooldown(i);
            boolean isOnCooldown = cooldownTurns > 0;
            boolean hasEnoughMana = beast.getMana() >= skill.manaCost();
            boolean canUseSkill = hasEnoughMana && !isOnCooldown;

            String cooldownInfo = "";
            if (isOnCooldown) {
                cooldownInfo = " (Cooldown: " + cooldownTurns + " more turns)";
            }

            String manaInfo = " | Mana: " + skill.manaCost();

            String status;
            if (!canUseSkill) {
                if (isOnCooldown) {
                    status = " [COOLDOWN]";
                } else {
                    status = " [INSUFFICIENT MANA]";
                }
            } else {
                status = " [READY]";
            }

            //skill information
            System.out.printf("%d: %s (%s) | Power: %d-%d%s%s %s%n",
                    (i + 1),
                    skill.name(),
                    skill.type().getDisplayName(),
                    skill.minPower(),
                    skill.maxPower(),
                    manaInfo,
                    cooldownInfo,
                    status
            );
        }
    }

    public void setTutorialMode() {
        boolean playerWon;

        do {
            playerWon = begin();

            if (isTutorial && !playerWon) {
                System.out.println("Match failed! Starting over...");
                resetCombat();
            }
        } while (isTutorial && !playerWon);
    }

    private void resetCombat() {
        player.healAllBeasts();
        enemy.fullHeal();
    }

    private void pressEnterToContinue() {
        System.out.println("\n[Press ENTER to continue]");
        scanner.nextLine();
    }

    private int getValidIntInput(int max) {
        while (true) {
            try {
                String input = scanner.nextLine();
                int value = Integer.parseInt(input);

                if (value >= 1 && value <= max) {
                    return value;
                }

                System.out.print("Please enter a number between 1 and " + max + ": ");

            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}