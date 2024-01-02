import java.util.*;
//this class is used to represent the word people are trying to solve.

public class WordleObject {
    private String[] letters;  //size 5
    private ArrayList<String> alphabet;  //everytime a user guesses a letter, take out a letter

    public void wordleObject(String[] letters)
    {
        this.letters = letters;
        alphabet = new ArrayList<String>();
        String[] x = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w"
                , "x", "y", "z",};
        for (String temp : x)
            alphabet.add(temp);
    }

    //YOU CAN CODE HERE
    public static int checkWord(String guess, String goldenWord, int goAgain, ArrayList<String> alphabet)
    {
        boolean checkEquality = true;
        boolean checkEqualityHypothetical = true;
        int betweenCounterAndFive;
        for (int count = 0; count <= 4; count++) {
            for (int counter = 0; counter <= 4; counter++) {
                checkEquality = guess.substring(count, count + 1).equals(goldenWord.substring(counter, counter + 1));
                if (checkEquality && count == counter) {
                    System.out.print(guess.substring(count, count + 1) + " is green at " + count + "     ");
                    alphabet.remove(guess.substring(count,count+1));
                    if (count == 4) {
                        break;
                    }
                    count++;
                    counter = 0;
                } else if (checkEquality && count != counter) {
                    alphabet.remove(guess.substring(count,count+1));
                    for(betweenCounterAndFive = counter+1; betweenCounterAndFive <=4; betweenCounterAndFive++)
                    {
                        checkEqualityHypothetical = guess.substring(count, count+1).equals(goldenWord.substring(betweenCounterAndFive,betweenCounterAndFive+1));
                        if(checkEqualityHypothetical && betweenCounterAndFive == count)
                        {
                            System.out.print(guess.substring(count, count+1) + " is green at " + count + "     ");
                            if (count == 4) {
                                break;
                            }
                            count++;
                            counter = 0;
                        }
                    }
                    System.out.print(guess.substring(count, count + 1) + " is yellow at " + count + "     ");
                    if (count == 4) {
                        break;
                    }
                    count++;
                    goAgain++;
                    counter = 0;
                } else if (!checkEquality && counter == 4) {
                    System.out.print(guess.substring(count, count + 1) + " is gray at " + count + "     ");
                    alphabet.remove(guess.substring(count,count+1));
                    if (count == 4) {
                        break;
                    }
                    count++;
                    goAgain++;
                    counter = 0;
                }
            }
        }
        System.out.println();
        System.out.println("These are all the letters you haven't guessed.");
        System.out.println(alphabet);

        return goAgain;
    }

    public static boolean AnotherTry (String guess, String goldenWord, int goAgain, ArrayList<String> alphabet)
    {
        boolean Continue = true;
        int goAgainAfterCheckWord = 0;
        goAgainAfterCheckWord = WordleObject.checkWord(guess, goldenWord, goAgain, alphabet);
        if(goAgainAfterCheckWord > 0)
        {
            Continue = true;
        }
        else if(goAgainAfterCheckWord == 0)
        {
            Continue = false;
        }
        return Continue;
    }

}
