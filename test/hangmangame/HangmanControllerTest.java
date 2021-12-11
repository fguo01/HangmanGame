package hangmangame;

import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import static org.junit.Assert.*;

/**
 * Test cases for the hangman controller, using mocks for readable and appendable.
 */
public class HangmanControllerTest {
    /**
     * test invalid constructor with null model
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidModel(){
        IHangmanGUI gameLog = new HangmanGUI("Hangman Game");
        HangmanConsoleController c = new HangmanConsoleController(null, gameLog);
    }

    /**
     * test invalid constructor with null view
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidView(){
        StringBuilder log = new StringBuilder();
        Hangman mockModel = new MockModel(log, true);
        HangmanConsoleController c = new HangmanConsoleController(mockModel, null);
    }

    /**
     * test the controller in isolation when mock model give the right response
     */
    @Test
    public void testMockModelResponse(){
        IHangmanGUI view = new MockView("m");
        StringBuilder log = new StringBuilder();
        Hangman mockModel = new MockModel(log, false);
        HangmanConsoleController c = new HangmanConsoleController(mockModel, view);
        c.controlGame(mockModel, view);
        assertEquals("input:m\n", log.toString());
    }

    /**
     * test the controller in isolation when controller method give the right response
     */
    @Test
    public void testControlGame(){
        IHangmanGUI view = new MockView("%");
        StringBuilder log = new StringBuilder();
        Hangman mockModel = new MockModel(log, false);
        HangmanConsoleController c = new HangmanConsoleController(mockModel, view);
        assertEquals("Not one letter",c.controlGame(mockModel, view));
    }

    /**
     * test the controller in isolation when controller method give the right response by input winning the game
     */
    @Test
    public void testControlGameMethod(){
        IHangmanGUI view = new MockView("a");
        StringBuilder log = new StringBuilder();
        Hangman mockModel = new MockModel(log, true);
        HangmanConsoleController c = new HangmanConsoleController(mockModel, view);
        assertEquals("You win!",c.controlGame(mockModel, view));
    }

}