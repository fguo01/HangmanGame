package hangmangame;

/**
 * A single game of hangman, played on a word board with one player.
 * Each low dash represents a letter of the word needed to guess.
 * The player only got 8 chances win or lose.
 */
public interface Hangman {

    /**
     * start a new game with picking a new guess word from the wordlist
     * @return a random word needed to guess from the wordlist
     */

    /**
     * verify a letter to see if the letter exists in the guess word
     * then replace its position with the letter or lose one chance with no board refresh
     *
     * @param l the letter the player input
     * //@return true if the letter is in the guess word or false if not
     * @throws IllegalArgumentException if l is not a letter
     * @throws IllegalStateException if the game is over
     */
    void fitLetter(String l);


    /**
     * get the chances the player still have, i.e., the max chances is 8
     * guess wrong once, the chances less 1
     * @return the chances the player still have
     */
    int getChancesLeft();

    /**
     * return the current word board as a String.
     * A low dash indicates an empty position on the board
     * @return the current word board
     */
    String getWordBoard();

    /**
     * return the word needed to guess as a String.
     * @return the guessword
     */
    String getGuessWord();

    /**
     * return whether the game is over. The game is over when either the round is over 8 times
     * or the player has won.
     *
     * @return true if the game is over, false otherwise
     */
    boolean isGameOver();

    /**
     * return if the player wins or not. return win if the player wins, lose if the player lose
     * or the game is not over
     * @return true if the player wins, false otherwise
     */
    boolean getWinOrNot();

}
