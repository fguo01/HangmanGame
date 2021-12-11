package hangmangame;

import java.awt.event.ActionListener;

public class MockView implements IHangmanGUI{
    private String input;
    public MockView(String input){
        this.input = input;
    }

    @Override
    public void setWordBoard(String s) {
        return;
    }

    @Override
    public void setChancesLeft(int a) {
        return;
    }

    @Override
    public void setPic(int a) {
        return;
    }

    @Override
    public void setResult(String s) {
        return;
    }

    @Override
    public String getInputLetter() {
        return this.input;
    }

    @Override
    public String getWordBoard() {
        return "";
    }

    @Override
    public void addFeatures(Features features) {
        return;
    }

    @Override
    public void clearInputString() {
        return;
    }

    @Override
    public void clearPic() {
        return;
    }

    @Override
    public void setListener(ActionListener listener) {
        return;
    }
}
