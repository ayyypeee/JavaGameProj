package Main;

public class Player {
    private String name;                    // Player's name
    private MechaBeast[] mechaBeasts;       // Array to hold up to 3 beasts
    private int beastCount;                 // How many beasts the player currently has
    private int currentBeastIndex;          // Which beast is currently in battle

    public Player(String name) {
        this.name = name;
        this.mechaBeasts = new MechaBeast[3];  // Maximum 3 beasts per player
        this.beastCount = 0;                   // Start with no beasts
        this.currentBeastIndex = 0;            // Start at first position
    }

    public void addMechaBeast(MechaBeast beast) {
        try {
            // Check if there's room for another beast
            if (beastCount < 3) {
                mechaBeasts[beastCount] = beast;
                beastCount++;
            } else {
                System.out.println("Error: Cannot add more than 3 beasts!");
            }
        } catch (Exception e) {
            System.out.println("Error adding beast: " + e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public MechaBeast[] getMechaBeasts() {
        return mechaBeasts;
    }

    public int getBeastCount() {
        return beastCount;
    }

    public MechaBeast getCurrentBeast() {
        // return null if player has no beasts
        if (beastCount == 0) {
            return null;
        }
        return mechaBeasts[currentBeastIndex];
    }

    public void setCurrentBeastIndex(int index) {
        // Validate the index is within valid range
        if (index >= 0 && index < beastCount) {
            this.currentBeastIndex = index;
        } else {
            System.out.println("Error: Invalid beast index!");
        }
    }

    public boolean hasAliveBeast() {
        for (int i = 0; i < beastCount; i++) {
            if (mechaBeasts[i].isAlive()) {
                return true;  // Found at least one alive beast
            }
        }
        return false;  // No alive beasts found
    }

    public void healAllBeasts() {
        for (int i = 0; i < beastCount; i++) {
            mechaBeasts[i].fullHeal();
        }
    }

}