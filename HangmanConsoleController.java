package hangmangame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Create a class HangmanConsoleController implementing the HangmanController interface with two fields input and output
 */
public class HangmanConsoleController implements HangmanController, ActionListener {
    private final IHangmanGUI view;
    private Hangman model;


    /**
     * Constructor based on GUI
     */
    public HangmanConsoleController(Hangman model, IHangmanGUI view) throws IllegalArgumentException{
        if(model == null || view == null){
            throw new IllegalArgumentException("model is null");
        }
        this.model = model;
        this.view = view;
        this.view.setListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()) {
            case "Check Button" -> {
                if(this.view.getWordBoard() == "wordboard"){
                    this.view.setResult("<html><font size = 4>Click the <font color = red>New Game</font> button</font></html>");
                    break;
                }
                this.view.setResult(this.controlGame(this.model, this.view));
                this.view.setWordBoard(model.getWordBoard());
                this.view.setChancesLeft(model.getChancesLeft());
                this.view.setPic(model.getChancesLeft());
                this.view.clearInputString();
            }
            case "New Game Button" -> {
                this.model = new HangmanModel();
                this.view.setWordBoard(model.getWordBoard());
                this.view.setChancesLeft(model.getChancesLeft());
                this.view.setResult("");
                this.view.clearInputString();
                this.view.clearPic();
            }
            case "Quit Button" -> System.exit(0);
        }
    }

    @Override
    public String controlGame(Hangman m, IHangmanGUI v){
        if(!m.isGameOver()){
            String s = v.getInputLetter();
            if(!s.matches("[A-Za-z]+")){
                return "Not a letter";
            }
            try{
                m.fitLetter(s);
            }
            catch (Exception e){
                return "Letter already exist";
            }
        }
        if(m.isGameOver()){
            if(m.getWinOrNot()){
                return "<html><font size = 12 color = red>You win!</font></html>";
            }
            else{
                return "<html>You lose!<br>" + "The word is "+"<font size = 12 color = red>" +m.getGuessWord()+"</font>!</html>";
            }
        }
        return "";
    }

}
