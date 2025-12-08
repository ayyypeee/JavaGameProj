
public class DialogueStage {
    private String stageName;
    private Dialogue[] dialogues;

    public DialogueStage(String stageName, Dialogue[] dialogues) {
        this.stageName = stageName;
        this.dialogues = dialogues;
    }

    public String getStageName() {
        return stageName;
    }

    public int getSize() {
        return dialogues.length;
    }

    public Dialogue getDialogue(int index) {
        if (index >= 0 && index < dialogues.length) {
            return dialogues[index];
        } else {
            return null;
        }
    }
}
