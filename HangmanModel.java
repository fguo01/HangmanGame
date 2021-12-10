package hangmangame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * create a class HangmanModel with three fields, a guess word, a word board and a chances left
 */
public class HangmanModel implements Hangman {
    private final char[] guessWord;
    private char[] wordBoard;
    private int chancesLeft;

    /**
     * Construct the HangmanModel with the guessWord
     */
    public HangmanModel(){
        this.guessWord = newGameWord();
        int numsOfLetter = this.guessWord.length;
        this.wordBoard = new char[numsOfLetter];
        Arrays.fill(this.wordBoard,'_');
        this.chancesLeft = 8;
    }

    /**
     * Construct the HangmanModel with the guessWord as an input for test only
     */
    public HangmanModel(String newWord){
        this.guessWord = newWord.toCharArray();
        int numsOfLetter = this.guessWord.length;
        this.wordBoard = new char[numsOfLetter];
        Arrays.fill(this.wordBoard,'_');
        this.chancesLeft = 8;
    }


    /**
     * Return a word randomly choose from the wordlist
     * @return a word randomly choose from the wordlist
     */
    private char[] newGameWord(){
        try{
            String line = null;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/liz/IdeaProjects/project06/src/pics/words.txt"));
            String str = "";
            while((line = bufferedReader.readLine()) != null){
                str += " " + line;
            }
            bufferedReader.close();
            String[] wordlist = str.split("\\s+");
            Random random = new Random();
            int selectedWordIndex = random.nextInt(wordlist.length);
            return wordlist[selectedWordIndex].toCharArray();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void fitLetter(String l) throws IllegalArgumentException, IllegalStateException{
        if(this.isGameOver()){
            throw new IllegalStateException("the game is over");
        }
        if(l.equals(new String(this.guessWord))){
            this.wordBoard = this.guessWord;
            return;
        }
        if(l.length()>1 && !l.equals(this.guessWord)){
            this.chancesLeft -=1;
            return;
        }
        int count = 0;
        char lowercaseL = Character.toLowerCase(l.charAt(0));
        if(new String(this.wordBoard).indexOf(lowercaseL) !=-1){
            throw new IllegalArgumentException("Already exist");
        }
        for(int i =0; i < this.guessWord.length; i++){
            if(this.guessWord[i] == lowercaseL){
                this.wordBoard[i]=lowercaseL;
                count += 1;
            }
        }
        if(count == 0){
            this.chancesLeft -= 1;
        }
    }

    @Override
    public int getChancesLeft() {
        return this.chancesLeft;
    }

    @Override
    public String getWordBoard() {
        return new String(this.wordBoard).replaceAll(".(?!$)", "$0 ");
    }

    @Override
    public String getGuessWord() {
        return new String(this.guessWord);
    }

    @Override
    public boolean isGameOver() {
        if(this.chancesLeft==0){
            return true;
        }
        for(char i: this.wordBoard){
            if(i=='_'){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean getWinOrNot() {
        for(char i: this.wordBoard){
            if(i=='_'){
                return false;
            }
        }
        return true;
    }

}
