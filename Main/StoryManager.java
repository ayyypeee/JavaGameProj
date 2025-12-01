//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Main;

import java.io.PrintStream;
import java.util.Scanner;

public class StoryManager {
    Scanner scanner;
    private Player player;

    public StoryManager(Player player) {
        this.scanner = new Scanner(System.in);
        this.player = player;
    }

    public void playIntroduction() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║       WELCOME TO DIGIWORLD RPG         ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println();
        System.out.println("\u001b[36m\u001b[1mProfessor Ai-P: \u001b[97mHello and welcome, gaming prodigy and 10-time world champion!\u001b[0m");
        System.out.println();
        System.out.println("\u001b[36m\u001b[1mProfessor Ai-P: \u001b[97mWelcome to the gaming lab where you will be\u001b[0m");
        System.out.println("\u001b[97mtesting our new revolutionary game 'DigiWorld'.\u001b[0m");
        System.out.println("\u001b[97mOh, where are my manners!? I'm Professor Ai-P, and I'm in charge\u001b[0m");
        System.out.println("\u001b[97mof developing this game.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[36m\u001b[1mProfessor Ai-P: \u001b[97mYou will be transported into a world full of creatures\u001b[0m");
        System.out.println("\u001b[97mcalled 'Mecha Beasts', fuse with them, create a bond and battle together.\u001b[0m");
        this.pressEnterToContinue();
        System.out.println("\n\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mThanks for the explanation, Professor,\u001b[0m");
        System.out.println("\u001b[97mbut may I know what is the reason the government funded this game?\u001b[0m");
        System.out.println();
        System.out.println("\u001b[33m\u001b[1mGeneral Edrian: \u001b[97mI shall be the one to answer that question, Mr. " + this.player.getName() + ".\u001b[0m");
        System.out.println("\u001b[97mI was intrigued by gaming. Seeing players think like chess masters\u001b[0m");
        System.out.println("\u001b[97mor generals and coordinate their movements to win gave me an idea.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[33m\u001b[1mGeneral Edrian: \u001b[97mWhat if we create a game where you BECOME the character\u001b[0m");
        System.out.println("\u001b[97mand fight in a digital world? This way gamers could play digital games\u001b[0m");
        System.out.println("\u001b[97mwhile still being physically active, and experience the feeling of\u001b[0m");
        System.out.println("\u001b[97mbeing their character. This could create a new legacy for 'Gamers'.\u001b[0m");
        this.pressEnterToContinue();
        System.out.println("\n\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mThat doesn't fully answer my question but oh well.\u001b[0m");
        System.out.println("\u001b[97mLet's get this started.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[36m\u001b[1mProfessor Ai-P: \u001b[97mExcellent! Now before we transport you, you will need\u001b[0m");
        System.out.println("\u001b[97mthis G-Watch, M-Belt and Beast-Card.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[36m\u001b[1mProfessor Ai-P: \u001b[97mIt's time to transport you to DigiWorld!\u001b[0m");
        this.pressEnterToContinue();
    }

    public void playStage1AlphaVillage() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      STAGE 1: THE ALPHA VILLAGE        ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("\n\u001b[36m\u001b[1mProfessor Ai-P: \u001b[97mWelcome to the beta test. Your first mission is to reach\u001b[0m");
        System.out.println("\u001b[97mAlpha Village and challenge the Alpha Beast. Your G-Watch has the map,\u001b[0m");
        System.out.println("\u001b[97mso just follow the route.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[36m\u001b[1mProfessor Ai-P: \u001b[97mSince this is still in beta, you might encounter bugs.\u001b[0m");
        System.out.println("\u001b[97mReport them if you do. One more thing... you will feel pain,\u001b[0m");
        System.out.println("\u001b[97mjust like in real life. But remember, you will not die.\u001b[0m");
        this.pressEnterToContinue();
        System.out.println("\n\u001b[34m\u001b[1m" + this.player.getName() + " (startled): \u001b[97mWait... what? Pain?\u001b[0m");
        System.out.println("\u001b[97mYou didn't say anything about that!\u001b[0m");
        System.out.println();
        System.out.println("\u001b[36m\u001b[1mProfessor Ai-P: \u001b[97mGood luck. The future of gaming and your legacy\u001b[0m");
        System.out.println("\u001b[97mare in your hands.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + " (frustrated): \u001b[97mDid he just cut me off?\u001b[0m");
        System.out.println("\u001b[97mUgh, fine. No turning back now.\u001b[0m");
        this.pressEnterToContinue();
        System.out.println("\n--- You arrive at Alpha Village ---");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mHello? Anyone here?\u001b[0m");
        System.out.println();
        System.out.println("\u001b[35m\u001b[1mChief Kyle: \u001b[97mWelcome, traveler. I am Chief Kyle, guardian of this village.\u001b[0m");
        System.out.println("\u001b[97mWhat is it you seek?\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mI was told there is an Alpha Beast here.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[35m\u001b[1mChief Kyle (serious): \u001b[97mThat is true. But tell me... are you a challenger,\u001b[0m");
        System.out.println("\u001b[97mor just another treasure hunter?\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mI... I guess I am a challenger.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[35m\u001b[1mChief Kyle (nodding): \u001b[97mThen follow the Mystic Forest. The path will\u001b[0m");
        System.out.println("\u001b[97mtest you before you reach the Alpha. Be prepared.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mThank you, Chief.\u001b[0m");
        this.pressEnterToContinue();
        System.out.println("\n--- Inside the Mystic Forest ---");
        System.out.println("\n\ud83c\udfae TUTORIAL BATTLE \ud83c\udfae");
        System.out.println("\u001b[97mSound effect: BRR BRRR BRRR DIDIDIDI!\u001b[0m");
        System.out.println("\u001b[97mYou encountered a Mecha Beast!\u001b[0m");
        Combat battle = new Combat(this.player, MechaBeastFactory.createVineratops(), true, "Stage 1: Alpha Village (Tutorial)");
        battle.setTutorialMode();
        System.out.println("\n\u001b[93mAnnouncer: \u001b[97mYou have successfully completed the tutorial.\u001b[0m");
        System.out.println("\u001b[97mYou may now continue.\u001b[0m");
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + " (catching breath): \u001b[97mThat... felt too real.\u001b[0m");
        this.playAlphaBossBattle();
    }

    private void playAlphaBossBattle() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        ALPHA BOSS ENCOUNTER            ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("\n--- At the heart of the forest ---");
        System.out.println();
        System.out.println("\u001b[31m\u001b[1mAltair: \u001b[97mWho dares step into my domain?\u001b[0m");
        System.out.println();
        PrintStream var10000 = System.out;
        String var10001 = this.player.getName();
        var10000.println("\u001b[34m\u001b[1m" + var10001 + ": \u001b[97mMy name is " + this.player.getName() + ".\u001b[0m");
        System.out.println("\u001b[97mI came to challenge you.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[31m\u001b[1mAltair (smirks): \u001b[97mThen face me. I am Altair, the Alpha.\u001b[0m");
        System.out.println("\u001b[97mAnd this is my partner, the Alpha Beast, Gekuma. HENSHIN!\u001b[0m");
        System.out.println("\u001b[93m\ud83d\udd25 Announcer: \u001b[97mGEEEKKKIIIIRAAANGEEERRR! \ud83d\udd25\u001b[0m");
        this.pressEnterToContinue();
        System.out.println("\nBoss battle begins...");
        Combat battle = new Combat(this.player, MechaBeastFactory.createGekuma(), false, "Stage 1: Alpha Boss");
        boolean alphaBossWon = battle.begin();
        if (alphaBossWon) {
            System.out.println("\n\u001b[31m\u001b[1mAltair falls to one knee...\u001b[0m");
            System.out.println();
            System.out.println("\u001b[31m\u001b[1mAltair (breathing heavily): \u001b[97mYou... you lack bond with your beasts,\u001b[0m");
            System.out.println("\u001b[97myet you still defeated me. Perhaps you are more than just a beginner.\u001b[0m");
            System.out.println("\u001b[97mTake the treasure.\u001b[0m");
            System.out.println();
            System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mTreasure? I do not need that.\u001b[0m");
            System.out.println("\u001b[97mI was told only to challenge you.\u001b[0m");
            System.out.println();
            System.out.println("\u001b[31m\u001b[1mAltair (surprised, then sighs): \u001b[97mHm... how unusual.\u001b[0m");
            System.out.println("\u001b[97mThen take your victory. You may leave with your pride intact.\u001b[0m");
            System.out.println();
            System.out.println("\u001b[97mTeleportation begins...\u001b[0m");
            this.pressEnterToContinue();
            System.out.println("\n\u001b[31m\u001b[1mAltair (watching you vanish): \u001b[97mWhat a strange challenger...\u001b[0m");
            this.pressEnterToContinue();
            this.playStage1Ending();
        } else {
            this.gameOver();
            this.playAlphaBossBattle();
        }

    }

    private void playStage1Ending() {
        System.out.println("\n--- Back in the lab ---");
        System.out.println();
        System.out.println("\u001b[36m\u001b[1mProfessor Ai-P (clapping): \u001b[97mExcellent work. Stage one is complete.\u001b[0m");
        System.out.println("\u001b[97mAnd no bugs either. You handled yourself well.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + " (angry): \u001b[97mDon't act proud! You never told me\u001b[0m");
        System.out.println("\u001b[97mthe pain would feel real. I thought I was going to die!\u001b[0m");
        System.out.println();
        System.out.println("\u001b[36m\u001b[1mProfessor Ai-P (calmly): \u001b[97mBut you did not. That is the point.\u001b[0m");
        System.out.println("\u001b[97mThis game is meant to be lived, not just played.\u001b[0m");
        System.out.println("\u001b[97mNow rest. Tomorrow, the next test awaits.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + " (gritting teeth): \u001b[97mTch...\u001b[0m");
        this.pressEnterToContinue();
    }

    public void playStage2BetaCity() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║       STAGE 2: THE BETA CITY           ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("\n\u001b[36m\u001b[1mProfessor Ai-P: \u001b[97mWelcome back, " + this.player.getName() + ".\u001b[0m");
        System.out.println("\u001b[97mWe're about to begin the full test. Are you ready?\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mYes... somewhat.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[36m\u001b[1mProfessor Ai-P: \u001b[97mAlright then, transport!\u001b[0m");
        System.out.println();
        System.out.println("\u001b[93mAnnouncer: \u001b[97mTransport complete!\u001b[0m");
        this.pressEnterToContinue();
        System.out.println("\n\u001b[36m\u001b[1mProfessor Ai-P: \u001b[97mYou are now in Beta City! Your goal: defeat the\u001b[0m");
        System.out.println("\u001b[97mAce Trainer to earn a Challenge Ticket for the Tournament Trial.\u001b[0m");
        System.out.println("\u001b[97mHead to the Tournament Hall to register. Good luck, and hopefully...\u001b[0m");
        System.out.println("\u001b[97meverything goes smoothly.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mAlright! Let's go!\u001b[0m");
        this.pressEnterToContinue();
        this.playAceTrainerBattle();
        this.playTournamentTrial();
    }

    private void playAceTrainerBattle() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║     ACE TRAINER JAZZ CHALLENGE         ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("\n\u001b[31m\u001b[1mAce Jazz: \u001b[97mI am the Ace Trainer Jazz. Battle me and win,\u001b[0m");
        System.out.println("\u001b[97mfor only the strongest may pass! HENSHIN!\u001b[0m");
        System.out.println("\u001b[93m⚡ Announcer: \u001b[97mGOOOOKAAAIIIGGGEERRRR! ⚡\u001b[0m");
        this.pressEnterToContinue();
        Combat battle = new Combat(this.player, MechaBeastFactory.createPirrot(), false, "Stage 2: Beta City - Ace Trainer");
        if (battle.begin()) {
            System.out.println("\n\u001b[31m\u001b[1mAce Jazz: \u001b[97mYou've surpassed us all. Take this Challenge Ticket,\u001b[0m");
            System.out.println("\u001b[97myou've earned it. With it, you're worthy of the Tournament Trial.\u001b[0m");
            System.out.println();
            System.out.println("\u001b[93mAnnouncer: \u001b[97mCongratulations, \u001b[34m\u001b[1m" + this.player.getName() + "\u001b[97m!\u001b[0m");
            System.out.println("\u001b[97mYou've obtained the Challenge Ticket!\u001b[0m");
            System.out.println("\u001b[97mYou may now attempt the Tournament Trial!\u001b[0m");
            this.pressEnterToContinue();
        } else {
            this.gameOver();
            this.playStage2BetaCity();
        }

    }

    private void playTournamentTrial() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║       TOURNAMENT TRIAL                 ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("\n--- At the Tournament Trial ---");
        System.out.println();
        System.out.println("\u001b[31m\u001b[1mTrialmaster: \u001b[97mWelcome, challenger! I am Trialmaster!\u001b[0m");
        System.out.println("\u001b[97mWill you defeat me to qualify for the tournament,\u001b[0m");
        System.out.println("\u001b[97mor start all over again?\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mWait... Professor? Is that you?\u001b[0m");
        System.out.println("\u001b[97mAre you also testing the game, or is this some NPC of you?\u001b[0m");
        System.out.println();
        System.out.println("\u001b[31m\u001b[1mTrialmaster: \u001b[97mIIII... d-d-don't know who this Professor\u001b[0m");
        System.out.println("\u001b[97myou're talking about!\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mSeriously!? You're a bad liar.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[31m\u001b[1mTrialmaster: \u001b[97mEnough talk! Prove your strength first,\u001b[0m");
        System.out.println("\u001b[97mthen I'll answer. HENSHIN!\u001b[0m");
        System.out.println("\u001b[93m\ud83d\udd50 Announcer: \u001b[97mTIIMMEERRAANGGEERR! \ud83d\udd50\u001b[0m");
        this.pressEnterToContinue();
        Combat battle = new Combat(this.player, MechaBeastFactory.createWisdrake(), false, "Stage 2: Tournament Trial");
        if (battle.begin()) {
            System.out.println("\n\u001b[31m\u001b[1mTrialmaster: \u001b[97mYou have beaten me. You are qualified for the tournament!\u001b[0m");
            System.out.println("\u001b[97mAnd I suppose I'll answer some of your questions.\u001b[0m");
            System.out.println();
            System.out.println("\u001b[31m\u001b[1mTrialmaster: \u001b[97mYes, I'm the Professor, but in this game I'm Trialmaster.\u001b[0m");
            System.out.println("\u001b[97mI've decided to transport into this world to see if there are no glitches\u001b[0m");
            System.out.println("\u001b[97meven in the smallest parts! I feel like something bad is going to happen\u001b[0m");
            System.out.println("\u001b[97mand to prevent that, I decided to see it for myself instead of just\u001b[0m");
            System.out.println("\u001b[97minspecting you.\u001b[0m");
            this.pressEnterToContinue();
            System.out.println("\n\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mBut why would there be something bad that's\u001b[0m");
            System.out.println("\u001b[97mgoing to happen? Aren't you a genius who has already thought of\u001b[0m");
            System.out.println("\u001b[97meverything for this game?\u001b[0m");
            System.out.println();
            System.out.println("\u001b[31m\u001b[1mTrialmaster: \u001b[97mTrue, but there had been quarrels between staff and the\u001b[0m");
            System.out.println("\u001b[97mGeneral even before the beta test started. All because of reasonable\u001b[0m");
            System.out.println("\u001b[97mreasons that I can't share with you... for now.\u001b[0m");
            System.out.println("\u001b[97mLet's just continue our beta test and see what happens.\u001b[0m");
            System.out.println();
            System.out.println("\u001b[93mAnnouncer: \u001b[97mCongratulations challenger \u001b[34m\u001b[1m" + this.player.getName() + "\u001b[97m,\u001b[0m");
            System.out.println("\u001b[97myou are now registered in the tournament!\u001b[0m");
            this.pressEnterToContinue();
        } else {
            this.gameOver();
            this.playTournamentTrial();
        }

    }

    public void playStage3Collapse() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   STAGE 3: THE COLLAPSE OF BETA CITY   ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("\n\u001b[93mAnnouncer: \u001b[97mIT'S TIME FOR THE TOURNA– BZZZT–KRZZHH–VRRRTTCHH—\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mHuh? A glitch?\u001b[0m");
        this.pressEnterToContinue();
        System.out.println("\n\u001b[97m⚠️ BZZZZZT–KRZZZHHHH–VVVRRRTTTCCCHHHHHHH–KRRRRAAAASHHHH ⚠️\u001b[0m");
        System.out.println();
        System.out.println("\u001b[31m\u001b[1mTrialmaster: \u001b[97mTHE CITY IS COLLAPSING!\u001b[0m");
        System.out.println();
        System.out.println("\u001b[31m\u001b[1m???: \u001b[97mProfessor, I'm logging you out for safety.\u001b[0m");
        System.out.println("\u001b[97mNow it's time to destroy Beta City.\u001b[0m");
        this.pressEnterToContinue();
        System.out.println("\n\u001b[97m\ud83d\udcde G-Watch (ringing)...\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mProfessor, what's happening!?\u001b[0m");
        System.out.println();
        System.out.println("\u001b[36m\u001b[1mProfessor Ai-P: \u001b[97mSomeone hacked the game. I'm back in the real world.\u001b[0m");
        System.out.println("\u001b[97m" + this.player.getName() + ", I need you to stop them and stall for time\u001b[0m");
        System.out.println("\u001b[97mso I can kick them out and restore the game!\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mAlright! I'm not letting this world die!\u001b[0m");
        this.pressEnterToContinue();
        this.playGlitchEncounter();
    }

    private void playGlitchEncounter() {
        System.out.println("\n--- You reach the glitchy figure ---");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mWho are you!?\u001b[0m");
        System.out.println();
        System.out.println("\u001b[31m\u001b[1m???: \u001b[97mI am Khai, known as The Glitch, the savior of the real world\u001b[0m");
        System.out.println("\u001b[97mIf you win, I'll stop. If I win, I want your autograph.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mLet's do this then!\u001b[0m");
        System.out.println();
        System.out.println("\u001b[31m\u001b[1mGlitch: \u001b[97mHENSHIN!\u001b[0m");
        System.out.println("\u001b[93m\ud83d\ude94 Announcer: \u001b[97mDEEKKAAARRAAANGGEEER! \ud83d\ude94\u001b[0m");
        this.pressEnterToContinue();
        this.playFinalBoss();
    }

    private void playFinalBoss() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          FINAL BOSS BATTLE             ║");
        System.out.println("╚════════════════════════════════════════╝");
        Combat battle = new Combat(this.player, MechaBeastFactory.createWoltrix(), false, "Stage 3: Final Boss");
        if (battle.begin()) {
            this.playEnding();
        } else {
            this.gameOver();
            this.playGlitchEncounter();
        }

    }

    private void playEnding() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         GAME SAVED! YOU WIN!           ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("\n\u001b[31m\u001b[1mGlitch: \u001b[97mYou're as good as they say. I'll keep my promise—\u001b[0m");
        System.out.println("\u001b[97mbut soon you'll know the truth.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mI'll be ready.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[36m\u001b[1mProfessor Ai-P: \u001b[97mTransporting you back! We've found the culprit,\u001b[0m");
        System.out.println("\u001b[97mbut we can't go to the authorities. Check your mail;\u001b[0m");
        System.out.println("\u001b[97mwe'll meet somewhere safe.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[34m\u001b[1m" + this.player.getName() + ": \u001b[97mWonder what will happen now,\u001b[0m");
        System.out.println("\u001b[97mwell I'll just go to sleep for now.\u001b[0m");
        System.out.println();
        System.out.println("\u001b[97m\n✨ TO BE CONTINUED... ✨\u001b[0m");
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║    THANK YOU FOR PLAYING DIGIWORLD!    ║");
        System.out.println("║      Your legacy continues, Champion!  ║");
        System.out.println("╚════════════════════════════════════════╝");
    }

    private void pressEnterToContinue() {
        System.out.println("\n[Press ENTER to continue]");
        this.scanner.nextLine();
    }

    private void gameOver() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║              GAME OVER                 ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("\nTry again?");
        System.out.println("Press ENTER to restart.");
        this.scanner.nextLine();
        System.out.println("\nRESTARTING...");
        System.out.println("\n=========================================");
    }
}
