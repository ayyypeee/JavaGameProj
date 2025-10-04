
import java.util.Scanner;

public class DialogueSystem {
    private DialogueStage[] stages;
    private int stageIndex;
    private int dialogueIndex;
    private String playerName = "Player";

    public DialogueSystem() {
        loadDialogues();
        stageIndex = 0;
        dialogueIndex = 0;
    }

    public void setPlayerName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            playerName = name.trim();
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getCurrentStage() {
        if (stages == null || stageIndex < 0 || stageIndex >= stages.length) return "NONE";
        return stages[stageIndex].getStageName();
    }

    public int getDialogueIndex() {
        return dialogueIndex;
    }

    public void storyDialogue() {
        if (stages == null || stages.length == 0) {
            System.out.println("\n[SYSTEM]: No stages loaded.");
            return;
        }

        DialogueStage currentStage = stages[stageIndex];
        Dialogue line = currentStage.getDialogue(dialogueIndex);

        if (line != null) {
            line.display(playerName);
            dialogueIndex++;
            return;
        }

        if (stageIndex < stages.length - 1) {
            stageIndex++;
            dialogueIndex = 0;
            System.out.println("\n========================================");
            System.out.println("      ADVANCING TO: " + getCurrentStage());
            System.out.println("========================================");
            storyDialogue();
        } else {
            System.out.println("\n[SYSTEM]: Story complete. No more dialogues.");
        }
    }

    public void nextStage(String stageName) {
        if (stageName == null) {
            System.out.println("\n[SYSTEM]: Invalid stage name.");
            return;
        }
        for (int i = 0; i < stages.length; i++) {
            if (stages[i].getStageName().equalsIgnoreCase(stageName)) {
                stageIndex = i;
                dialogueIndex = 0;
                System.out.println("\n[SYSTEM]: Jumped to stage " + stages[i].getStageName());
                return;
            }
        }
        System.out.println("\n[SYSTEM]: Stage not found: " + stageName);
    }

    public void reset() {
        stageIndex = 0;
        dialogueIndex = 0;
        System.out.println("\n[SYSTEM]: Reset to beginning (INTRO).");
    }


