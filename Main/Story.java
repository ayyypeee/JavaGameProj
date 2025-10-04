package Main;
import java.util.Scanner;
public class Story {
    private final Player player;
    Scanner scanner = new Scanner(System.in);
    public Story(Player player){
        this.player = player;
    }
    private void pressEnterToContinue() {
        System.out.println("\n[Press ENTER to continue]");
        scanner.nextLine();
    }

    public void Skip(){

        playIntroduction();
    }

    public void playIntroduction() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║       WELCOME TO DIGIWORLD RPG         ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println();

        System.out.println("Professor Ai-P: Hello and welcome, gaming prodigy and 10-time world champion!");
        System.out.println();
        System.out.println("Professor Ai-P: Welcome to the gaming lab where you will be");
        System.out.println("testing our new revolutionary game 'DigiWorld'.");
        System.out.println("Oh, where are my manners!? I'm Professor Ai-P, and I'm in charge");
        System.out.println("of developing this game.");
        System.out.println();
        System.out.println("Professor Ai-P: You will be transported into a world full of creatures");
        System.out.println("called 'Mecha Beasts', fuse with them, create a bond and battle together.");
        pressEnterToContinue();

        System.out.println("\n" + player.getName() + ": Thanks for the explanation, Professor,");
        System.out.println("but may I know what is the reason the government funded this game?");
        System.out.println();
        System.out.println("General Edrian: I shall be the one to answer that question, " + player.getName() + ".");
        System.out.println("I was intrigued by gaming. Seeing players think like chess masters");
        System.out.println("or generals and coordinate their movements to win gave me an idea.");
        System.out.println();
        System.out.println("General Edrian: What if we create a game where you BECOME the character");
        System.out.println("and fight in a digital world? This way gamers could play digital games");
        System.out.println("while still being physically active, and experience the feeling of");
        System.out.println("being their character. This could create a new legacy for 'Gamers'.");
        pressEnterToContinue();

        System.out.println("\n" + player.getName() + ": That doesn't fully answer my question but oh well.");
        System.out.println("Let's get this started.");
        System.out.println();
        System.out.println("Professor Ai-P: Excellent! Now before we transport you, you will need");
        System.out.println("this G-Watch, M-Belt and Beast-Card.");
        System.out.println();
        System.out.println("Professor Ai-P: It's time to transport you to DigiWorld!");
        pressEnterToContinue();
    }

}