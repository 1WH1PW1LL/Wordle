import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordleApp {
    public static void main(String[] args) {
        //this part of code will take all the words from the list and store it all in allWords
        ArrayList<String> allLegalWords = loadWordList();

        //START YOUR CODE HERE

        // This piece of code picks out the word the user will be guessing.
        String goldenWord = getWordToGuess(allLegalWords);

        String[] letters = convertToStringArray(goldenWord);

        WordleObject wordleObject = new WordleObject(letters);

        printUserInformation();

        guessTheWord(allLegalWords, wordleObject);

        System.out.println("The answer was: " + goldenWord);
    }

    private static String[] convertToStringArray(String goldenWord) {
        String[] letters = new String[5];
        for (int i = 0; i < 5; i++) {
            char c = goldenWord.charAt(i);
            letters[i] = String.valueOf(c);
        }
        return letters;
    }

    private static void guessTheWord(ArrayList<String> allLegalWords, WordleObject wordleObject) {
        int keepGoing = 0;
        boolean continueFlg;
        Scanner keyboard = new Scanner(System.in);
        do {
            String guess = keyboard.nextLine();
            if(null == guess || guess.length() != 5 ){
                System.out.println("You need to enter a 5 letter word before hitting enter");
                continueFlg = false;
                continue;
            }
            // validate for legal words only.
            if(isWordLegal(allLegalWords, guess)){
                // word is legal. Now do the check for the character positions
                continueFlg = wordleObject.checkWord(guess);
                if(!continueFlg)
                    System.out.println("Continue guessing");
                else
                    System.out.println("You have guessed the word");
                keepGoing++;
            }else{
                // an invalid word does not count towards the 6 tries
                continueFlg = false;
            }
        }while(!continueFlg && keepGoing < 6);
    }

    private static void printUserInformation() {
        System.out.println();
        System.out.println("Start guessing.");
    }

    private static String getWordToGuess(ArrayList<String> allWords) {
        int numberOfFiveLetterWords = allWords.size();
        int randomIndexToGrabWordFromAllFiveLetterWordsArray = (int) (Math.random()*numberOfFiveLetterWords);
        return  allWords.get(randomIndexToGrabWordFromAllFiveLetterWordsArray);
    }

    private static ArrayList<String> loadWordList() {
        ArrayList<String> allWords = new ArrayList<>();
        try {
            File myObj = new File("C:\\Users\\timpa\\MyDrive\\msj-school-work\\g11\\CSA\\Wordle\\src\\wordle.txt");
//            File myObj = new File("C:/Users/timpa/MyDrive/msj-school-work/g11/CSA/Wordle/src/wordle.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                allWords.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return allWords;
    }

    // validates if the enterted word is legal.
    private static boolean isWordLegal(ArrayList<String> allWords, String guess) {
        boolean valid = true;

        int i = 0;
        while(i < allWords.size()) {
            if(guess.equals((allWords.get(i)))) {
                break;
            }

            if(!guess.equals(allWords.get(i)) && i == allWords.size()-1) {
                System.out.println("Please enter a legal word. Guess Again.");
                valid = false;
                break;
            }
            i++;
        }
        return valid;
    }
}
