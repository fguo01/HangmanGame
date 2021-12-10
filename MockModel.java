package hangmangame;

/**
 * Create a mock model class to test hangman controller separately with two fields inpurt and output
 */
public class MockModel implements Hangman{

    private StringBuilder log;
    private final boolean unique;

    public MockModel(StringBuilder log, boolean unique){
        this.log = log;
        this.unique = unique;
    }

    @Override
    public void fitLetter(String l) {
        this.log.append("input:"+l+"\n");
    }

    @Override
    public int getChancesLeft() {
        return 0;
    }

    @Override
    public String getWordBoard() {
        return null;
    }

    @Override
    public String getGuessWord() {
        return null;
    }

    @Override
    public boolean isGameOver() {
        return unique;
    }

    @Override
    public boolean getWinOrNot() {
        return unique;
    }
}
