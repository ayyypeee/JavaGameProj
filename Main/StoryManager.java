package Main;

import java.util.Scanner;

public class StoryManager {
   Scanner scanner = new Scanner(System.in);
    private Player player;

    public StoryManager(Player player) {
        this.player = player;
    }
    //Intro
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

    // Stage 1
    public void playStage1AlphaVillage() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      STAGE 1: THE ALPHA VILLAGE        ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\nProfessor Ai-P: Welcome to the beta test. Your first mission is to reach");
        System.out.println("Alpha Village and challenge the Alpha Beast. Your G-Watch has the map,");
        System.out.println("so just follow the route.");
        System.out.println();
        System.out.println("Professor Ai-P: Since this is still in beta, you might encounter bugs.");
        System.out.println("Report them if you do. One more thing... you will feel pain,");
        System.out.println("just like in real life. But remember, you will not die.");
        pressEnterToContinue();

        System.out.println("\n" + player.getName() + " (startled): Wait... what? Pain?");
        System.out.println("You didn't say anything about that!");
        System.out.println();
        System.out.println("Professor Ai-P: Good luck. The future of gaming and your legacy");
        System.out.println("are in your hands.");
        System.out.println();
        System.out.println(player.getName() + " (frustrated): Did he just cut me off?");
        System.out.println("Ugh, fine. No turning back now.");
        pressEnterToContinue();

        System.out.println("\n--- You arrive at Alpha Village ---");
        System.out.println();
        System.out.println(player.getName() + ": Hello? Anyone here?");
        System.out.println();
        System.out.println("Chief Rei: Welcome, traveler. I am Chief Rei, guardian of this village.");
        System.out.println("What is it you seek?");
        System.out.println();
        System.out.println(player.getName() + ": I was told there is an Alpha Beast here.");
        System.out.println();
        System.out.println("Chief Rei (serious): That is true. But tell me... are you a challenger,");
        System.out.println("or just another treasure hunter?");
        System.out.println();
        System.out.println(player.getName() + ": I... I guess I am a challenger.");
        System.out.println();
        System.out.println("Chief Rei (nodding): Then follow the Mystic Forest. The path will");
        System.out.println("test you before you reach the Alpha. Be prepared.");
        System.out.println();
        System.out.println(player.getName() + ": Thank you, Chief.");
        pressEnterToContinue();

        // Tutorial Battle
        System.out.println("\n--- Inside the Mystic Forest ---");
        System.out.println("\n🎮 TUTORIAL BATTLE 🎮");
        System.out.println("Sound effect: BRR BRRR BRRR DIDIDIDI!");
        System.out.println("You encountered a Mecha Beast!");


        Combat battle = new Combat(player, MechaBeastFactory.createVineratops(), true);
        
        battle.setTutorialMode();

        
        System.out.println("\nAnnouncer: You have successfully completed the tutorial.");
        System.out.println("You may now continue.");
        System.out.println(player.getName() + " (catching breath): That... felt too real.");