    private void loadDialogues() {

        Dialogue[] intro = new Dialogue[] {
            new Dialogue("Professor Ai-P", "Hello and welcome Mr. gaming prodigy and 10-time world champion (name) to the gaming lab where you will be testing our new revolutionary game \"DigiWorld\". Oh, where are my manners!? I'm Professor Ai-P, and I'm in charge in developing this game. You will be transported into a world full of creatures called \"Mecha Beasts\", fuse with them, create a bond and battle together."),
            new Dialogue("You", "Thanks for the explanation, Professor, but may I know what is the reason the government funded to create this game?"),
            new Dialogue("General Edrian", "I shall be the one to answer that question Mr. (name), I was actually intrigued by gaming. Seeing players think like they're chess masters or generals and coordinate their upper body in tapping their devices to win, it gave me an idea. What if we create a game where you become the character and fight but in a digital world? This way gamers could play digital games while still being physically active, and they will be able to experience the feeling of being their character. This could create a new legacy for \"Gamers\"."),
            new Dialogue("You", "That doesn't fully answer my question but oh well. Let's get this started."),
            new Dialogue("Professor Ai-P", "Excellent! Now before we transport you, you will need this G-Watch, M-Belt and Beast-Card. Choose 3 out of these 10 Mecha Beasts:\n\nFire Beast: Kyoflare\nWater Beast: Nokami\nGrass Beast: Vineratops\nElectric Beast: Voltchu\nEarth Beast: Zyuugor\nWind Beast: Pirrot\nFighting Beast: Gekuma\nDark Beast: Shadefox\nSteel Beast: Kingmantis."),
            new Dialogue("Professor Ai-P", "Well then, it's time to transport you to DigiWorld!")
        };

     
        Dialogue[] stage1 = new Dialogue[] {
            new Dialogue("Professor Ai-P", "Welcome to the beta test. Your first mission is to reach Alpha Village and challenge the Alpha Beast. Your G Watch has the map, so just follow the route. Since this is still in beta, you might encounter bugs. Report them if you do. One more thing… you will feel pain, just like in real life. But remember, you will not die."),
            new Dialogue("You", "Wait… what? Pain? You didn't say anything about that!"),
            new Dialogue("Professor Ai-P", "Good luck. The future of gaming and your legacy are in your hands."),
            new Dialogue("You", "Did he just cut me off? Ugh, fine. No turning back now."),
            new Dialogue("NARRATION", "You arrive at Alpha Village."),
            new Dialogue("You", "Hello? Anyone here?"),
            new Dialogue("Chief Rei", "Welcome, traveler. I am Chief Rei, guardian of this village. What is it you seek?"),
            new Dialogue("You", "I was told there is an Alpha Beast here."),
            new Dialogue("Chief Rei", "That is true. But tell me… are you a challenger, or just another treasure hunter?"),
            new Dialogue("You", "I… I guess I am a challenger."),
            new Dialogue("Chief Rei", "Then follow the Mystic Forest. The path will test you before you reach the Alpha. Be prepared."),
            new Dialogue("You", "Thank you, Chief."),
            new Dialogue("NARRATION", "Inside the Mystic Forest."),
            new Dialogue("ANNOUNCER", "BRR BRRR BRRR DIDIDIDI!"),
            new Dialogue("ANNOUNCER", "Tutorial Start - You have encountered a Mecha Beast, fight it to continue on your journey."),
            new Dialogue("You", "HENSHIN! Wait, why did I just shout that?"),
            new Dialogue("ANNOUNCER", "Now press 1, 2 or 3 to use your skills but be careful as they take mana and might have cooldowns."),
            new Dialogue("ANNOUNCER", "You have successfully completed the tutorial. You may now continue."),
            new Dialogue("You", "That... felt too real."),
            new Dialogue("NARRATION", "At the heart of the forest."),
            new Dialogue("Altair", "Who dares step into my domain?"),
            new Dialogue("You", "My name is (Name). I came to challenge you."),
            new Dialogue("Altair", "Then face me. I am Altair, the Alpha. And this is my partner, the Alpha Beast, Gekuma. HENSHIN!"),
            new Dialogue("ANNOUNCER", "GEEEKKKIIIIRAAANGEEERRR!"),
            new Dialogue("NARRATION", "Boss battle begins. After the fight, Altair falls to one knee."),
            new Dialogue("Altair", "You... you lack bond with your beasts, yet you still defeated me. Perhaps you are more than just a beginner. Take the treasure."),
            new Dialogue("You", "Treasure? I do not need that. I was told only to challenge you."),
            new Dialogue("Altair", "Hm... how unusual. Then take your victory. You may leave with your pride intact."),
            new Dialogue("NARRATION", "Teleportation begins."),
            new Dialogue("Altair", "What a strange challenger..."),
            new Dialogue("NARRATION", "Back in the lab."),
            new Dialogue("Professor Ai-P", "Excellent work. Stage one is complete. And no bugs either. You handled yourself well."),
            new Dialogue("You", "Don't act proud! You never told me the pain would feel real. I thought I was going to die!"),
            new Dialogue("Professor Ai-P", "But you did not. That is the point. This game is meant to be lived, not just played. Now rest. Tomorrow, the next test awaits."),
            new Dialogue("You", "Tch...")
        };

        Dialogue[] stage2 = new Dialogue[] {
            new Dialogue("Professor Ai-P", "Welcome back, (name). We're about to begin the full test. Are you ready?"),
            new Dialogue("You", "Yes... somewhat."),
            new Dialogue("Professor Ai-P", "Alright then, transport!"),
            new Dialogue("ANNOUNCER", "Transport complete!"),
            new Dialogue("Professor Ai-P", "You are now in Beta City! Your goal: defeat the Ace Trainer to earn a Challenge Ticket for the Tournament Trial. Head to the Tournament Hall to register. Good luck, and hopefully... everything goes smoothly."),
            new Dialogue("You", "Alright! Let's go!"),
            new Dialogue("Ace Jazz", "I am the Ace Trainer Jazz. Battle me and win for only the strongest may pass! HENSHIN!"),
            new Dialogue("ANNOUNCER", "GOOOOKAAAIIIGGGEERRRR!"),
            new Dialogue("NARRATION", "Mecha Beast: Pirrot"),
            new Dialogue("NARRATION", "After winning..."),
            new Dialogue("Ace Jazz", "You've surpassed us all. Take this Challenge Ticket, you've earned it. With it, you're worthy of the Tournament Trial."),
            new Dialogue("ANNOUNCER", "Congratulations, (name)! You've obtained the Challenge Ticket! You may now attempt the Tournament Trial!"),
            new Dialogue("NARRATION", "At the Tournament Trial."),
            new Dialogue("Trialmaster", "Welcome, challenger! I am Trialmaster! Will you defeat me to qualify for the tournament, or start all over again?"),
            new Dialogue("You", "Wait... Professor? Is that you? Are you also testing the game, or is this some NPC of you?"),
            new Dialogue("Trialmaster", "IIII... d-d-don't know who this Professor you're talking about!"),
            new Dialogue("You", "Seriously!? You're a bad liar."),
            new Dialogue("Trialmaster", "Enough talk! Prove your strength first, then I'll answer. HENSHIN!"),
            new Dialogue("ANNOUNCER", "SHHIINNNKKKEEENNNGGGERRR!"),
            new Dialogue("NARRATION", "Mecha Beast: Voltchu"),
            new Dialogue("NARRATION", "After winning..."),
            new Dialogue("Trialmaster", "You've beaten me... and qualified for the tournament! And yes, I'm the Professor. In this game, I'm \"Trialmaster.\" I transported in to personally monitor the test and ensure no glitches slip through. I sense something bad is coming, and I had to see it for myself instead of just observing you."),
            new Dialogue("You", "But why would something bad happen? You're a genius, you've planned everything for this game!"),
            new Dialogue("Trialmaster", "True, but there's been tension between the staff and the General even before the beta started. Reasons I can't share with you... for now. Let's continue testing and see what unfolds."),
            new Dialogue("ANNOUNCER", "Congratulations challenger (name), you are now registered in the tournament!")
        };

        Dialogue[] stage3 = new Dialogue[] {
            new Dialogue("ANNOUNCER", "IT'S TIME FOR THE TOURNA-- BZZZT--KRZZHH--VRRRTTCHH—"),
            new Dialogue("You", "Huh? A glitch?"),
            new Dialogue("NARRATION", "BZZZZZT--KRZZZHHHH--VVVRRRTTTCCCHHHHHHH--KRRRRAAAASHHHH--SHHHHHHHHHHHHhhhhh"),
            new Dialogue("Trialmaster", "THE CITY IS COLLAPSING!"),
            new Dialogue("???", "Professor, I'm logging you out for safety. Now it's time to destroy Beta City."),
            new Dialogue("NARRATION", "G-Watch ringing..."),
            new Dialogue("You", "Professor, what's happening!?"),
            new Dialogue("Professor Ai-P", "Someone hacked the game. I'm back in the real world. (Name), I need you to stop them and stall for time so I can kick them out and restore the game!"),
            new Dialogue("You", "Alright! I'm not letting this world die!"),
            new Dialogue("NARRATION", "You reach the glitchy figure."),
            new Dialogue("You", "Who are you!?"),
            new Dialogue("Glitch", "Call me Glitch. I'm the real-world savior. If you win, I'll stop. If I win, I want your autograph."),
            new Dialogue("You", "Let's do this then!"),
            new Dialogue("Glitch", "HENSHIN!"),
            new Dialogue("ANNOUNCER", "DEEKKAAARRAAANGGEEER!"),
            new Dialogue("NARRATION", "Mecha Beast: Woltrix"),
            new Dialogue("NARRATION", "After winning..."),
            new Dialogue("Glitch", "You're as good as they say. I'll keep my promise—but soon you'll know the truth."),
            new Dialogue("You", "I'll be ready."),
            new Dialogue("Professor Ai-P", "Transporting you back! We've found the culprit, but we can't go to the authorities. Check your mail; we'll meet somewhere safe."),
            new Dialogue("You", "Wonder what will happen now, well I'll just go to sleep for now.")
        };

        stages = new DialogueStage[] {
            new DialogueStage("INTRO", intro),
            new DialogueStage("STAGE1", stage1),
            new DialogueStage("STAGE2", stage2),
            new DialogueStage("STAGE3", stage3)
        };
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DialogueSystem ds = new DialogueSystem();

        System.out.print("Enter your player name: ");
        ds.setPlayerName(sc.nextLine().trim());

        System.out.println("\nControls: 'next' show next line, 'skip' jump stage, 'info' show status, 'reset' restart, 'exit' quit.");
        boolean running = true;
        while (running) {
            System.out.print("\n> ");
            String cmd = sc.nextLine().trim().toLowerCase();
            switch (cmd) {
                case "next":
                case "":
                    ds.storyDialogue();
                    break;
                case "skip":
                    System.out.print("Stage name (INTRO/STAGE1/STAGE2/STAGE3): ");
                    ds.nextStage(sc.nextLine().trim().toUpperCase());
                    break;
                case "info":
                    System.out.println("Stage: " + ds.getCurrentStage() +
                                       " | Index: " + ds.getDialogueIndex() +
                                       " | Player: " + ds.getPlayerName());
                    break;
                case "reset":
                    ds.reset();
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command. Use next, skip, info, reset, exit.");
            }
        }
        sc.close();
    }
}
