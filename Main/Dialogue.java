
public class Dialogue {
    private String speaker;
    private String text;

    public Dialogue(String speaker, String text) {
        this.speaker = speaker;
        this.text = text;
    }

    public void display(String playerName) {
        String out = text;
        if (playerName != null && !playerName.isEmpty()) {
            out = out.replace("(name)", playerName).replace("(Name)", playerName);
        }
        if ("ANNOUNCER".equalsIgnoreCase(speaker)) {
            System.out.println("\n[" + speaker.toUpperCase() + "]: " + out);
        } else if ("NARRATION".equalsIgnoreCase(speaker)) {
            System.out.println("\n" + out);
        } else {
            System.out.println("\n" + speaker + ": " + out);
        }
    }
}
