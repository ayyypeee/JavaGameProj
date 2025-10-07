package Main;// Game.DigiWorldGame.java - Main Entry Point
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome, Banner
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║       WELCOME TO DIGIWORLD RPG         ║");
        System.out.println("║                                        ║");
        System.out.println("║     A Terminal-Based Adventure Game    ║");
        System.out.println("║         Fuse. Battle. Conquer.         ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println();

        // Game.Player Initialization
        System.out.print("Enter your champion name: ");
        String playerName = scanner.nextLine().trim();
        if (playerName.isEmpty()) {
            playerName = "Champion";
        }

        Player player = new Player(playerName);
        System.out.println("\nWelcome, " + playerName + "!");
        System.out.println("Preparing your journey...\n");
        System.out.println("[Press ENTER to continue]");
        scanner.nextLine();

        // Story Manager Initialization
        StoryManager storyManager = new StoryManager(player);

        // Introduction
        storyManager.playIntroduction();

        // Beast Selection
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      SELECT YOUR MECHA BEASTS          ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\nProfessor Ai-P: Choose 3 Mecha Beasts to accompany you!");
        System.out.println("Choose wisely - different types have advantages and weaknesses.\n");

        List<MechaBeast> availableBeasts = MechaBeastFactory.getAllStarterBeasts();

        // Display Beast Selection Table
        System.out.println("┌────┬─────────────┬──────────┬──────┬───────┬───────┐");
        System.out.println("│ #  │ Name        │ Type     │  HP  │ Speed │ Mana  │");
        System.out.println("├────┼─────────────┼──────────┼──────┼───────┼───────┤");

        for (int i = 0; i < 8; i++) {
            MechaBeast beast = availableBeasts.get(i);
            System.out.printf("│ %-2d │ %-11s │ %-8s │ %-4d │ %-5d │ %-5d │%n",
                    (i + 1),
                    beast.getName(),
                    beast.getType().getDisplayName(),
                    beast.getMaxHp(),
                    beast.getSpeed(),
                    beast.getMaxMana()
            );
        }

        System.out.println("│ 9  │ ???         │ ???      │ ???? │ ???   │ ???   │");
        System.out.println("└────┴─────────────┴──────────┴──────┴───────┴───────┘");

        System.out.println("\n💡 TIP: Balance your team with different types!");
        System.out.println("   High HP = Tank | High Speed = First Strike | High Mana = Powerful Skills");
        System.out.println("   ⚠️ Option 9 is a hidden beast... try it if you dare!");

        // Select 3 Beasts
        {
            System.out.println("\n╔══ SELECTION " + (1) + "/3 ══╗");
            System.out.print("Choose Mecha Beast " + (1) + " (1-8 or 9 for ???): ");

            int choice = -1;
            while (choice < 1 || choice > 9) {
                try {
                    String input = scanner.nextLine().trim();
                    choice = Integer.parseInt(input);
                    if (choice < 1 || choice > 9) {
                        System.out.print("Please enter a number between 1 and 9: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a number: ");
                }
            }

            MechaBeast selectedBeast = availableBeasts.get(choice - 1);

            if (choice == 9) {
                System.out.println("\n⚠️ SECRET UNLOCKED! ⚠️");
                System.out.println("✓ Kingmantis (OVERPOWERED CHARACTER) added to your team!");
                System.out.println("  HP: " + selectedBeast.getMaxHp() +
                        " | Speed: " + selectedBeast.getSpeed() +
                        " | Mana: " + selectedBeast.getMaxMana());
                System.out.println("  This is a CHEAT beast with incredible stats!");
            } else {
                System.out.println("✓ " + selectedBeast.getName() + " (" +
                        selectedBeast.getType().getDisplayName() + ") added to your team!");
                System.out.println("  HP: " + selectedBeast.getMaxHp() +
                        " | Speed: " + selectedBeast.getSpeed() +
                        " | Mana: " + selectedBeast.getMaxMana());
            }

            player.addMechaBeast(selectedBeast.copy());
        }
        {
            System.out.println("\n╔══ SELECTION " + (1 + 1) + "/3 ══╗");
            System.out.print("Choose Mecha Beast " + (1 + 1) + " (1-8 or 9 for ???): ");

            int choice = -1;
            while (choice < 1 || choice > 9) {
                try {
                    String input = scanner.nextLine().trim();
                    choice = Integer.parseInt(input);
                    if (choice < 1 || choice > 9) {
                        System.out.print("Please enter a number between 1 and 9: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a number: ");
                }
            }

            MechaBeast selectedBeast = availableBeasts.get(choice - 1);

            if (choice == 9) {
                System.out.println("\n⚠️ SECRET UNLOCKED! ⚠️");
                System.out.println("✓ Kingmantis (OVERPOWERED CHARACTER) added to your team!");
                System.out.println("  HP: " + selectedBeast.getMaxHp() +
                        " | Speed: " + selectedBeast.getSpeed() +
                        " | Mana: " + selectedBeast.getMaxMana());
                System.out.println("  This is a CHEAT beast with incredible stats!");
            } else {
                System.out.println("✓ " + selectedBeast.getName() + " (" +
                        selectedBeast.getType().getDisplayName() + ") added to your team!");
                System.out.println("  HP: " + selectedBeast.getMaxHp() +
                        " | Speed: " + selectedBeast.getSpeed() +
                        " | Mana: " + selectedBeast.getMaxMana());
            }

            player.addMechaBeast(selectedBeast.copy());
        }
        {
            System.out.println("\n╔══ SELECTION " + (2 + 1) + "/3 ══╗");
            System.out.print("Choose Mecha Beast " + (2 + 1) + " (1-8 or 9 for ???): ");

            int choice = -1;
            while (choice < 1 || choice > 9) {
                try {
                    String input = scanner.nextLine().trim();
                    choice = Integer.parseInt(input);
                    if (choice < 1 || choice > 9) {
                        System.out.print("Please enter a number between 1 and 9: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a number: ");
                }
            }

            MechaBeast selectedBeast = availableBeasts.get(choice - 1);

            if (choice == 9) {
                System.out.println("\n⚠️ SECRET UNLOCKED! ⚠️");
                System.out.println("✓ Kingmantis (OVERPOWERED CHARACTER) added to your team!");
                System.out.println("  HP: " + selectedBeast.getMaxHp() +
                        " | Speed: " + selectedBeast.getSpeed() +
                        " | Mana: " + selectedBeast.getMaxMana());
                System.out.println("  This is a CHEAT beast with incredible stats!");
            } else {
                System.out.println("✓ " + selectedBeast.getName() + " (" +
                        selectedBeast.getType().getDisplayName() + ") added to your team!");
                System.out.println("  HP: " + selectedBeast.getMaxHp() +
                        " | Speed: " + selectedBeast.getSpeed() +
                        " | Mana: " + selectedBeast.getMaxMana());
            }

            player.addMechaBeast(selectedBeast.copy());
        }

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         YOUR TEAM IS READY!            ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\nYour team:");
        for (int i = 0; i < player.getMechaBeasts().size(); i++) {
            MechaBeast beast = player.getMechaBeasts().get(i);
            System.out.printf("%d. %s (%s)%n", (i + 1), beast.getName(),
                    beast.getType().getDisplayName());
        }

        System.out.println("\nProfessor Ai-P: Excellent choices! Now let's begin the test!");
        System.out.println("\n[Press ENTER to continue]");
        scanner.nextLine();

        // Stage 1: Alpha Village
        storyManager.playStage1AlphaVillage();

        // Stage 2: Beta City
        storyManager.playStage2BetaCity();

        // Stage 3: The Collapse
        storyManager.playStage3Collapse();

        // Game Complete - Display Statistics
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          FINAL STATISTICS              ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\nChampion: " + player.getName());
        System.out.println("\nYour Final Team:");
        for (int i = 0; i < player.getMechaBeasts().size(); i++) {
            MechaBeast beast = player.getMechaBeasts().get(i);
            String status = beast.isAlive() ? "✓ ALIVE" : "✗ FAINTED";
            System.out.printf("%d. %-15s (%s) - %s%n",
                    (i + 1),
                    beast.getName(),
                    beast.getType().getDisplayName(),
                    status
            );
        }

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║    Stages Completed: 3/3               ║");
        System.out.println("║    Rank: LEGENDARY CHAMPION            ║");
        System.out.println("║    Status: GAME SAVED                  ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\nThank you for testing DigiWorld!");
        System.out.println("Your feedback will help shape the future of gaming!");

        scanner.close();
    }
}