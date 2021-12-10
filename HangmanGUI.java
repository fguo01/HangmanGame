package hangmangame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import static javax.swing.SwingConstants.*;

public class HangmanGUI extends JFrame implements IHangmanGUI{
    private JPanel mainPanel;
    private JLabel gameLabel;
    private JTextField letterTextField;
    private JButton checkButton;
    private JButton newGameButton;
    private JButton quitButton;
    private JLabel boardLabel;
    private JLabel chanceLeftLabel;
    private JLabel resultLabel;
    private JLabel inputLabel;
    private JLabel chancesLabel;
    private JLabel chanceRightLabel;
    private JLabel imageLabel;


    public HangmanGUI(String title){
        super(title);
        this.setVisible(true);
        setLocation(400, 300);
        setResizable(true);
        this.setMinimumSize(new Dimension(300,410));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);

        imageLabel.setIcon(new ImageIcon(new ImageIcon(getImage(8)).getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),Image.SCALE_REPLICATE))) ;

        checkButton.setActionCommand("Check Button");
        newGameButton.setActionCommand("New Game Button");
        quitButton.setActionCommand("Quit Button");
        this.pack();
    }

    /**
     * Return the image needed by having the given address
     * @param a the pic name which can be made as the address
     * @return the image we needed
     */
    private Image getImage(int a){
        try{
            InputStream imageStream = getClass().getResourceAsStream("/pics/"+String.valueOf(a)+".jpeg");
            assert imageStream != null;
            return ImageIO.read(imageStream);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setWordBoard(String s) {
        boardLabel.setText(s);
    }

    @Override
    public void setChancesLeft(int a) {
        chancesLabel.setText(String.valueOf(a));
    }

    @Override
    public void setPic(int a){
        imageLabel.setIcon(new ImageIcon(new ImageIcon(getImage(a)).getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),Image.SCALE_REPLICATE))) ;
    }

    @Override
    public void setResult(String s) {
        resultLabel.setText(s);
    }

    @Override
    public String getInputLetter() {
        return letterTextField.getText();
    }

    @Override
    public String getWordBoard() {
        return boardLabel.getText();
    }

    @Override
    public void clearInputString() {
        letterTextField.setText("");
    }

    @Override
    public void clearPic(){
        imageLabel.setIcon(new ImageIcon(new ImageIcon(getImage(8)).getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),Image.SCALE_REPLICATE))) ;
    }

    @Override
    public void setListener(ActionListener listener) {
        checkButton.addActionListener(listener);
        newGameButton.addActionListener(listener);
        quitButton.addActionListener(listener);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
