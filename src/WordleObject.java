import java.util.ArrayList;
import java.util.Collections;
//this class is used to represent the word people are trying to solve.

public class WordleObject {
    private final String[] letters;  //size 5
    private final ArrayList<String> alphabetsNotUsedYet; //everytime a user guesses a letter, take out a letter
    private final ArrayList<String> alphabetsGreen;
    private final ArrayList<String> alphabetsYellow;
    private final ArrayList<String> alphabetsGray;

    public WordleObject(String[] letters)
    {
        this.letters = letters; // this contains the golden word that we need to guess
        alphabetsNotUsedYet = new ArrayList<>();
        alphabetsGreen = new ArrayList< >();
        for (int i = 0; i < 5; i++) {
            alphabetsGreen.add(i, "0");
        }
        alphabetsYellow = new ArrayList<>();
        alphabetsGray = new ArrayList<>();
        String[] x = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w"
                , "x", "y", "z",};

        Collections.addAll(alphabetsNotUsedYet, x);
    }

    public boolean checkWord(String guess){
        int greenCount = 0;

        // we will compare character by character
        for (int i = 0; i < 5; i++) {
            String c = String.valueOf(guess.charAt(i));
            if (c.equals(letters[i]) ){// match at the location
                System.out.print(c + " is green at " + i + "     ");
                greenCount++;
                alphabetsGreen.add(i, c);
                alphabetsYellow.remove(c);
            } else if(isLetterInTheWord(c)){
                System.out.print(c + " is yellow at " + i + "     ");
                if(!alphabetsYellow.contains(c)) {
                    alphabetsYellow.add(c);
                }
            } else{
                System.out.print(c + " is gray at " + i + "     ");
                alphabetsGray.add(c);
            }
            alphabetsNotUsedYet.remove(c);
        }
        System.out.println();
        System.out.println();
        System.out.println("These are the green letters: " + asString(alphabetsGreen));
        System.out.println("These are the yellow letters: " + alphabetsYellow);
        System.out.println("These are the gray letters: " + alphabetsGray);
        System.out.println("These are the unused letters: " + alphabetsNotUsedYet);
        System.out.println();
        return greenCount == 5;
    }

    private String asString(ArrayList<String> listOfStrings) {
        String value = "";
        for (int i = 0; i < 5; i++) {
            String letter = listOfStrings.get(i);
            if (!"0".equals(letter)) {
                value = value + i + ":" + letter + ",";
            }
        }
        return value;
    }

    private boolean isLetterInTheWord(String c)
    {
        for (int i = 0; i < 5; i++) {
            if(c.equals(letters[i])){
                return true;
            }
        }
        return false;
    }
}
