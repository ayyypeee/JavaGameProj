package Main;

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
        System.out.print("Enter champion name: ");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName);
        System.out.println("\nWelcome, " + playerName + "!");
        System.out.println("Preparing your journey...\n");
        System.out.println("[Press ENTER to continue]");
        scanner.nextLine();

        //story
        Story story = new Story(player);
        story.playIntroduction();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      SELECT YOUR MECHA BEASTS          ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\nProfessor Ai-P: Choose 3 Mecha Beasts to accompany you!");
        System.out.println("Choose wisely - different types have advantages and weaknesses.\n");
    }
}