        playAlphaBossBattle();
        
    }

    private void playAlphaBossBattle() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        ALPHA BOSS ENCOUNTER            ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\n--- At the heart of the forest ---");
        System.out.println();
        System.out.println("Altair: Who dares step into my domain?");
        System.out.println();
        System.out.println(player.getName() + ": My name is " + player.getName() + ".");
        System.out.println("I came to challenge you.");
        System.out.println();
        System.out.println("Altair (smirks): Then face me. I am Altair, the Alpha.");
        System.out.println("And this is my partner, the Alpha Beast, Gekuma. HENSHIN!");
        System.out.println("🔥 Announcer: GEEEKKKIIIIRAAANGEEERRR! 🔥");
        pressEnterToContinue();

        System.out.println("\nBoss battle begins...");
  
        Combat battle = new Combat(player, MechaBeastFactory.createGekuma(), false);
        boolean alphaBossWon = battle.begin();

        if (alphaBossWon) {
            player.getCurrentBeast().fullHeal();

            System.out.println("\nAltair falls to one knee...");
            System.out.println();
            System.out.println("Altair (breathing heavily): You... you lack bond with your beasts,");
            System.out.println("yet you still defeated me. Perhaps you are more than just a beginner.");
            System.out.println("Take the treasure.");
            System.out.println();
            System.out.println(player.getName() + ": Treasure? I do not need that.");
            System.out.println("I was told only to challenge you.");
            System.out.println();
            System.out.println("Altair (surprised, then sighs): Hm... how unusual.");
            System.out.println("Then take your victory. You may leave with your pride intact.");
            System.out.println();
            System.out.println("Teleportation begins...");
            pressEnterToContinue();

            System.out.println("\nAltair (watching you vanish): What a strange challenger...");
            pressEnterToContinue();

            playStage1Ending();
        }
    }

    private void playStage1Ending() {
        System.out.println("\n--- Back in the lab ---");
        System.out.println();
        System.out.println("Professor Ai-P (clapping): Excellent work. Stage one is complete.");
        System.out.println("And no bugs either. You handled yourself well.");
        System.out.println();
        System.out.println(player.getName() + " (angry): Don't act proud! You never told me");
        System.out.println("the pain would feel real. I thought I was going to die!");
        System.out.println();
        System.out.println("Professor Ai-P (calmly): But you did not. That is the point.");
        System.out.println("This game is meant to be lived, not just played.");
        System.out.println("Now rest. Tomorrow, the next test awaits.");
        System.out.println();
        System.out.println(player.getName() + " (gritting teeth): Tch...");
        pressEnterToContinue();
    }
    // Stage 2

    public void playStage2BetaCity() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║       STAGE 2: THE BETA CITY           ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\nProfessor Ai-P: Welcome back, " + player.getName() + ".");
        System.out.println("We're about to begin the full test. Are you ready?");
        System.out.println();
        System.out.println(player.getName() + ": Yes... somewhat.");
        System.out.println();
        System.out.println("Professor Ai-P: Alright then, transport!");
        System.out.println();
        System.out.println("Announcer: Transport complete!");
        pressEnterToContinue();

        System.out.println("\nProfessor Ai-P: You are now in Beta City! Your goal: defeat the");
        System.out.println("Ace Trainer to earn a Challenge Ticket for the Tournament Trial.");
        System.out.println("Head to the Tournament Hall to register. Good luck, and hopefully...");
        System.out.println("everything goes smoothly.");
        System.out.println();
        System.out.println(player.getName() + ": Alright! Let's go!");
        pressEnterToContinue();

        playAceTrainerBattle();
        playTournamentTrial();
    }

    private void playAceTrainerBattle() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║     ACE TRAINER JAZZ CHALLENGE         ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\nAce Jazz: I am the Ace Trainer Jazz. Battle me and win,");
        System.out.println("for only the strongest may pass! HENSHIN!");
        System.out.println("⚡ Announcer: GOOOOKAAAIIIGGGEERRRR! ⚡");
        pressEnterToContinue();
        

        Combat battle = new Combat(player, MechaBeastFactory.createPirrot(), false);
        if (battle.begin()) {
            player.getCurrentBeast().fullHeal();

            System.out.println("\nAce Jazz: You've surpassed us all. Take this Challenge Ticket,");
            System.out.println("you've earned it. With it, you're worthy of the Tournament Trial.");
            System.out.println();
            System.out.println("Announcer: Congratulations, " + player.getName() + "!");
            System.out.println("You've obtained the Challenge Ticket!");
            System.out.println("You may now attempt the Tournament Trial!");
            pressEnterToContinue();
        }
    }

    private void playTournamentTrial() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║       TOURNAMENT TRIAL                 ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\n--- At the Tournament Trial ---");
        System.out.println();
        System.out.println("Trialmaster: Welcome, challenger! I am Trialmaster!");
        System.out.println("Will you defeat me to qualify for the tournament,");
        System.out.println("or start all over again?");
        System.out.println();
        System.out.println(player.getName() + ": Wait... Professor? Is that you?");
        System.out.println("Are you also testing the game, or is this some NPC of you?");
        System.out.println();
        System.out.println("Trialmaster: IIII... d-d-don't know who this Professor");
        System.out.println("you're talking about!");
        System.out.println();
        System.out.println(player.getName() + ": Seriously!? You're a bad liar.");
        System.out.println();
        System.out.println("Trialmaster: Enough talk! Prove your strength first,");
        System.out.println("then I'll answer. HENSHIN!");
        System.out.println("🕐 Announcer: TIIMMEERRAANGGEERR! 🕐");
        pressEnterToContinue();

    
        Combat battle = new Combat(player, MechaBeastFactory.createWisdrake(), false);
        if (battle.begin()) {
            player.getCurrentBeast().fullHeal();

            System.out.println("\nTrialmaster: You have beaten me. You are qualified for the tournament!");
            System.out.println("And I suppose I'll answer some of your questions.");
            System.out.println();
            System.out.println("Trialmaster: Yes, I'm the Professor, but in this game I'm Trialmaster.");
            System.out.println("I've decided to transport into this world to see if there are no glitches");
            System.out.println("even in the smallest parts! I feel like something bad is going to happen");
            System.out.println("and to prevent that, I decided to see it for myself instead of just");
            System.out.println("inspecting you.");
            pressEnterToContinue();

            System.out.println("\n" + player.getName() + ": But why would there be something bad that's");
            System.out.println("going to happen? Aren't you a genius who has already thought of");
            System.out.println("everything for this game?");
            System.out.println();
            System.out.println("Trialmaster: True, but there had been quarrels between staff and the");
            System.out.println("General even before the beta test started. All because of reasonable");
            System.out.println("reasons that I can't share with you... for now.");
            System.out.println("Let's just continue our beta test and see what happens.");
            System.out.println();
            System.out.println("Announcer: Congratulations challenger " + player.getName() + ",");
            System.out.println("you are now registered in the tournament!");
            pressEnterToContinue();
        }
    }

    // Stage 3
    public void playStage3Collapse() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   STAGE 3: THE COLLAPSE OF BETA CITY   ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\nAnnouncer: IT'S TIME FOR THE TOURNA– BZZZT–KRZZHH–VRRRTTCHH—");
        System.out.println();
        System.out.println(player.getName() + ": Huh? A glitch?");
        pressEnterToContinue();

        System.out.println("\n⚠️ BZZZZZT–KRZZZHHHH–VVVRRRTTTCCCHHHHHHH–KRRRRAAAASHHHH ⚠️");
        System.out.println();
        System.out.println("Trialmaster: THE CITY IS COLLAPSING!");
        System.out.println();
        System.out.println("???: Professor, I'm logging you out for safety.");
        System.out.println("Now it's time to destroy Beta City.");
        pressEnterToContinue();

        System.out.println("\n📞 G-Watch (ringing)...");
        System.out.println();
        System.out.println(player.getName() + ": Professor, what's happening!?");
        System.out.println();
        System.out.println("Professor Ai-P: Someone hacked the game. I'm back in the real world.");
        System.out.println(player.getName() + ", I need you to stop them and stall for time");
        System.out.println("so I can kick them out and restore the game!");
        System.out.println();
        System.out.println(player.getName() + ": Alright! I'm not letting this world die!");
        pressEnterToContinue();

        playGlitchEncounter();
    }

    private void playGlitchEncounter() {
        System.out.println("\n--- You reach the glitchy figure ---");
        System.out.println();
        System.out.println(player.getName() + ": Who are you!?");
        System.out.println();
        System.out.println("???: Call me Glitch. I'm the real-world savior.");
        System.out.println("If you win, I'll stop. If I win, I want your autograph.");
        System.out.println();
        System.out.println(player.getName() + ": Let's do this then!");
        System.out.println();
        System.out.println("Glitch: HENSHIN!");
        System.out.println("🚔 Announcer: DEEKKAAARRAAANGGEEER! 🚔");
        pressEnterToContinue();

        playFinalBoss();
    }

    // Final boss battle
    private void playFinalBoss() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          FINAL BOSS BATTLE             ║");
        System.out.println("╚════════════════════════════════════════╝");

        Combat battle = new Combat(player, MechaBeastFactory.createWoltrix(), false);
        if (battle.begin()) {
            player.getCurrentBeast().fullHeal();
            playEnding();
        }
    }

    private void playEnding() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         GAME SAVED! YOU WIN!           ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\nGlitch: You're as good as they say. I'll keep my promise—");
        System.out.println("but soon you'll know the truth.");
        System.out.println();
        System.out.println(player.getName() + ": I'll be ready.");
        System.out.println();
        System.out.println("Professor Ai-P: Transporting you back! We've found the culprit,");
        System.out.println("but we can't go to the authorities. Check your mail;");
        System.out.println("we'll meet somewhere safe.");
        System.out.println();
        System.out.println(player.getName() + ": Wonder what will happen now,");
        System.out.println("well I'll just go to sleep for now.");
        System.out.println();
        System.out.println("\n✨ TO BE CONTINUED... ✨");

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║    THANK YOU FOR PLAYING DIGIWORLD!    ║");
        System.out.println("║      Your legacy continues, Champion!  ║");
        System.out.println("╚════════════════════════════════════════╝");
    }

    private void pressEnterToContinue() {
        System.out.println("\n[Press ENTER to continue]");
        scanner.nextLine();
    }
}
