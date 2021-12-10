package hangmangame;

/**
 * Represent a Controller for Hangman: handle user inputs by executing them using the model;
 * convey the result to the user in some form.
 */
public interface HangmanController {

    /**
     * Execute a single game of hangman given a hangman Model. When the game is quited,
     * the playGame method ends.
     *
     * @param m a non-null hangman Model
     * @return the result string needed to append by the view
     */
    String controlGame(Hangman m, IHangmanGUI v);

}
