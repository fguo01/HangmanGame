package hangmangame;

/**
 * Interface features to add method to connect view and controller together
 * the methods can be implemented in controller and use in view
 */
public interface Features {
    /**
     * to get the guess word from the model's guess word and output in the result
     */
    void getHint();
    /**
     * to disappear the guess word from the model's guess word and showcase in the result
     */
    void disappear();
}
