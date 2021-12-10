package hangmangame;

import java.io.InputStreamReader;

/**
 * Run a Hangman game interactively on the console.
 */
public class Main {
    /**
     * Run a Hangman game interactively on the console.
     */
    public static void main(String[] args) {
        Hangman model = new HangmanModel();
        IHangmanGUI view = new HangmanGUI("Hangman Game");
        HangmanController controller = new HangmanConsoleController(model, view);
    }
}