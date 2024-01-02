import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;


public class WordleMain {
    public static void main(String[] args) {
        //this part of code will take all the words from the list and store it all in allWords
        ArrayList<String> allWords = new ArrayList<String>();
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

        //START YOUR CODE HERE

        // Setting up all the variables and objects
        Scanner keyboard = new Scanner(System.in);
        int numberOfFiveLetterWords;
        int randomIndexToGrabWordFromAllFiveLetterWordsArray;
        String goldenWord;
        String guess;
        boolean Continue = false;
        int keepGoing = 0;
        int goAgain = 0;
        ArrayList<String> alphabet = new ArrayList<String>();
        String[] x = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w"
                , "x", "y", "z",};
        for (String temp : x)
            alphabet.add(temp);

        // This piece of code picks out the word the user will be guessing.
        numberOfFiveLetterWords = allWords.size();
        randomIndexToGrabWordFromAllFiveLetterWordsArray = (int) (Math.random()*numberOfFiveLetterWords);
        goldenWord = allWords.get(randomIndexToGrabWordFromAllFiveLetterWordsArray);
        // System.out.println(goldenWord);

        // User guesses words.
        System.out.println("Directions:");
        System.out.println("True means that you are wrong and need to keep guessing.");
        System.out.println("False means that you have correctly guessed the word.");
        System.out.println();
        System.out.println("Start guessing.");
        do
        {
            guess = keyboard.nextLine();
            int i = 0;
            while(i < allWords.size())
            {
                if(guess.equals((allWords.get(i))))
                {
                    break;
                }

                if(!guess.equals(allWords.get(i)) && i == allWords.size()-1)
                {
                    System.out.println("Please enter a legal word. Guess Again.");
                    guess = keyboard.nextLine();
                    i=-1;
                }
                i++;
            }
            Continue = WordleObject.AnotherTry(guess, goldenWord, goAgain, alphabet);
            System.out.println(Continue);
            keepGoing++;
        }while(Continue == true && keepGoing < 6);

        System.out.println("The answer was: ");
        System.out.println(goldenWord);





    }
}
