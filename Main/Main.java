package Main;// Game.DigiWorldGame.java - Main Entry Point
import java.util.*;
public class Main{
    public static void displayTitle() {
        System.out.println("════════════════════════════════════════════════════════════════════════");
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                      ║");
        System.out.println("║    ****    ***     *****   ***     *   *   *****   ****    *   ****  ║");
        System.out.println("║    *   *    *      *        *      *   *   *   *   *   *   *   *   * ║");
        System.out.println("║    *   *    *      *        *      *   *   *   *   *   *   *   *   * ║");
        System.out.println("║    *   *    *      * ***    *      * * *   *   *   ****    *   *   * ║");
        System.out.println("║    *   *    *      *   *    *      * * *   *   *   *   *   *   *   * ║");
        System.out.println("║    *   *    *      *   *    *      ** **   *   *   *   *   *   *   * ║");
        System.out.println("║    ****    ***     *****   ***     *   *   *****   *   *   *** ****  ║");
        System.out.println("║                                                                      ║");
        System.out.println("║              ◊ ◇ ◊ ◇ ◊ ◇ ◊ ◇ ◊ ◇ ◊ ◇ ◊ ◇ ◊ ◇ ◊ ◇ ◊                   ║");
        System.out.println("║                     ~ Digital Adventure Awaits ~                     ║");
        System.out.println("║              ◇ ◊ ◇ ◊ ◇ ◊ ◇ ◊ ◇ ◊ ◇ ◊ ◇ ◊ ◇ ◊ ◇ ◊ ◇                   ║");
        System.out.println("║                                                                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
        System.out.println("════════════════════════════════════════════════════════════════════════");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== WELCOME TO ===");
        displayTitle();
        System.out.println("\nGame initializing...");
        System.out.println();
        //story
        System.out.println("You are a gaming prodigy and a 10-time world champion in different games, and you have been \nchosen to test the new revolutionary game “DigiWorld” created by the government.To keep \nyour legacy going you agreed. You will be transported into a digital world full of elemental \nMecha Beasts, where you fuse with them and battle challengers.");
        System.out.println();
        System.out.print("Enter the name of your character: ");
        String name = sc.nextLine();
        System.out.println();
        System.out.println("Professor Ai-P: Hello and welcome Mr. gaming prodigy and 10-time world champion "+name+" \nto the gaming lab where you will be testing our new revolutionary game “DigiWorld”.  Oh, where \nare my manners!? I’m Professor Ai-P, and I’m in charge in developing this game. You will be \ntransported into a world full of creatures called “Mecha Beasts”, fuse with them, create a bond and battle together. ");
        System.out.println();
        System.out.println(name+": Thanks for the explanation, Professor, but may I know what is the reason the government funded to create this game?");
        System.out.println();
        System.out.println("General Edrian: I shall be the one to answer that question Mr. (name), I was actually intrigued \nby gaming. Seeing players think like they’re chess masters or generals and coordinate their \nupper body in tapping their devices to win, it gave me an idea. What if we create a game where \nyou become the character and fight but in a digital world? This way gamers could play digital \ngames while still being physically active, and they will be able to experience the feeling of being \ntheir character. This could create a new legacy for “Gamers”.");
        System.out.println();
        System.out.println(name+": That doesn’t fully answer my question but oh well. Let’s get this started.");
        System.out.println();
        System.out.println("Professor Ai-P: Excellent! Now before we transport you, you will need this G-Watch, M-Belt and\nBeast.Beast-Card. Choose 3 out of these 10 Mecha Beasts:");
        //choose character
        System.out.print("1.\tFire Beast.Beast: Solflare\n" +
                "2.\tWater Beast.Beast: Nokami  \n" +
                "3.\tGrass Beast.Beast: Vineratops\n" +
                "4.\tElectric Beast.Beast: Voltchu\n" +
                "5.\tEarth Beast.Beast: Zyuugor\n" +
                "6.\tWind Beast.Beast: Pirrot\n" +
                "7.\tFighting Beast.Beast: Gekuma\n" +
                "8.\tPsychic Beast.Beast: Mindowl\n" +
                "9.\tDark Beast.Beast: Shadefox\n" +
                "10.\tSteel Beast.Beast: Mantiron\n");
        System.out.print("Choose your first character: ");
        int character1 = sc.nextInt();
        System.out.print("Choose your second character: ");
        int character2 = sc.nextInt();
        System.out.print("Choose your third character: ");
        int character3 = sc.nextInt();
        System.out.print("Hello");
    }

}