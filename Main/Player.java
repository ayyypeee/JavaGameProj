package Main;

public class Player {

    private String name;
    private MechaBeast[] mechaBeasts;
    private int beastCount;
    private int currentBeastIndex;

    public Player(String name) {
        this.name = name;
        this.mechaBeasts = new MechaBeast[3];
        this.beastCount = 0;
        this.currentBeastIndex = 0;
    }

    public void addMechaBeast(MechaBeast beast) {
        //Prevent overflow
        try {
            if (beastCount < 3) {
                mechaBeasts[beastCount] = beast;
                beastCount++;
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
    // e return and current active beast
    public MechaBeast getCurrentBeast() {
        if (beastCount == 0)
            return null;
        return mechaBeasts[currentBeastIndex];
    }
    // e set ang current active beast by index
    public void setCurrentBeastIndex(int index) {
        if (index >= 0 && index < beastCount) {
            this.currentBeastIndex = index;
        }
    }
    //then get current active beast index
    public int getCurrentBeastIndex() {
        return currentBeastIndex;
    }
    //e check ra if naa pay buhi nga beast
    public boolean hasAliveBeast() {
        for (int i = 0; i < beastCount; i++) {
            if (mechaBeasts[i].isAlive()) {
                return true;
            }
        }
        return false;
    }
    // Heals all beasts to full health
    public void healAllBeasts() {
        for (int i = 0; i < beastCount; i++) {
            mechaBeasts[i].fullHeal();
        }
    }

    // Counts alive beasts
    public int getAliveCount() {
        int count = 0;
        for (int i = 0; i < beastCount; i++) {
            if (mechaBeasts[i].isAlive())
                count++;
        }
        return count;
    }
}