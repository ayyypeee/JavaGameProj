
import java.util.Scanner;

public class StoryMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DialogueSystem dialogue = new DialogueSystem();

        System.out.println("===================TESTING PUTANINGA MO=====================");
   
        System.out.print("Enter your player name: ");
        String name = scan.nextLine().trim();
        dialogue.setPlayerName(name);

        System.out.println("\nWelcome, " + dialogue.getPlayerName() + "!");
        System.out.println("Commands: next | skip | info | reset | exit\n");

        boolean running = true;
        while (running) {
            System.out.print("> ");
            String input = scan.nextLine().trim().toLowerCase();
            switch (input) {
                case "next":
                case "":
                    dialogue.storyDialogue();
                    break;
                case "skip":
                    System.out.print("Enter stage (INTRO/STAGE1/STAGE2/STAGE3): ");
                    dialogue.nextStage(scan.nextLine().trim().toUpperCase());
                    break;
                case "info":
                    System.out.println("Current Stage: " + dialogue.getCurrentStage());
                    System.out.println("Dialogue Index: " + dialogue.getDialogueIndex());
                    System.out.println("Player Name: " + dialogue.getPlayerName());
                    break;
                case "reset":
                    dialogue.reset();
                    break;
                case "exit":
                    running = false;
                    System.out.println("Goodbye " + dialogue.getPlayerName() + "!");
                    break;
                default:
                    System.out.println("Invalid command. Use: next | skip | info | reset | exit");
            }
        }

        scan.close();
    }
}
