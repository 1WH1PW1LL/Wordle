public class LetterPosition {
    private String letter;

    private int position;

    public LetterPosition(String letter, int position) {
        this.letter = letter;
        this.position = position;
    }

    public String getLetter() {
        return letter;
    }

    public int getPosition() {
        return position;
    }

    public String toString() {
        return letter + ":" + position;
    }

}
