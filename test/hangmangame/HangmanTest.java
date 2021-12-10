package hangmangame;

import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test cases for the hangman model. Verifying that game state is properly managed, and
 * all game actions are properly validated.
 */
public class HangmanTest {

    private Hangman game1, game2, game3;

    /**
     * set up a new game
     */
    @Before
    public void setUp() {
        game1 = new HangmanModel("code");
        game2 = new HangmanModel("happy");
        game3 = new HangmanModel("hi");
    }

    /**
     * test when the game wins with uppercase letter or lowercase letter
     */
    @Test
    public void testWinTheGame() {
        game1.fitLetter("a");
        assertEquals("_ _ _ _", game1.getWordBoard());
        assertEquals("code", game1.getGuessWord());
        assertEquals(7,game1.getChancesLeft());
        assertFalse(game1.isGameOver());
        assertFalse(game1.getWinOrNot());
        game1.fitLetter("c");
        assertEquals("c _ _ _", new String(game1.getWordBoard()));
        assertEquals(7,game1.getChancesLeft());
        assertFalse(game1.isGameOver());
        assertFalse(game1.getWinOrNot());
        game1.fitLetter("E");
        assertEquals("c _ _ e", new String(game1.getWordBoard()));
        assertEquals(7,game1.getChancesLeft());
        assertFalse(game1.isGameOver());
        assertFalse(game1.getWinOrNot());
        game1.fitLetter("o");
        assertEquals("c o _ e", new String(game1.getWordBoard()));
        assertEquals(7,game1.getChancesLeft());
        assertFalse(game1.isGameOver());
        assertFalse(game1.getWinOrNot());
        game1.fitLetter("a");
        assertEquals("c o _ e", new String(game1.getWordBoard()));
        assertEquals(6,game1.getChancesLeft());
        assertFalse(game1.isGameOver());
        assertFalse(game1.getWinOrNot());
        game1.fitLetter("l");
        assertEquals("c o _ e", new String(game1.getWordBoard()));
        assertEquals(5,game1.getChancesLeft());
        assertFalse(game1.isGameOver());
        assertFalse(game1.getWinOrNot());
        game1.fitLetter("D");
        assertEquals("c o d e", new String(game1.getWordBoard()));
        assertEquals(5,game1.getChancesLeft());
        assertEquals("code", game1.getGuessWord());
        assertTrue(game1.isGameOver());
        assertTrue(game1.getWinOrNot());
    }

    /**
     * test win the game fails and fitLetter method throws exceptions when game is over
     */

    @Test
    public void testLoseGame() {
        game3.fitLetter("a");
        assertEquals("_ _", new String(game3.getWordBoard()));
        assertEquals("hi", game3.getGuessWord());
        assertEquals(7,game3.getChancesLeft());
        assertFalse(game3.isGameOver());
        assertFalse(game3.getWinOrNot());
        game3.fitLetter("b");
        assertEquals("_ _", new String(game3.getWordBoard()));
        assertEquals(6,game3.getChancesLeft());
        assertFalse(game3.isGameOver());
        assertFalse(game3.getWinOrNot());
        game3.fitLetter("m");
        assertEquals("_ _", new String(game3.getWordBoard()));
        assertEquals(5,game3.getChancesLeft());
        assertFalse(game3.isGameOver());
        assertFalse(game3.getWinOrNot());
        game3.fitLetter("e");
        assertEquals("_ _", new String(game3.getWordBoard()));
        assertEquals(4,game3.getChancesLeft());
        assertFalse(game3.isGameOver());
        assertFalse(game3.getWinOrNot());
        game3.fitLetter("t");
        assertEquals("_ _", new String(game3.getWordBoard()));
        assertEquals(3,game3.getChancesLeft());
        assertFalse(game3.isGameOver());
        assertFalse(game3.getWinOrNot());
        game3.fitLetter("u");
        assertEquals("_ _", new String(game3.getWordBoard()));
        assertEquals(2,game3.getChancesLeft());
        assertFalse(game3.isGameOver());
        assertFalse(game3.getWinOrNot());
        game3.fitLetter("p");
        assertEquals("_ _", new String(game3.getWordBoard()));
        assertEquals(1,game3.getChancesLeft());
        assertFalse(game3.isGameOver());
        assertFalse(game3.getWinOrNot());
        game3.fitLetter("h");
        assertEquals("h _", new String(game3.getWordBoard()));
        assertEquals(1,game3.getChancesLeft());
        assertFalse(game3.isGameOver());
        assertFalse(game3.getWinOrNot());
        game3.fitLetter("z");
        assertEquals("h _", new String(game3.getWordBoard()));
        assertEquals(0,game3.getChancesLeft());
        assertTrue(game3.isGameOver());
        assertFalse(game3.getWinOrNot());
        try{
            game3.fitLetter("e");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * test if throws exception when
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetWordBoard() {
        game2.fitLetter("a");
        game2.fitLetter("a");
    }

    /**
     * test if guess two duplicate letters will show the same time
     */
    @Test
    public void testDuplicateLetter() {
        game2.fitLetter("h");
        assertEquals("h _ _ _ _", new String(game2.getWordBoard()));
        assertEquals("happy", game2.getGuessWord());
        assertEquals(8,game2.getChancesLeft());
        assertFalse(game2.isGameOver());
        assertFalse(game2.getWinOrNot());
        game2.fitLetter("p");
        assertEquals("h _ p p _", new String(game2.getWordBoard()));
        assertEquals(8,game2.getChancesLeft());
        assertFalse(game2.isGameOver());
        assertFalse(game2.getWinOrNot());
        game2.fitLetter("a");
        assertEquals("h a p p _", new String(game2.getWordBoard()));
        assertEquals(8,game2.getChancesLeft());
        assertFalse(game2.isGameOver());
        assertFalse(game2.getWinOrNot());
        game2.fitLetter("y");
        assertEquals("h a p p y", new String(game2.getWordBoard()));
        assertEquals(8,game2.getChancesLeft());
        assertTrue(game2.isGameOver());
        assertTrue(game2.getWinOrNot());
    }

    /**
     * test if guess the whole word at one time
     */
    @Test
    public void testGuessOneWord() {
        game3.fitLetter("hidsdf");
        assertEquals("_ _", new String(game3.getWordBoard()));
        assertEquals("hi", game3.getGuessWord());
        assertEquals(7,game3.getChancesLeft());
        assertFalse(game3.isGameOver());
        assertFalse(game3.getWinOrNot());
        game3.fitLetter("hi");
        assertEquals("h i", new String(game3.getWordBoard()));
        assertEquals(7,game3.getChancesLeft());
        assertTrue(game3.isGameOver());
        assertTrue(game3.getWinOrNot());
    }
}