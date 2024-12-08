import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    Label(){
        super("Memory Card Game");
        ImageIcon background= new ImageIcon("Java Project Assets/background.jpg");
        setIcon(background);
        setHorizontalTextPosition(JLabel.CENTER);
        setVerticalTextPosition(JLabel.TOP);
        setIconTextGap(-120);
        setForeground(new Color(119, 177, 218));
        setFont(new Font("Arial Hebrew", Font.ITALIC | Font.BOLD, 30));
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
        setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        buttonadder();

    }
    private void buttonadder(){
        Start startButton = new Start();
        SelectLevel selectLevelButton = new SelectLevel();
        Instructions instructionsButton = new Instructions();
        Exit exitButton = new Exit();

        // Manually setting bounds for each button
        startButton.setBounds(300, 150, 125, 30);
        selectLevelButton.setBounds(300, 200, 125, 30);
        instructionsButton.setBounds(300, 250, 125, 30);
        exitButton.setBounds(300, 300, 125, 30);

        add(startButton);
        add(selectLevelButton);
        add(instructionsButton);
        add(exitButton);
    }
}
