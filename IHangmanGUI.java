package hangmangame;

import java.awt.event.ActionListener;

/**
 * The interface for our view class
 */
public interface IHangmanGUI {
    /**
     * Set the label that is showing the word board status
     */
    void setWordBoard(String s);

    /**
     * Set the label that is showing the chances left
     */
    void setChancesLeft(int a);

    /**
     * Set the pic that is showing the pic of hangman
     */
    void setPic(int a);

    /**
     * Set the label that is showing the result of the game
     */
    void setResult(String s);

    /**
     * Get the string from the text field and return it
     */
    String getInputLetter();

    /**
     * Get the text from the board label and return it
     */
    String getWordBoard();

    /**
     * Clear the text field. Note that a more general "setInputString" would work for this purpose but
     * would be incorrect. This is because the text field is not set programmatically in general but
     * input by the user.
     */
    void clearInputString();

    /**
     * Clear all the pics
     */
    void clearPic();

    /**
     * Set the listener for any actions.
     */
    void setListener(ActionListener listener);

}
